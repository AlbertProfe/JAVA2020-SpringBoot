package com.example.shopExemple.boot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.shopExemple.boot.model.OrderDetail;
import com.example.shopExemple.boot.model.OrderShop;
import com.example.shopExemple.boot.model.Product;
import com.example.shopExemple.boot.model.ProductCart;
import com.example.shopExemple.boot.service.OrderDetailService;
import com.example.shopExemple.boot.service.OrderShopService;
import com.example.shopExemple.boot.utils.controller.StatusSession;

@Controller
@RequestMapping(value = "/pay")
public class PayController {
	
	@Autowired
	OrderShopService orderservice;
	
	@Autowired
	OrderDetailService orderDetailservice;

	@RequestMapping(value = "/show")
	public String show(HttpSession session) {

		if (session.getAttribute("cart") == null) {

			// System.out.println("Cart null");

		} else {

			List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
			session.setAttribute("cart", cart);
			session.setAttribute("status", StatusSession.TOPAY);
			
			orderservice.setStatusOrderShop(session);

		}

		return "shoping/pay";
	}

	@RequestMapping(value = "/payWithCard")
	public String payWithCard(HttpSession session, Model model) {

		if (session.getAttribute("cart") != null) {

			model.addAttribute("customer", session.getAttribute("customer"));
			model.addAttribute("sid", session.getAttribute("sid"));

			session.setAttribute("status", StatusSession.FINISHED);
			model.addAttribute("status", session.getAttribute("status"));
			model.addAttribute("total", session.getAttribute("total"));
			
			orderservice.setStatusOrderShop(session);
			
			OrderDetail orderDetail;
			OrderShop orderShop = (OrderShop) session.getAttribute("orderShop");
			
			List<ProductCart> cart = (List<ProductCart>) session.getAttribute("cart");
			
			for (ProductCart productCart : cart) {
				
				orderDetail = new OrderDetail();
				orderDetail.setQuantity(productCart.getQuantity());
				orderDetail.setOrderShop(orderShop);
				orderDetail.setProduct(productCart.getProduct());
				
				orderDetailservice.insertOrderDetail(orderDetail);
			}
			
		}

		session.invalidate();

		return "shoping/finished";
	}

}