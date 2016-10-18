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
	private final static String key = "5a0556a87cde1bc675b4dc3a0cc3064b";
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
			String url = "https://api.edamam.com/search?q="+ item + "&app_id=94a09daf&app_key=" + key;
		
		try (BufferedReader reader = HttpHelper.doGet(url)) {
			if (reader == null) {
				throw new RuntimeException("Not found: " + url);
			}

			JsonElement root = new JsonParser().parse(reader);
			JsonArray nutritions = root.getAsJsonObject().get("hits").getAsJsonArray();

			ArrayList<Nutrition> nutritionList = new ArrayList<Nutrition>();

			for (JsonElement jo : nutritions) {

				Nutrition nutrition = new Nutrition();
				JsonObject fields = jo.getAsJsonObject().get("recipe").getAsJsonObject();
				nutrition.setName(fields.getAsJsonObject().get("label").getAsString());
				nutrition.setCalories(fields.getAsJsonObject().get("calories").getAsString());
				JsonObject fields2 = fields.getAsJsonObject().get("totalNutrients").getAsJsonObject();
				try {
					JsonObject fields3 = fields2.getAsJsonObject().get("VITA_RAE").getAsJsonObject();
					nutrition.setLabel(fields3.getAsJsonObject().get("label").getAsString());
				} catch (NullPointerException ex) {
					throw new RuntimeException("blah");
				}
				
				
				nutritionList.add(nutrition);

			}

			return nutritionList;

		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

}