package co.grandcircus.vitamenu.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.vitamenu.dao.VitaminDao;
import co.grandcircus.vitamenu.model.Vitamin;


@Controller
public class VitaminController {
	
	private static final Logger logger = LoggerFactory.getLogger(VitaminController.class);
	
	@Autowired
	private VitaminDao vitaminDao;
	
	
	@RequestMapping("/vitamin")
	public String listVitamins(Model model, @RequestParam(value = "sort", required = false) String sort) {
		List<Vitamin> vitamin;
		
		if (sort == null) {
			vitamin = vitaminDao.getAllVitamins();
		} else {
			try {
				vitamin = vitaminDao.getAllVitaminsSortedBy(sort);
			} catch (IllegalArgumentException ex) {
				logger.warn(ex.getMessage());
				vitamin = vitaminDao.getAllVitamins();
			}
		}
		model.addAttribute("vitamin", vitamin);
		

		logger.info("/vitamin -> vitamin-list.jsp");
		return "vitamin-list";
	}
}