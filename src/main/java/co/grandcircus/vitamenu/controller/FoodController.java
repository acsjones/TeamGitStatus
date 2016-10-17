package co.grandcircus.vitamenu.controller;


import java.io.UnsupportedEncodingException;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.vitamenu.rest.FoodService;




@Controller
public class FoodController {
	private static final Logger logger = LoggerFactory.getLogger(FoodController.class);

	@Autowired
	private FoodService foodservice;

	@RequestMapping("/food")// Looks for the url that ends like /food
	// It looks for the parameter q and it uses it as the variable q.
        public String home(Locale locale, Model model, @RequestParam("q") String q) throws UnsupportedEncodingException {
		// q is then passed into the method that returns recipe information from the API and stores it in the variable to be used by the jsp
		model.addAttribute("foodList", foodservice.getCurrentRecipe(q));
		logger.info("/food -> recipe-list.jsp");//choosing the view recipe-list.jsp
		return "recipe-list";

	}

}