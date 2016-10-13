package co.grandcircus.vitamenu.rest;

import java.io.BufferedReader;
import java.io.IOException;
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
	private final static String q = "broccoli";
	

	public ArrayList<Food> getCurrentRecipe() {
		return getRecipe(key,q);
	}

	public ArrayList<Food> getRecipe(String key, String q) {
		String url = "http://food2fork.com/api/search?key=" + key + "&q=" + q;

		try (BufferedReader reader = HttpHelper.doGet(url)) {
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}

			JsonElement root = new JsonParser().parse(reader);
			JsonArray foods = root.getAsJsonObject().get("recipes").getAsJsonArray();

			ArrayList<Food> foodList = new ArrayList<Food>();

			for (int i = 0; i < foods.size(); i++) {

				Food food = new Food();
				food.setTitle(foods.get(i).getAsJsonObject().get("title").getAsString());
				food.setImage(foods.get(i).getAsJsonObject().get("image_url").getAsString());
				
				foodList.add(food);

			}

			return foodList;

		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

}