package com.mvctc.cphelps;

public class Card
{
	protected static final String FACES[] = {"Zero","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};

	protected String suit;
	protected int face;

	/**
	 * Constructor
	 * @param suit suit for card 
	 * @param face face for card
	 */
	public Card(String suit, int face) {
		this.suit = suit;
		this.face = face;
	}

	/**
	 * Sets face of card
	 * @param face face of card
	 */
	public void setFace(int face) {
		this.face = face;
	}

	/**
	 * Sets the suit of card
	 * @param suit suit of card
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Returns suit
	 * @return suit suit of card
	 */
	public String getSuit() {
		return this.suit;
	}

	/**
	 * Returns face
	 * @return face face of card
	 */
	public int getFace() {
		return this.face;
	}

	/**
	 * Converts face to string and adds it with suit
	 */
	public String toString() {
		return FACES[this.face] + " of " + suit;
	}
}