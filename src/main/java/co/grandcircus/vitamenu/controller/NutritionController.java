package co.grandcircus.vitamenu.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.vitamenu.rest.NutritionService;
/**
 * 
 * @author Pappu
 *
 */

@Controller
public class NutritionController {
	private static final Logger logger = LoggerFactory.getLogger(NutritionController.class);

	@Autowired
	private NutritionService nutritionservice;
/**
 * 
 * @param locale
 * @param model
 * @param q
 * @return
 */
	
	@RequestMapping("/nutrition")// Looks for the url that ends like /nutrition
	public String home(Locale locale, Model model,@RequestParam("search") String q) { // It looks for the parameter search and it uses it as the variable q.
		model.addAttribute("nutritionList", nutritionservice.getCurrentNutritions(q));// q is then passed into the method that returns nutrition information from the API and stores it in the variable to be used by the jsp
		logger.info("/nutrition -> nutrition.jsp");
		return "nutrition";//choosing the view nurtition.jsp
	}

}


