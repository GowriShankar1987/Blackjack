package com.hashedin.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackJackGame 
{
	public static void main(String args[]){
		startGame();
	}
	public static void startGame()
	{
		Deck deck = new Deck();
		Player player = new Player();
		Dealer dealer = new Dealer();
		dealer.dealHand(deck, player);
		player.displayMyHand();
		nextDeal(promptPlayerForCall(), player, dealer, deck);
	}
	public static void nextDeal(String playerCall,Player player,Dealer dealer,Deck deck)
	{
		if(playerCall.equalsIgnoreCase("h")||playerCall.equalsIgnoreCase("s"))
		{
			if(playerCall.equalsIgnoreCase("h"))
			{
				dealer.deal(deck, player);
				player.displayMyHand();
				nextDeal(promptPlayerForCall(), player, dealer, deck);
			}
			
			if(playerCall.equalsIgnoreCase("s"))
			{
				winCheck(player,dealer,deck);
				promptPlayerForNextGame();
			}
		}
		else{
			nextDeal(promptPlayerForCall(), player, dealer, deck);
		}
		
	}
	public static String promptPlayerForCall()
	{
		String playerCall="";
		System.out.println("Please call either Hit- h/H or Stand- s/S");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			playerCall = br.readLine();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return playerCall;
	}
	public static void winCheck(Player player,Dealer dealer,Deck deck)
	{
		while(dealer.getScore()<17 ||( dealer.getScore() <= player.getScore() && player.getScore()<=21))
		{
			dealer.deal(deck, dealer);
		}
		if(player.getScore()>21 && dealer.getScore()>21)
		{
			System.out.println("Players Hand :\n");
			player.displayMyHand();
			System.out.println("Dealers Hand :\n");
			dealer.displayMyHand();
			System.out.println("Sorry there is no winner , both got busted !");
		}else 
		{
			if(player.getScore()<=21 && dealer.getScore()>21)
			{
				System.out.println("Players Hand :\n");
				player.displayMyHand();
				System.out.println("Dealers Hand :\n");
				dealer.displayMyHand();
				System.out.println("Congratulations Player is the winner, dealer has lost");
			}else if(dealer.getScore()<=21 && player.getScore()>21)
			{
				System.out.println("Players Hand :\n");
				player.displayMyHand();
				System.out.println("Dealers Hand :\n");
				dealer.displayMyHand();
				System.out.println("Sorry Player you've lost and dealer wins, please pay money to dealer");
			}
			else if(player.getScore()==21 && dealer.getScore()==21)
			{
				System.out.println("Players Hand :\n");
				player.displayMyHand();
				System.out.println("Dealers Hand :\n");
				dealer.displayMyHand();
				System.out.println("Game drawn, both have scored maxscore of 21");
			}
			else {
				if(player.getScore()>dealer.getScore())
				{
					System.out.println("Players Hand :\n");
					player.displayMyHand();
					System.out.println("Dealers Hand :\n");
					dealer.displayMyHand();
					System.out.println("Congratulations Player is the winner, dealer has lost");
				}
				else
				{
					System.out.println("Players Hand :\n");
					player.displayMyHand();
					System.out.println("Dealers Hand :\n");
					dealer.displayMyHand();
					System.out.println("Sorry Player you've lost and dealer wins, please pay money to dealer");
				}
			}
		}
	}
	
	public static void promptPlayerForNextGame()
	{
		System.out.println("Do you want try another Deal? Y or N");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try 
		{
			if(br.readLine().equalsIgnoreCase("y"))
			{
				startGame();
			}
			else
			{
				System.out.println("It was nice playing with you, have a nice day ");
				System.exit(1);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
