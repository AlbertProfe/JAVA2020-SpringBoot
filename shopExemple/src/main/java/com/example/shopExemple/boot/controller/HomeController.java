package com.example.shopExemple.boot.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopExemple.boot.model.Customer;
import com.example.shopExemple.boot.model.OrderShop;
import com.example.shopExemple.boot.service.CustomerService;
import com.example.shopExemple.boot.service.OrderShopService;
import com.example.shopExemple.boot.utils.controller.StatusSession;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	CustomerService customerservice;

	@Autowired
	OrderShopService orderservice;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {

		//if (session.getAttribute("sid") == null) {

			logger.info("Welcome home! The client locale is {}.", locale);

			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

			String formattedDate = dateFormat.format(date);

			model.addAttribute("serverTime", formattedDate);
			model.addAttribute("msg",
					"Welcome to our shooping center, enjoy your stay, and buy some beans or entities ...");

			String sid = session.getId();
			session.setAttribute("sid", sid);
			// System.out.println("Session id: " + sid);

			session.setAttribute("status", StatusSession.CREATED);
			session.setAttribute("timestamp", formattedDate);

			// System.out.println(session.getServletContext());
			// System.out.println(session.getSessionContext());
			// to-do as a LOG

			model.addAttribute("clients", customerservice.findAll());

			return "shoping/login";
		//}

		//else
		//	return "redirect:products/show";
	}

	@RequestMapping(value = { "/loginCustomer" }, method = RequestMethod.POST)
	public String loginCustomer(@RequestParam("idCustomer") Long id, Model model, HttpSession session) {

		Optional<Customer> foundCustomer = customerservice.findById(id);

		// Search for a book with an invalid ID
		if (foundCustomer.isPresent())

		{
			session.setAttribute("customer", foundCustomer.get());
			
			OrderShop orderShop = new OrderShop();
			
			//orderShop.setIdSessionShop((String) session.getAttribute("sid"));
			orderShop.setIdSessionShop( session.getAttribute("sid").toString());
			orderShop.setStatusShop(session.getAttribute("status").toString());
			orderShop.setTimeStampShop(session.getAttribute("timestamp").toString());
			orderShop.setCustomer(foundCustomer.get());

			orderservice.insertOrder(orderShop);
			session.setAttribute("orderShop",  orderShop  );
			
			session.setAttribute("idShop", orderShop.getIdShop());
			

		}

		return "shoping/home";
	}

	@RequestMapping(value = { "/*" }, method = RequestMethod.GET)
	public String error(Locale locale, Model model, HttpSession session) {

		// to-do error site
		return "shoping/error";
	}

}
