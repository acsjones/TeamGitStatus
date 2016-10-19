package co.grandcircus.vitamenu.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.grandcircus.vitamenu.model.Nutrition;


@Service
public class NutritionService {

	@Value("${api.key}")
	private String key;
	
	@Value("${api.id}")
	private String appid;
	
	private String q = "" ; 
	public ArrayList<Nutrition> getCurrentNutritions(String q) {
		try {
			return getNutritionAt(key,appid,q);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Nutrition> getNutritionAt(String key , String appid, String q) throws UnsupportedEncodingException {
		
			
			String item = URLEncoder.encode(q , "UTF-8");
			String url = "https://api.edamam.com/search?q="+ item + "&app_id=" + appid + "&app_key=" + key;
		
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
				nutrition.setUrl(fields.getAsJsonObject().get("url").getAsString());
				nutrition.setCalories(fields.getAsJsonObject().get("calories").getAsInt());
				nutrition.setYield(fields.getAsJsonObject().get("yield").getAsInt());
				nutrition.setCalPerServing((fields.getAsJsonObject().get("calories").getAsInt()) /(fields.getAsJsonObject().get("yield").getAsInt()));
				JsonObject fields2 = fields.getAsJsonObject().get("totalNutrients").getAsJsonObject();
				JsonObject fields22 = fields.getAsJsonObject().get("totalDaily").getAsJsonObject();
				 DecimalFormat df = new DecimalFormat("#.##");
				try {
					JsonObject fields3 = fields2.getAsJsonObject().get("VITA_RAE").getAsJsonObject();
					double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
					String fields5 = df.format(fields4);
					nutrition.setVitA(fields5);
					
					JsonObject fields33 = fields22.getAsJsonObject().get("VITA_RAE").getAsJsonObject();
					double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
					String fields55 = df.format(fields44);
					nutrition.setVitAPer(fields55 + "%");
				} catch (NullPointerException ex) {
					String fields33 ="0";
					String fields3 = "0";
					nutrition.setVitA(fields3);
				}
			try {
					JsonObject fields3 = fields2.getAsJsonObject().get("THIA").getAsJsonObject();
					double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
					String fields5 = df.format(fields4);
					nutrition.setVitB(fields5);
					
					JsonObject fields33 = fields22.getAsJsonObject().get("THIA").getAsJsonObject();
					double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
					String fields55 = df.format(fields44);
					nutrition.setVitBPer(fields55 + "%");
				} catch (NullPointerException ex) {
					String fields33 ="0";
					String fields3 = "0";
					nutrition.setVitB(fields3);
					nutrition.setVitBPer(fields33 + "%");
				}
			
			try {
				JsonObject fields3 = fields2.getAsJsonObject().get("RIBF").getAsJsonObject();
				double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
				String fields5 = df.format(fields4);
				nutrition.setVitB2(fields5);
				
				JsonObject fields33 = fields22.getAsJsonObject().get("RIBF").getAsJsonObject();
				double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
				String fields55 = df.format(fields44);
				nutrition.setVitB2Per(fields55 + "%");
			} catch (NullPointerException ex) {
				String fields33 ="0";
				String fields3 = "0";
				nutrition.setVitB2(fields3);
				nutrition.setVitB2Per(fields33 + "%");
			}
			try {
				JsonObject fields3 = fields2.getAsJsonObject().get("NIA").getAsJsonObject();
				double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
				String fields5 = df.format(fields4);
				nutrition.setVitB3(fields5);
				
				JsonObject fields33 = fields22.getAsJsonObject().get("NIA").getAsJsonObject();
				double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
				String fields55 = df.format(fields44);
				nutrition.setVitB3Per(fields55 + "%");
			} catch (NullPointerException ex) {
				String fields33 ="0";
				String fields3 = "0";
				nutrition.setVitB3(fields3);
				nutrition.setVitB3Per(fields33 + "%");
			}
		
			try {
				JsonObject fields3 = fields2.getAsJsonObject().get("VITB6A").getAsJsonObject();
				double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
				String fields5 = df.format(fields4);
				nutrition.setVitB6(fields5);
				
				JsonObject fields33 = fields22.getAsJsonObject().get("VITB6A").getAsJsonObject();
				double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
				String fields55 = df.format(fields44);
				nutrition.setVitB6Per(fields55 + "%");
			} catch (NullPointerException ex) {
				String fields33 ="0";
				String fields3 = "0";
				nutrition.setVitB6(fields3);
				nutrition.setVitB6Per(fields33 + "%");
			}
			
			try {
				JsonObject fields3 = fields2.getAsJsonObject().get("FOL").getAsJsonObject();
				double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
				String fields5 = df.format(fields4);
				nutrition.setVitB9(fields5);
				
				JsonObject fields33 = fields22.getAsJsonObject().get("FOL").getAsJsonObject();
				double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
				String fields55 = df.format(fields44);
				nutrition.setVitB9Per(fields55 + "%");
			} catch (NullPointerException ex) {
				String fields33 ="0";
				String fields3 = "0";
				nutrition.setVitB9(fields3);
				nutrition.setVitB9Per(fields33 + "%");
			}
			try {
				JsonObject fields3 = fields2.getAsJsonObject().get("VITB12").getAsJsonObject();
				double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
				String fields5 = df.format(fields4);
				nutrition.setVitB12(fields5);
				
				JsonObject fields33 = fields22.getAsJsonObject().get("VITB12").getAsJsonObject();
				double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
				String fields55 = df.format(fields44);
				nutrition.setVitB12Per(fields55 + "%");
			} catch (NullPointerException ex) {
				String fields33 ="0";
				String fields3 = "0";
				nutrition.setVitB12(fields3);
				nutrition.setVitB12Per(fields33 + "%");
			}
			try {
				JsonObject fields3 = fields2.getAsJsonObject().get("VITC").getAsJsonObject();
				double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
				String fields5 = df.format(fields4);
				nutrition.setVitC(fields5);
				
				JsonObject fields33 = fields22.getAsJsonObject().get("VITC").getAsJsonObject();
				double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
				String fields55 = df.format(fields44);
				nutrition.setVitCPer(fields55 + "%");
			} catch (NullPointerException ex) {
				String fields33 ="0";
				String fields3 = "0";
				nutrition.setVitC(fields3);
				nutrition.setVitCPer(fields33 + "%");
			}
			try {
				JsonObject fields3 = fields2.getAsJsonObject().get("VITD").getAsJsonObject();
				double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
				String fields5 = df.format(fields4);
				nutrition.setVitD(fields5);
				
				JsonObject fields33 = fields22.getAsJsonObject().get("VITD").getAsJsonObject();
				double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
				String fields55 = df.format(fields44);
				nutrition.setVitDPer(fields55 + "%");
			} catch (NullPointerException ex) {
				String fields33 ="0";
				String fields3 = "0";
				nutrition.setVitD(fields3);
				nutrition.setVitDPer(fields33 + "%");
			}
			try {
				JsonObject fields3 = fields2.getAsJsonObject().get("TOCPHA").getAsJsonObject();
				double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
				String fields5 = df.format(fields4);
				nutrition.setVitE(fields5);
				
				JsonObject fields33 = fields22.getAsJsonObject().get("TOCPHA").getAsJsonObject();
				double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
				String fields55 = df.format(fields44);
				nutrition.setVitEPer(fields55 + "%");
			} catch (NullPointerException ex) {
				String fields33 ="0";
				String fields3 = "0";
				nutrition.setVitE(fields3);
				nutrition.setVitEPer(fields33 + "%");
			}
			try {
				JsonObject fields3 = fields2.getAsJsonObject().get("VITK1").getAsJsonObject();
				double fields4 = fields3.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt());
				String fields5 = df.format(fields4);
				nutrition.setVitK(fields5);
				
				JsonObject fields33 = fields22.getAsJsonObject().get("VITK1").getAsJsonObject();
				double fields44 = Math.round(fields33.getAsJsonObject().get("quantity").getAsDouble()/(fields.getAsJsonObject().get("yield").getAsInt()));
				String fields55 = df.format(fields44);
				nutrition.setVitKPer(fields55 + "%");
			} catch (NullPointerException ex) {
				String fields33 ="0";
				String fields3 = "0";
				nutrition.setVitK(fields3);
				nutrition.setVitKPer(fields33 + "%");
			}
				nutritionList.add(nutrition);
			}

			return nutritionList;

		} catch (IOException ex) {
			throw new RuntimeException("Error reading from URL: " + url, ex);
		}
	}

}