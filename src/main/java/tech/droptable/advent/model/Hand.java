/**
 * 
 */
package tech.droptable.advent.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 */
public class Hand implements Comparable {
  
  public static final boolean JOKER_RULES = true;
 
  /*
  70 Five of a kind, where all five cards have the same label: AAAAA
  60 Four of a kind, where four cards have the same label and one card has a different label: AA8AA
  50 Full house, where three cards have the same label, and the remaining two cards share a different label: 23332
  40 Three of a kind, where three cards have the same label, and the remaining two cards are each different from any other card in the hand: TTT98
  30 Two pair, where two cards share one label, two other cards share a second label, and the remaining card has a third label: 23432
  20 One pair, where two cards share one label, and the other three cards have a different label from the pair and each other: A23A4
  N < 20 - High card, where all cards' labels are distinct: 23456*/
  
  List<Card> cards;
  int bet;
  int pointsWorth = 0;
  
  
  public Hand(String s, int bet) {
    this.bet = bet;
    cards = new ArrayList<>();
    for (char c: s.toCharArray()) {
      if(Character.isDigit(c)) {
        cards.add(new Card(Integer.parseInt("" + c)));
      } else {
        switch (c) {
          case 'A':
            cards.add(new Card(14));
            break;
          case 'K':
            cards.add(new Card(13));
            break;
          case 'Q':
            cards.add(new Card(12));
            break;
          case 'J':
            if(JOKER_RULES) {
              cards.add(new Card(1));
            } else {
              cards.add(new Card(11));
            }
            break;
          case 'T':
            cards.add(new Card(10));
            break;
        }
      }
    }
    List<Card> sorted = new ArrayList(cards);
    sorted.sort(null);
    Card last = null;
    int numSame = 1;
    Iterator<Card> it = sorted.iterator();
    SortedSet<Integer> booked = new TreeSet<>();
    boolean hasPair = false;
    boolean hasTriss = false;
    Card beforeJoker = null;
    while(it.hasNext()) {
      Card current = it.next();
      if(current.equals(last) && 
          (beforeJoker == null || beforeJoker.equals(current))) {
        
        numSame++;
        // Special handling for binding jokers
        if(current.isJoker()) {
          beforeJoker = last;
        }
       
      } else {
        // either we had a previous multiple, or not
        // Reset and book the multiple
        if(numSame == 5) {
          booked.add(70);
        } else if(numSame == 4) {
          booked.add(60);
        } else if(numSame == 3) {
          // full house?
          if(hasPair) {
            booked.add(50);
          } else {
            booked.add(40);
          }
          hasTriss = true;
        } else if(numSame == 2) {
          // full house or two pairs?
          if(hasPair) {
            // Two pairs
            booked.add(30);
          } else if (hasTriss) {
            // Full house
            booked.add(50);
          } else {
            // Just a pair
            booked.add(20);
          }
          hasPair = true;
        } else {
          // nothing to book
        }
        // Reset
        numSame = 1;
        beforeJoker = null;
      }
      last = current;
    }
    
    // either we had a previous multiple, or not
    // Reset and book the multiple
    if(numSame == 5) {
      booked.add(70);
    } else if(numSame == 4) {
      booked.add(60);
    } else if(numSame == 3) {
      // full house?
      if(hasPair) {
        booked.add(50);
      } else {
        booked.add(40);
      }
      hasTriss = true;
    } else if(numSame == 2) {
      // full house or two pairs?
      if(hasPair) {
        // Two pairs
        booked.add(30);
      } else if (hasTriss) {
        // Full house
        booked.add(50);
      } else {
        // Just a pair
        booked.add(20);
      }
      hasPair = true;
    } else {
      // nothing to book
    }
    // Reset
    numSame = 1;
    
    if(booked.isEmpty()) {
      pointsWorth = 0;
    } else {
      pointsWorth = booked.last();
    }
  }
  
  public int getBet() {
    return bet;
  }
  
  public List<Card> getCards() {
    return cards;
  }
  
  public int getWorth() {
    return pointsWorth;
  }
  
  public String toString() {
    StringBuilder b = new StringBuilder();
    b.append("[");
    Iterator<Card> it = cards.iterator();
    while(it.hasNext()) {
      Card c = it.next();
      b.append(c.toString());
    }
    b.append("(" + bet + ")" + pointsWorth + "]");
    return b.toString();
  }

  @Override
  public int compareTo(Object o) {
    if(o instanceof Hand) {
      Hand hand = (Hand)o;
      int res = pointsWorth - hand.getWorth();
      if(res == 0) {
        // Manage equal case
        Iterator<Card> my = cards.iterator();
        Iterator<Card> other = hand.getCards().iterator();
        while(my.hasNext()) {
          Card c1 = my.next();
          Card c2 = other.next();
          if(!c1.equals(c2)) {
            return c1.compareTo(c2);
          }
        }
      } else {
        return res;
      }
    }
    return 0;
  }


  
  
  public static class Card implements Comparable {
    public static final Card A = new Card(14);
    public static final Card K = new Card(13);
    public static final Card Q = new Card(12);
    public static final Card J = new Card(11);
    public static final Card T = new Card(10);
    public static final Card N9 = new Card(9);
    public static final Card N8 = new Card(8);
    public static final Card N7 = new Card(7);
    public static final Card N6 = new Card(6);
    public static final Card N5 = new Card(5);
    public static final Card N4 = new Card(4);
    public static final Card N3 = new Card(3);
    public static final Card N2 = new Card(2);
    
    int strength;
    protected Card(int i) {
      strength = i;
    }
    
    private String createDesc(int i) {
      switch(i) {
        case 10:
          return "T";
        case 11:
          return "J";
        case 12:
          return "Q";
        case 13:
          return "K";
        case 14:
          return "A";
        case 1:
          return "J";
        default:
          return "" + i;
      }
    }

    public boolean equals(Object o) {
      if(o instanceof Card) {
        Card other = (Card)o;
        if(this.isJoker() || other.isJoker()) {
          return true;
        }
        if(strength == other.getValue()) {
          return true;
        }
      }
      return false;
    }
    
    public String toString() {
      return createDesc(strength);
    }
    
    @Override
    public int compareTo(Object o) {
      if(o instanceof Card) {
        Card other = (Card)o;
        if(this.isJoker() || other.isJoker()) {
          return 0;
        }
        return strength - other.getValue();
      }
      throw new RuntimeException();
    }
    
    public boolean isJoker() {
      return strength == 1;
    }

    public int getValue() {
      return strength;
    }
  }

}
