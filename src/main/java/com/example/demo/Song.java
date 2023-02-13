package com.example.demo;

public class Song {
	private int id;
	private String title;

	public Song(int id, String title) {
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
