package br.com.challenge.gwsystems.deliverymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.challenge.gwsystems.deliverymanager.model.*;
import br.com.challenge.gwsystems.deliverymanager.repository.*;

@Controller
@RequestMapping(path = "/")
public class DeliveryController {

	@Autowired
	private DeliveryRepository mDeliveryDAO;

	@Autowired
	private ProductRepository mProductDAO;

	@Autowired
	private ClientRepository mClientDAO;

	@GetMapping
	public ModelAndView index() {
		ModelAndView page = getPage();
		page.setViewName("index");

		List<DeliveryModel> list = (List<DeliveryModel>) mDeliveryDAO.findAll();
		page.addObject("list", list);
		
		return page;
	}

	@GetMapping(path = "/gw-systems")
	public ModelAndView indexList() {
		ModelAndView page = getPage();
		page.setViewName("index");

		List<DeliveryModel> list = (List<DeliveryModel>) mDeliveryDAO.findAll();
		page.addObject("list", list);
		
		return page;
	}

	@GetMapping(path = "/gw-system/form-delivery/{id}")
	public ModelAndView formDelivery(@PathVariable("id") Long id) {
		ModelAndView page = getPage();
		page.setViewName("formDelivery");

		DeliveryModel mDelivery = new DeliveryModel();

		List<ProductModel> listProduct = (List<ProductModel>) mProductDAO.findAll();
		List<ClientModel> listClient = (List<ClientModel>) mClientDAO.findAll();
		ClientModel mClient = mClientDAO.findById(id).get();

		page.addObject("delivery_object", mDelivery);
		page.addObject("listProduct_object", listProduct);
		page.addObject("listClient_object", listClient);
		page.addObject("client_sender", mClient);

		return page;
	}

	@PostMapping("/gw-system/save")
	public String saveDelivery(DeliveryModel mDelivery) {	
		try {
			mDelivery.setStatus(""); 
			mDeliveryDAO.save(mDelivery);

		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}

		return "redirect:/gw-systems";
	}
	
	@GetMapping("gw-system/delete/{id}")
	public String deleteDelivery(@PathVariable("id") Long id) {	
		try {
			mDeliveryDAO.deleteById(id);
		} catch (Exception e) {
			System.out.println("Erro:" + e.getMessage());
		}
		
		return "redirect:/gw-systems";
	}
	
	@GetMapping("/gw-system/form-delivery/edit/{id}")
	public ModelAndView editDelivery(@PathVariable("id") Long id) {	
		ModelAndView page = getPage();
		page.setViewName("formEditDelivery");

		DeliveryModel mDelivery = mDeliveryDAO.findById(id).get();

		page.addObject("delivery_object", mDelivery);
		return page;
	}

	public ModelAndView getPage() {

		return new ModelAndView();
	}

}
