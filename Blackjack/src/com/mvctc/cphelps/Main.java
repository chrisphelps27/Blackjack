package com.mvctc.cphelps;

import java.util.List;
import java.util.Scanner;

/**
 * @author phelps47387
 * @version 1.0, 09/28/2017
 */
public class Main
{
	static Scanner keyboard = new Scanner(System.in);
	public static void main( String args[] )
	{
		Deck deck = new Deck();
		
		//Outputs the rules of the game
		System.out.println("Welcome to Blackjack!");
		System.out.println("Rules: ");
		System.out.println("> The goal is to get your total value higher than the dealer without going above 21");
		System.out.println("> Everybody is dealt two cards to start");
		System.out.println("> Dealer's second card remains hidden until the second round");
		System.out.println("> You can \"hit\" or \"stand\"");
		System.out.println("  > Hit is to take another card");
		System.out.println("  > Stand is to hold off another card");
		System.out.println("> Dealer will always hit until their hand is 17 or higher");
		System.out.println("> If you stand once the dealer is standing the game will end");
		//End of rule outputs
		
		System.out.println("\n\n");
		int numDecks;
		System.out.println("How many decks would you like in the play deck(1-5)?");
		do{ //gets how many decks they want added between 1 and 5
			numDecks = keyboard.nextInt();
			if(numDecks < 1 || numDecks > 5) {
				System.out.print("It must be between 1 and 5 decks.");
			}
		}while(numDecks < 1 || numDecks > 5);
		
		for(int i = 2; i <= numDecks; i++) { //for loop to add all the decks required, accounting for the one default deck
			deck.addDeck();
		}
		deck.shuffle();
		
		System.out.println("\nDeck shuffled, cards being dealt");
		System.out.println();
		Hand player = new Hand();
		Hand dealer = new Hand();
		
		for(int i = 0; i < 2; i++) { //deals first two cards to player and first card to dealer
			player.addCard(deck.getCard());
			deck.removeCard();
			if(i < 1) {
				dealer.addCard(deck.getCard());
				deck.removeCard();
			}
		}
		
		showHands(player, dealer); //shows first two cards of player and first for dealer
		dealer.addCard(deck.getCard()); //adds dealer's second card
		deck.removeCard(); //removes card just grabbed from the deck
		if(dealer.hasBlackJack()) {
			showHands(player, dealer);
			System.out.println("Dealer has blackjack, good game!");
			keyboard.close();
			System.exit(0);
		}
		System.out.println("\n");
		boolean gameOver = false;
		while(!gameOver) { //the loop that will continue for the rest of the game
			int menu = getMenuOption();
			System.out.println();
			switch(menu) { //when user either hits, stands, or surrenders
			case 1: //hit
				System.out.println("You hit and recieved a " + deck.getCard());
				player.addCard(deck.getCard());
				deck.removeCard();
				break;
			case 2: //stand
				System.out.println("You choose to stand and recieved no card");
				break;
			default: //quit
				keyboard.close();
				System.exit(0);
			}
			System.out.println();
			if(dealer.getTotalValue() < 17) {
				dealer.addCard(deck.getCard());
				deck.removeCard();
				System.out.println("Dealer hits");
				showHands(player, dealer);
				if(dealer.getTotalValue() > 21) {
					System.out.println("Dealer broke 21 and loses!");
					gameOver = true;
				}
				else if(dealer.hasBlackJack() && !player.hasBlackJack()) { //game ends with dealer having blackjack
					System.out.println("Dealer has blackjack and wins.");
					gameOver = true;
					
				}
				else if(dealer.hasBlackJack() && player.hasBlackJack()) { //game ends in a tie of blackjack
					System.out.println("The game ends in a tie!");
					gameOver = true;
				}
			}
			else {
				System.out.println("Dealer stands");
				showHands(player, dealer);
			}
			
			if(!gameOver) { //if the game is not already over after the dealer's turn
				if(player.hasBlackJack()) { //player is exactly 21
					System.out.println("You have blackjack and win!");
					gameOver = true;
				}
				else if(player.getTotalValue() > 21) { //player is above 21
					System.out.println("You broke 21 and lost.");
					gameOver = true;
				}
				else if(menu == 2 && dealer.getTotalValue() >= 17) { //if player stands and dealer stands
					if(player.getTotalValue() > dealer.getTotalValue()) { //if player beats dealer
						System.out.println("You beat the dealer with " + player.getTotalValue() + " and them having " + dealer.getTotalValue() + "!");
						gameOver = true;
					}
					else { //if dealer beats player
						System.out.println("The dealer beat you with " + dealer.getTotalValue() + " and you having " + player.getTotalValue() + ".");
						gameOver = true;
					}
				}
			}
			System.out.println("\n");
		}
		System.out.println("Thanks for playing!");
		keyboard.close();
		System.exit(0);
		
	}
	
	/**
	 * Shows hands of both player and dealer side by side
	 * @param player player of game
	 * @param dealer dealer of game
	 */
	private static void showHands(Hand player, Hand dealer) {
		List<BlackJackCard> pCards = player.getCards();
		List<BlackJackCard> dCards = dealer.getCards();
		int size;
		if(pCards.size() > dCards.size()) //if player has more cards
			size = pCards.size();
		else //if dealer has more cards
			size = dCards.size();
		System.out.println("------Player's Cards----------------Dealer's Cards---------");
		for(int i = 0; i < size; i++) {
			try { //tries to show player's next card
				System.out.printf("%-3s %-22s %-3s", "| ", pCards.get(i).toString(), " |");
			}
			catch(IndexOutOfBoundsException e) { //if player has no next card but dealer does
				System.out.printf("%-3s %-22s %-3s", "| ", "", " |");
			}
			
			try { //tries to show dealer's next card
				System.out.printf("%-3s %-22s %-3s", "| ", dCards.get(i).toString(), " |");
			}
			catch(IndexOutOfBoundsException e) { //if dealer has no next card but player does
				if(dCards.size() == 1) //if it's first draw and dealer's second card is still hidden
					System.out.printf("%-3s %-22s %-3s", "| ", "**HIDDEN CARD**", " |");
				else //if not first draw and all cards can be shown
					System.out.printf("%-3s %-22s %-3s", "| ", "", " |");
			}
			System.out.println();
		}
		System.out.println("|  -----------------------  | |  -----------------------  |");
		System.out.printf("%-13s %-8s %-3s", "|   Total Value: ", player.getTotalValue(), " |");
		System.out.printf("%-13s %-8s %-3s", "|   Total Value: ", dealer.getTotalValue(), " |");
		System.out.println("\n-----------------------------------------------------------");
	}
	
	/**
	 * Displays a menu and has the user pick an option
	 * @return the menu option to run
	 */
	public static int getMenuOption() {
		int option;
		System.out.println("----------------");
		System.out.println("| 1. Hit       |");
		System.out.println("| 2. Stand     |");
		System.out.println("| 3. Surrender |");
		System.out.println("----------------");
		System.out.print("Pick a number: " );

		do{
			option = keyboard.nextInt();
			if(option < 1 || option > 3) {
				System.out.println(option + " is not an option, please try again");
			}
		} while(option < 1 || option > 3);
		return option;
	}
}