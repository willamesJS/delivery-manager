package br.com.challenge.gwsystems.deliverymanager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.challenge.gwsystems.deliverymanager.model.ProductModel;
import br.com.challenge.gwsystems.deliverymanager.repository.ProductRepository;

@Controller
@RequestMapping(path = "/gw-systems/products")
public class ProductContoller {

	private final ProductRepository mProductDAO;

	@Autowired
	public ProductContoller(ProductRepository mProductDAO) {
		this.mProductDAO = mProductDAO;
	}

	@GetMapping
	public ModelAndView index() {
		ModelAndView page = new ModelAndView();
		page.setViewName("products");
		
		List<ProductModel> products = (List<ProductModel>) mProductDAO.findAll();
		page.addObject("list_products", products);

		return page;
	}

	@GetMapping(path = "/form-product")
	public ModelAndView createProduct() {

		ModelAndView page = new ModelAndView();
		page.setViewName("formProducts");

		ProductModel mProduct = new ProductModel();
		page.addObject("product_class", mProduct);

		return page;
	}
	
	@GetMapping(path = "/form-product/{id}")
	public ModelAndView createProduct(@PathVariable("id") Long id) {

		ModelAndView page = new ModelAndView();
		page.setViewName("formProducts");

		ProductModel mProduct = mProductDAO.findById(id).get();
		page.addObject("product_class", mProduct);

		return page;
	}

	@PostMapping(path = "/form-product/save")
	public String addProduct(ProductModel mProductModel) {

		try {
			mProductDAO.save(mProductModel);
			return "redirect:/gw-systems/products";
		} catch (Exception e) {
			return "redirect:/gw-systems/products/create";
		}
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		try {
			ProductModel product = mProductDAO.findById(id).get();
			
			mProductDAO.delete(product);
			return "redirect:/gw-systems/products";
		} catch (Exception e) {
			return "redirect:/gw-systems/products";
		}
	}
}
