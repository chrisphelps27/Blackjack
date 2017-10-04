/**
 * 
 */
package com.mvctc.cphelps;

/**
 * @author phelps47387
 *
 */
public class BlackJackCard extends Card {
	private static final int VALUE[] = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10};
	
	
	/**
	 * Constructer for BlackJackCard
	 * @param suit suit of card
	 * @param face face of card
	 */
	public BlackJackCard(String suit, int face) {
		super(suit, face);
	}
	
	/**
	 * Gets value of face relative to blackjack
	 * @return value value of card
	 */
	public int getValue() {
		return VALUE[face-1];
	}
	
	/**
	 * Returns a string that combines card face, suit, and value
	 * @return output string version of face, suit, and value
	 */
	public String toString() {
		return FACES[face] + " of " + suit + " (" + VALUE[face-1] + ")";
	}

}
