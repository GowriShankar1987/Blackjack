package com.hashedin.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player 
{
	List<Card> myHand = new ArrayList<Card>();
	public void add(Card c)
	{
		this.myHand.add(c);
	}
	
	public void displayMyHand()
	{
		for(Card c:this.myHand)
		{
			System.out.println(c.suit+":"+c.value);
		}
	}
	public int getScore()
	{
		int score = 0;
		int aceCounter = 0;
		for(Card c : this.myHand)
		{
			score += c.getValue().getCardValue();
			if(c.equals(CardValue.ACE))
				aceCounter++;
		}
		if(this.myHand.contains(CardValue.ACE))
		{
			score -= aceCounter * CardValue.ACE.getCardValue();
			if(score < 10 && aceCounter == 1)
			{
				score += CardValue.ACE.getCardValue();
			}else if(score > 10 && aceCounter > 1)
			{
				score += aceCounter * 1;
			}else if(score < 10 && aceCounter > 1)
			{
				score +=(CardValue.ACE.getCardValue()+(aceCounter-1)*1);
			}
			else if(score>10 && aceCounter == 1)
			{
				score += 1;
			}
		}
		return score;
	}
}
