package com.springboot.hibernate.controllers;

import com.springboot.hibernate.entities.Address;
import com.springboot.hibernate.services.impl.AddressServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

	@Autowired
	private AddressServiceImpl addressService;

	@GetMapping(value= "/address-list")
	public List<Address> listCustomer() {
		List<Address> list =  addressService.findAll();
		return list;
	}


//	@RequestMapping("/customer-save")
//	public String insertCustomer(Model model) {
//		model.addAttribute("customer", new Customer());
//		return "customer-save";
//	}
//
//	@RequestMapping("/customer-view/{id}")
//	public String viewCustomer(@PathVariable int id, Model model) {
//		Customer customer = customerService.findById(id);
//		model.addAttribute("customer", customer);
//		return "customer-view";
//	}
//
//	@RequestMapping("/customer-update/{id}")
//	public String updateCustomer(@PathVariable int id, Model model) {
//		Customer customer = customerService.findById(id);
//		model.addAttribute("customer", customer);
//		return "customer-update";
//	}
//
//	@RequestMapping("/saveCustomer")
//	public String doSaveCustomer(@ModelAttribute("Customer") Customer customer, Model model) {
//		customerService.save(customer);
//		model.addAttribute("listCustomer", customerService.findAll());
//		return "redirect:customer-list";
//	}
//
//	@RequestMapping("/updateCustomer")
//	public String doUpdateCustomer(@ModelAttribute("Customer") Customer customer, Model model) {
//		customerService.update(customer);
//		model.addAttribute("listCustomer", customerService.findAll());
//		return "redirect:customer-list";
//	}
//
//	@RequestMapping("/customerDelete/{id}")
//	public String doDeleteCustomer(@PathVariable int id, Model model) {
//		customerService.delete(id);
//		model.addAttribute("listCustomer", customerService.findAll());
//		return "redirect:/customer-list";
//	}
}
