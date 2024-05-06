package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.example.demo.services.GameService;

@Component
public class GameUtils {

	@Autowired
	ConfigurableApplicationContext applicationContext;
	
	private int MAX_TRIES = 2;
	
	public int reduceTry() {
		if(MAX_TRIES>0)
			MAX_TRIES = MAX_TRIES-1;
		return MAX_TRIES;
	}

	public int getTry() {
		return MAX_TRIES;
	}
	
	public GameService reload() {
		return applicationContext.getBean(GameService.class);
	}
}
