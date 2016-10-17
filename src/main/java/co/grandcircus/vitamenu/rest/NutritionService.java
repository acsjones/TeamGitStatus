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

import co.grandcircus.vitamenu.model.Nutrition;


@Service
public class NutritionService {
	private final static String key = "07ba45c932a213aceb4d9a96b03fdde3";
	private String q = "" ; 
	public ArrayList<Nutrition> getCurrentNutritions(String q) {
		try {
			return getNutritionAt(key,q);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Nutrition> getNutritionAt(String key , String q) throws UnsupportedEncodingException {
		
			
			String item = URLEncoder.encode(q , "UTF-8");
			String url = "https://api.nutritionix.com/v1_1/search/"+ item + "?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat&appId=11efd554&appKey=" + key;
		
		try (BufferedReader reader = HttpHelper.doGet(url)) {
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}

			JsonElement root = new JsonParser().parse(reader);
			JsonArray nutritions = root.getAsJsonObject().get("hits").getAsJsonArray();

			ArrayList<Nutrition> nutritionList = new ArrayList<Nutrition>();

			for (JsonElement jo : nutritions) {

				Nutrition nutrition = new Nutrition();
				JsonObject fields = jo.getAsJsonObject().get("fields").getAsJsonObject();
				nutrition.setName(fields.getAsJsonObject().get("item_name").getAsString());
				nutrition.setCalories(fields.getAsJsonObject().get("nf_calories").getAsString());
				nutrition.setTotal_fat(fields.getAsJsonObject().get("nf_total_fat").getAsString());
				nutritionList.add(nutrition);

			}

			return nutritionList;

		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

}