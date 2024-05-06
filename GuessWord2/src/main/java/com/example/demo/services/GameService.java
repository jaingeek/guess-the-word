package com.example.demo.services;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.utils.GameUtils;

@Service
@Scope("prototype")
public class GameService {

	private String [] randomWords = {"hello","java","python","c++","Ruby"};
	Random random = new Random();
	private String randomWord = null;
	char [] allCharactersOfWord;
	
	@Autowired
	GameUtils gameUtils;
	
	public GameService() {
		super();
		randomWord = randomWords[random.nextInt(randomWords.length)];
		System.out.println(randomWord);
		allCharactersOfWord = new char[randomWord.length()];
	}

	public String getRandomWord() {
		String returnWord = "";
		
	    for(char c : allCharactersOfWord) {
	        
	    	if (c == '\u0000') {
	            returnWord += "_ ";
	        } else {
	            returnWord += c;
	        }
	    	returnWord+=" ";
	    }
	    return returnWord;
	}


	public String guessedCharacter(char ch) {
		
		boolean correctGuess = false;
	    StringBuilder returnWord = new StringBuilder();

	    for (int i = 0; i < randomWord.length(); i++) {
	        char currentChar = randomWord.charAt(i);
	        if (ch == currentChar) {
	            allCharactersOfWord[i] = ch; // Update the character in the array
	            correctGuess=true;
	        }
	        // Append either the guessed character or underscore based on whether the character has been guessed
	        returnWord.append(allCharactersOfWord[i] != '\u0000' ? allCharactersOfWord[i] + " " : "_ ");

	    }
	    if (!correctGuess) {
            gameUtils.reduceTry();
        }

	    return returnWord.toString();
	}


	
}
