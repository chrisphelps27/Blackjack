package com.mvctc.cphelps;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<BlackJackCard> cards = new ArrayList<BlackJackCard>();

	/**
	 * @return the cards
	 */
	public List<BlackJackCard> getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(List<BlackJackCard> cards) {
		this.cards = cards;
	}
	
	public void addCard(BlackJackCard card) {
		this.cards.add(card);
	}
	
	public boolean hasBlackJack() {
		if(getTotalValue() == 21)
			return true;
		else
			return false;
	}
	
	public int getTotalValue() {
		int total = 0;
		for(BlackJackCard card : this.cards) {
			total += card.getValue();
		}
		return total;
	}
}
