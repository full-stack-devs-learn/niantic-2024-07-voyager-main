package com.niantic;

import com.niantic.models.Deck;
import com.niantic.models.Hand;
import com.niantic.models.Player;

public class Sorting
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        deck.shuffle();

        Hand hand = new Hand();
        hand.dealTo(deck.takeCard());
        hand.dealTo(deck.takeCard());
        hand.dealTo(deck.takeCard());
        hand.dealTo(deck.takeCard());
        hand.dealTo(deck.takeCard());
        hand.dealTo(deck.takeCard());

        var cards = hand.getCards();

        cards.stream()
               .sorted((card1, card2) -> (card1.getPointValue() < card2.getPointValue()) ? -1 : 1)
                .forEach(card -> System.out.println(card.getPointValue()));

        System.out.println();
        cards.forEach(card -> System.out.println(card.getPointValue()));
    }
}
