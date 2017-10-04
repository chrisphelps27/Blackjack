package com.mvctc.cphelps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mvctc.cphelps.BlackJackCard;

public class Deck {
	private final BlackJackCard defaultDeck[] = {new BlackJackCard("Clubs", 1), new BlackJackCard("Clubs", 2), new BlackJackCard("Clubs", 3), new BlackJackCard("Clubs", 4), new BlackJackCard("Clubs", 5), new BlackJackCard("Clubs", 6), 
			new BlackJackCard("Clubs", 7), new BlackJackCard("Clubs", 8), new BlackJackCard("Clubs", 9), new BlackJackCard("Clubs", 10), new BlackJackCard("Clubs", 11), new BlackJackCard("Clubs", 12),
			new BlackJackCard("Diamonds", 1), new BlackJackCard("Diamonds", 2), new BlackJackCard("Diamonds", 3), new BlackJackCard("Diamonds", 4), new BlackJackCard("Diamonds", 5), new BlackJackCard("Diamonds", 6), 
			new BlackJackCard("Diamonds", 7), new BlackJackCard("Diamonds", 8), new BlackJackCard("Diamonds", 9), new BlackJackCard("Diamonds", 10), new BlackJackCard("Diamonds", 11), new BlackJackCard("Diamonds", 12),
			new BlackJackCard("Hearts", 1), new BlackJackCard("Hearts", 2), new BlackJackCard("Hearts", 3), new BlackJackCard("Hearts", 4), new BlackJackCard("Hearts", 5), new BlackJackCard("Hearts", 6), 
			new BlackJackCard("Hearts", 7), new BlackJackCard("Hearts", 8), new BlackJackCard("Hearts", 9), new BlackJackCard("Hearts", 10), new BlackJackCard("Hearts", 11), new BlackJackCard("Hearts", 12),
			new BlackJackCard("Spades", 1), new BlackJackCard("Spades", 2), new BlackJackCard("Spades", 3), new BlackJackCard("Spades", 4), new BlackJackCard("Spades", 5), new BlackJackCard("Spades", 6), 
			new BlackJackCard("Spades", 7), new BlackJackCard("Spades", 8), new BlackJackCard("Spades", 9), new BlackJackCard("Spades", 10), new BlackJackCard("Spades", 11), new BlackJackCard("Spades", 12)
	};
	private List<BlackJackCard> shuffleDeck = new ArrayList<BlackJackCard>();
	
	
	/**
	 * Constructor for deck. Creates a deck and a shuffled deck
	 */
	public Deck() {
		for(BlackJackCard card : defaultDeck) {
			shuffleDeck.add(card);
		}
	}
	
	/**
	 * Gets the shuffled deck
	 * @return shuffledDeck
	 */
	public List<BlackJackCard> getDeck() {
		return shuffleDeck;
	}
	
	/**
	 * Sets the shuffled deck
	 * @param deck the deck to set
	 */
	public void setDeck(List<BlackJackCard> deck) {
		shuffleDeck = deck;
	}
	
	/**
	 * Returns "top" (index 0) card in deck
	 * @return first card in deck
	 */
	public BlackJackCard getCard() {
		return shuffleDeck.get(0);
	}
	
	/**
	 * Removes "top" (index 0) card from deck
	 */
	public void removeCard() {
		shuffleDeck.remove(0);
	}
	
	
	/**
	 * Outputs current shuffled deck
	 */
	public void showDeck() {
		for(BlackJackCard card : shuffleDeck) {
			System.out.println(card.toString());
		}
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffleList() {
		for(BlackJackCard card : defaultDeck) {
			shuffleDeck.add(card);
		}
        Collections.shuffle(shuffleDeck);
    }
	
}
