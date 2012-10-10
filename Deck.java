package com.hashedin.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck 
{
	List<Card> deck ;
	public Deck()
	{
		this.deck  = new ArrayList<Card>();
		for(Suit s : Suit.values())
		{
			for(CardValue value: CardValue.values())
			{
				deck.add(new Card(s,value));
			}
		}
		
		Collections.shuffle(deck);
	}
}
