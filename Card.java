package com.hashedin.blackjack;

public class Card 
{
	public Suit suit;
	public CardValue value;
	
	public Card(Suit s,CardValue cv)
	{
		this.suit = s;
		this.value = cv;
	}
	
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public CardValue getValue() {
		return value;
	}
	public void setValue(CardValue value) {
		this.value = value;
	}
}
