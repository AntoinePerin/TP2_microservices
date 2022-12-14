package com.example.demo.entities;

import java.util.List;

public class Album {
	private int id;
	private List<Object> images;
	
	public Album() {
	}

	public Album(int galleryId) {
		this.id = galleryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Object> getImages() {
		return images;
	}

	public void setImages(List<Object> images) {
		this.images = images;
	}
	
}
