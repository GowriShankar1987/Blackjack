package com.hashedin.blackjack;

public class Dealer extends Player 
{
	public void dealHand(Deck deck,Player player)
	{
		player.add(deck.deck.get(deck.deck.size()-1));
		deck.deck.remove(deck.deck.size()-1);
		this.myHand.add(deck.deck.get(deck.deck.size()-1));
		deck.deck.remove(deck.deck.size()-1);
		player.add(deck.deck.get(deck.deck.size()-1));
		deck.deck.remove(deck.deck.size()-1);
		this.myHand.add(deck.deck.get(deck.deck.size()-1));
		deck.deck.remove(deck.deck.size()-1);
	}
	
	public void deal(Deck deck,Player player){
		player.add(deck.deck.get(deck.deck.size()-1));
		deck.deck.remove(deck.deck.size()-1);
	}
}
