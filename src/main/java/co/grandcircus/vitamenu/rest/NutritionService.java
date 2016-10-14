package co.grandcircus.vitamenu.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.grandcircus.vitamenu.model.Nutrition;


@Service
public class NutritionService {
	private final static String key = "07ba45c932a213aceb4d9a96b03fdde3";
	
	public ArrayList<Nutrition> getCurrentNutritions() {
		return getNutritionAt(key);
	}

	public ArrayList<Nutrition> getNutritionAt(String key) {
		String url = "https://api.nutritionix.com/v1_1/search/cheddar%20cheese?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat&appId=[11efd554]&appKey=" + key;

		try (BufferedReader reader = HttpHelper.doGet(url)) {
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}

			JsonElement root = new JsonParser().parse(reader);
			JsonArray nutritions = root.getAsJsonObject().get("fields").getAsJsonArray();

			ArrayList<Nutrition> nutritionList = new ArrayList<Nutrition>();

			for (int i = 0; i < nutritions.size(); i++) {

				Nutrition nutrition = new Nutrition();
				nutrition.setName(nutritions.get(i).getAsJsonObject().get("item_name").getAsString());
				nutrition.setCalories(nutritions.get(i).getAsJsonObject().get("Cnf_calories").getAsString());
				nutrition.setTotal_fat(nutritions.get(i).getAsJsonObject().get("Cnf_total_fat").getAsString());
				nutritionList.add(nutrition);

			}

			return nutritionList;

		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

}