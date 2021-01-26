package com.restApp.controllers;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping ("/")
	public String rootPath() {
		Random lyricGenerator = new Random();
		
		return "My randomly generated lyric id is " + lyricGenerator.nextInt((100-1) + 1);

	}
}
