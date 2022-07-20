package br.com.challenge.gwsystems.deliverymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.challenge.gwsystems.deliverymanager.model.ClientModel;
import br.com.challenge.gwsystems.deliverymanager.repository.ClientRepository;

@Controller
@RequestMapping(path = "/gw-systems/clients")
public class ClientsController {

	private ClientRepository mClientDAO;

	@Autowired
	public ClientsController(ClientRepository mClientDAO) {

		this.mClientDAO = mClientDAO;
	}

	@GetMapping
	public ModelAndView index() {
		ModelAndView page = new ModelAndView();
		page.setViewName("clients");

		List<ClientModel> listClient = (List<ClientModel>) mClientDAO.findAll();
		page.addObject("list_clients", listClient);
		
		return page;
	}

	@GetMapping(path = "/form-clients")
	public ModelAndView formClients() {
		ModelAndView page = new ModelAndView();
		page.setViewName("formClients");

		ClientModel mClient = new ClientModel();
		page.addObject("client_class", mClient);

		return page;
	}

	@PostMapping(path = "/form-clients/save")
	public String addProduct(ClientModel client) {

		try {
			mClientDAO.save(client);
			return "redirect:/gw-systems/clients";
		} catch (Exception e) {
			return "redirect:/gw-systems/clients/form-clients";
		}
	}
	
	@GetMapping(path = "/form-clients/person-legal/{id}")
	public ModelAndView formClientsEditPersonLegal(@PathVariable("id") Long id) {
		ModelAndView page = new ModelAndView();
		page.setViewName("formClientsEditPersonLegal");

		ClientModel mClient = mClientDAO.findById(id).get();
		page.addObject("client_class", mClient);

		return page;
	}
	
	@GetMapping(path = "/form-clients/person-natural/{id}")
	public ModelAndView formClientsEditPersonNatural(@PathVariable("id") Long id) {
		ModelAndView page = new ModelAndView();
		page.setViewName("formClientsEditPersonNatural");

		ClientModel mClient = mClientDAO.findById(id).get();
		page.addObject("client_class", mClient);

		return page;
	}
	
	@GetMapping(path = "/delete/{id}")
	public String deleteClient(@PathVariable("id") Long id) {

		try {
			mClientDAO.deleteById(id);
			
			return "redirect:/gw-systems/clients";
		} catch (Exception e) {
			return "redirect:/gw-systems/clients";
		}
			
		
	}
}
