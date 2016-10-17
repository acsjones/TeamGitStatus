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
	private final static String key = "00473fda64c043a59213adac4f59f9c2";
	//private static String q = "";
	

	public ArrayList<Food> getCurrentRecipe(String q) {
		try {
			return getRecipe(key,q);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Food> getRecipe(String key, String q) throws UnsupportedEncodingException {
		
		String item = URLEncoder.encode(q, "UTF-8");
		String url = "http://food2fork.com/api/search?key=" + key + "&q=" + item;
		// Use HTTP GET with the above URL
		try (BufferedReader reader = HttpHelper.doGet(url)) {// try with resources will auto close the reader
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}
			// parse the HTTP response body to JSON
			JsonElement root = new JsonParser().parse(reader);
			// pick the "recipes" key from the root JSON object.
			JsonArray foods = root.getAsJsonObject().get("recipes").getAsJsonArray();

			ArrayList<Food> foodList = new ArrayList<Food>();

			for (int i = 0; i < foods.size(); i++) {

				Food food = new Food();
				// pick the "title" key from the recipes object
				food.setTitle(foods.get(i).getAsJsonObject().get("title").getAsString());
				// pick the "image_url" key from the recipes object
				food.setImage(foods.get(i).getAsJsonObject().get("image_url").getAsString());
				// pick the "source_url" key from the recipes object
				food.setSource(foods.get(i).getAsJsonObject().get("source_url").getAsString());
				foodList.add(food);

			}

			return foodList;

		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

}