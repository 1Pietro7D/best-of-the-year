package com.example.demo;

public class Movie {
	private int id;
	private String title;

	public Movie(int id, String title) {
		this.id = id;
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}

	public String getTitle() {
		return title;
	}
}
