package co.grandcircus.vitamenu.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.vitamenu.dao.VitaminDao;
import co.grandcircus.vitamenu.model.Vitamin;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DualController {

	private static final Logger logger = LoggerFactory.getLogger(DualController.class);

	@Autowired
	private VitaminDao vitaminDao;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/vitamins") 

	public String listVitamins(Model model, @RequestParam(value = "sort", required = false) String sort) {
		List<Vitamin> vitamins = null;

		if (sort == null) {

			vitamins = vitaminDao.getAllVitamins();
		} else {
			try {
				vitamins = vitaminDao.getAllVitaminsSortedBy(sort);
			} catch (IllegalArgumentException ex) {
				logger.warn(ex.getMessage());
				vitamins = vitaminDao.getAllVitamins();
			}
		}
		model.addAttribute("vitamins", vitamins);

		logger.info("/-> dual.jsp");
		return "dual";
	}

	@RequestMapping(value = "/vitamins/{vitamin_key}", method = RequestMethod.GET)
	public String displayVitamin(@PathVariable int vitamin_key, Model model) {
		model.addAttribute("vitamin_key", vitamin_key);
		model.addAttribute("vitamin", vitaminDao.getVitamin(vitamin_key));
		System.out.println(vitaminDao.getVitamin(vitamin_key));
		logger.info("GET /vitamins/" + vitamin_key + " -> vitamin.jsp");
		return "vitamin";

	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Vitamin> vitamins = null;

		

			vitamins = vitaminDao.getAllVitamins();
		
		model.addAttribute("vitamins", vitamins);

		logger.info("/-> dual.jsp");
		return "dual";
	}
	@RequestMapping(value = "/vitamins/add", method = RequestMethod.POST)
	public String addFood(Model model,@RequestParam(value="vitaminname")String vitaminname,
			@RequestParam(value="food")String addFood,
			@RequestParam(value="vitaminkey")Integer key) {
		Vitamin vitamin = new Vitamin();
		System.out.println(key);
		
		vitaminDao.addFoodItem( vitaminname , addFood );
		model.addAttribute("vitamin", vitamin);
		model.asMap().clear();
		String page = "redirect:/vitamins/";
		page += key;
		//logger.info("POST /vitamins/" + vitamin_key + " -> vitamin.jsp");
		return page;
	}
	
}