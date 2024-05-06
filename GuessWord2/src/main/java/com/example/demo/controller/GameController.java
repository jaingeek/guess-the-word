package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.GameService;
import com.example.demo.utils.GameUtils;

@Controller
public class GameController {

	@Autowired
	GameService gameserv;
	
	@Autowired
	GameUtils gameutils;
	
	@GetMapping("/")
	public String getRandomWord(Model model) {
		
		model.addAttribute("randomWord", gameserv.getRandomWord());
		model.addAttribute("tries",gameutils.getTry());
		
		return "index";
	}
	
	@PostMapping("/get-char")
	public String getCharacter(@RequestParam String ch,Model model) {
		String word = gameserv.guessedCharacter(ch.charAt(0));
		model.addAttribute("randomWord", word);
		model.addAttribute("tries",gameutils.getTry());
		return "index";
		
	}
	
	@GetMapping("/reload")
	public String reload() {
		gameserv = gameutils.reload();
		return "redirect:/";
	}
}
