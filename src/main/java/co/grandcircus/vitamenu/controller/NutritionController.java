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


@Controller
public class NutritionController {
	private static final Logger logger = LoggerFactory.getLogger(NutritionController.class);

	@Autowired
	private NutritionService nutritionservice;

	@RequestMapping("/nutrition")
	public String home(Locale locale, Model model) {
		model.addAttribute("nutritionList", nutritionservice.getCurrentNutritions());
		logger.info("/nutrition -> nutrition.jsp");
		return "nutrition";
	}

}


