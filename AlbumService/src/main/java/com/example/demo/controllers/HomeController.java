package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.Album;

@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		return "Bonjour du Service Album s'executant sur le port : " + env.getProperty("local.server.port");
	}
  
	@RequestMapping("/{id}")
	public Album getGallery(@PathVariable final int id) {
		// creation d'un objet Album
		Album album = new Album();
		album.setId(id);
		
		// recuperer les images disponibles images 
		List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
		album.setImages(images);
		return album;
	}
}
