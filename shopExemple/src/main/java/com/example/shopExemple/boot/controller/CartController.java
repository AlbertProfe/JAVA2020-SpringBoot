package com.example.shopExemple.boot.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.shopExemple.boot.model.OrderShop;
import com.example.shopExemple.boot.model.Product;
import com.example.shopExemple.boot.model.ProductCart;
import com.example.shopExemple.boot.service.OrderShopService;
import com.example.shopExemple.boot.service.ProductService;
import com.example.shopExemple.boot.utils.controller.StatusSession;

@Controller
@RequestMapping(value = "cart")
public class CartController {

	@Autowired
	ProductService service;

	@Autowired
	OrderShopService orderservice;

	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String homeCart() {
		return "shoping/cart";
	}

	@RequestMapping(value = "addToCart", method = RequestMethod.GET)
	public String add(@RequestParam("itemId") Long id, HttpSession session) {

		// ProductModel productModel = new ProductModel();
		// ProductAmount productAmount = new ProductAmount();

		List<ProductCart> cart;

		if (session.getAttribute("cart") == null) {

			cart = new ArrayList<ProductCart>();

			cart.add(new ProductCart(service.findById(id), 1));
			session.setAttribute("cart", cart);
			session.setAttribute("status", StatusSession.TOBUY);

			orderservice.setStatusOrderShop(session);

		} else {

			cart = (List<ProductCart>) session.getAttribute("cart");

			int index = exists(id, cart);
			if (index == -1) {
				cart.add(new ProductCart(service.findById(id), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}

			session.setAttribute("cart", cart);
		}
		
		
		calculateTotal(cart,session);
		
		return "redirect:/cart/show";
	}

	@RequestMapping(value = "removeFromCart", method = RequestMethod.GET)
	public String remove(@RequestParam("itemId") Long id, HttpSession session) {

		// ProductModel productModel = new ProductModel();
		List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");

		int index = exists(id, cart);
		int quantity = cart.get(index).getQuantity();

		if (quantity > 0) {
			quantity--;
			cart.get(index).setQuantity(quantity);

			if (quantity == 0)
				cart.remove(index);
		}

		session.setAttribute("cart", cart);

		return "redirect:/cart/show";
	}

	private static int exists(Long id, List<ProductCart> cart) {

		for (int i = 0; i < cart.size(); i++) {

			if (cart.get(i).getProduct().getId() == id) {
				return i;
			}

		}
		return -1;
	}

	private static void calculateTotal ( List<ProductCart> cart, HttpSession session) {

		Double total = 0.0;

		for (ProductCart productCart : cart) {

			total = total + (productCart.getProduct().getPrice() * productCart.getQuantity());
		}

		session.setAttribute("total", total);
	}
} 
