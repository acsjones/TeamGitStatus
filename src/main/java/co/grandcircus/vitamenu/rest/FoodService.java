package co.grandcircus.vitamenu.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.grandcircus.vitamenu.model.Food;


@Service
public class FoodService {
	private final static String key = "5a0556a87cde1bc675b4dc3a0cc3064b";
	private final static String appid = "94a09daf"; 
	//private static String q = "";
	

	public ArrayList<Food> getCurrentRecipe(String q) {
		try {
			return getRecipe(q,key,appid);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Food> getRecipe(String q,String key, String appid) throws UnsupportedEncodingException {
		
		String item = URLEncoder.encode(q, "UTF-8");
		String url = "https://api.edamam.com/search?q=" + item + "&app_id=" + appid + "&app_key=" + key;

		try (BufferedReader reader = HttpHelper.doGet(url)) {
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}

			JsonElement root = new JsonParser().parse(reader);
			JsonArray foods = root.getAsJsonObject().get("hits").getAsJsonArray();

			ArrayList<Food> foodList = new ArrayList<Food>();

			for (JsonElement something : foods) {

				Food food = new Food();
				JsonObject recipes = something.getAsJsonObject().get("recipe").getAsJsonObject();
				food.setTitle(recipes.getAsJsonObject().get("label").getAsString());
				food.setImage(recipes.getAsJsonObject().get("image").getAsString());
				food.setSource(recipes.getAsJsonObject().get("url").getAsString());
				foodList.add(food);
			}

			return foodList;

		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

}