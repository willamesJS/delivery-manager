package br.com.challenge.gwsystems.deliverymanager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(path = "/")
public class DeliveryController {
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView page = new ModelAndView();
		page.setViewName("index");

		return page;
	}

	@GetMapping(path = "/gw-systems")
	public ModelAndView indexList() {
		ModelAndView page = new ModelAndView();
		page.setViewName("index");

		return page;
	}

}
