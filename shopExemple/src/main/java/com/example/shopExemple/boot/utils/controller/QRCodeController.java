package com.example.shopExemple.boot.utils.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
 
import javax.servlet.http.HttpServletRequest;
 

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {
 
	
 

	@RequestMapping(value = "/getQRCode")
	@ResponseBody
	public String getQRCode(HttpServletRequest req) throws IOException {
		return null;
		
	}
 
}