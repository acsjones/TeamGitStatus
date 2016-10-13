package co.grandcircus.vitamenu.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.vitamenu.rest.FoodService;




@Controller
public class FoodController {
	private static final Logger logger = LoggerFactory.getLogger(FoodController.class);

	@Autowired
	private FoodService foodservice;

	@RequestMapping("/food")
	public String home(Locale locale, Model model) {
		model.addAttribute("foodList", foodservice.getCurrentRecipe());
		logger.info("/food -> food.jsp");
		return "food";
	}

}