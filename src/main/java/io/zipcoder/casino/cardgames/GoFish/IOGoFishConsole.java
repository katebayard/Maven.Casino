package io.zipcoder.casino.cardgames.GoFish;

import io.zipcoder.casino.cardgames.CardUtilities.Card;
import io.zipcoder.casino.cardgames.CardUtilities.SignType;
import io.zipcoder.casino.CasinoConsole;
import io.zipcoder.casino.utilities.Console;

import java.util.List;



public class IOGoFishConsole extends CasinoConsole {
    Console goFishConsole;
    String name;


    public void setPlayerName(String playername) {
        this.name = playername;
    }

    public IOGoFishConsole(String name) {
        this.name = name;
        this.goFishConsole = new Console(System.in, System.out);

    }

    public void goFishWelcomeMessage() {
        goFishConsole.println("Welcome " + name + ", to the Go Fish room");
    }

    public void distributeCardMessage() {
        goFishConsole.println("The dealer has distributed the cards.");
    }


    public void displayCurrentHand(List<Card> hand) {
        if(hand == null) {
            goFishConsole.println("You don't have any cards in your hand.");
        } else {
            for(int i = 0; i <hand.size(); i++) {goFishConsole.print("┌─────────┐ ");}
            goFishConsole.print("\n");
            for(int i = 0; i <hand.size(); i++) {
                if(hand.get(i).getValue() == 10) {goFishConsole.print("│"+getDisplayString(hand.get(i),"")+"       │ ");}
                else{goFishConsole.print("│"+getDisplayString(hand.get(i),"")+"        │ ");}
            }
            goFishConsole.print("\n");
            for(int i = 0; i <hand.size(); i++) {goFishConsole.print("│         │ ");}
            goFishConsole.print("\n");
            for(int i = 0; i <hand.size(); i++) {goFishConsole.print("│    "+getDisplaySymbol(hand.get(i),"")+"    │ ");}
            goFishConsole.print("\n");
            for(int i = 0; i <hand.size(); i++) {goFishConsole.print("│         │ ");}
            goFishConsole.print("\n");
            for(int i = 0; i <hand.size(); i++){
                if(hand.get(i).getValue() == 10){goFishConsole.print("│       "+getDisplayString(hand.get(i),"")+"│ ");}
                else{goFishConsole.print("│       "+getDisplayString(hand.get(i),"")+" │ ");}
            }
            goFishConsole.print("\n");
            for(int i = 0; i <hand.size(); i++) {goFishConsole.print("└─────────┘ ");}

            goFishConsole.print("\n");

        }

    }

    public void displayTurnMessage() {
        goFishConsole.println("It is now your turn. - " + name);
    }


    public Card pickACardForPlayerMessage(List<Card> hand) {

        int idx = 1;
        goFishConsole.println(name + " Your hand cards !!");

        for(Card card : hand){
            goFishConsole.println(idx + ". " + getDisplayString(card, card.getSign().toString() + " "));
            idx++;
        }

        goFishConsole.println(idx + ". " + "Quit");

        int value = 0;

        do {
            value = goFishConsole.getIntegerInput("What card would the player like to choose? " +
                    "\nEnter the Number choice - 1 to " + (hand.size()+1));
        }while(value > (hand.size()+ 1));

        if(value == hand.size() + 1)
            return null;
        return hand.get(value - 1);
    }

    public void doesHaveCardMessage() {
        goFishConsole.println("You have a match in your hand.");
    }

    public void cardToAskForMessage( Card card) {


        String value = getDisplayString(card, card.getSign().toString() + " ");
        goFishConsole.println(name + " has chosen a ["+ value + "].");
    }
    private String getDisplayString(Card card, String initalString){
        String value = initalString;
        if(card.getValue() == 1) {value += "A";}
        else if(card.getValue() == 2) {value += "2";}
        else if(card.getValue() == 3) {value += "3";}
        else if(card.getValue() == 4) {value += "4";}
        else if(card.getValue() == 5) {value += "5";}
        else if(card.getValue() == 6) {value += "6";}
        else if(card.getValue() == 7) {value += "7";}
        else if(card.getValue() == 8) {value += "8";}
        else if(card.getValue() == 9) {value += "9";}
        else if(card.getValue() == 10) {value += "10";}
        else if(card.getValue() == 11) {value += "J";}
        else if (card.getValue() == 12) {value += "Q";}
        else if (card.getValue() == 13) {value += "K";}
        return value;
    }
    public void doesNotHaveCardMessage(Card card) {
        String value = getDisplayString(card, "");

        goFishConsole.println(name + " - Your opponent does not have a [" +value+"]. Go Fish!");

    }


    public void doesHaveCardMessage(Card card) {

        String value = getDisplayString(card, "");

        goFishConsole.println(name + " have taken the [" + value + "] from his opponent. "+
                name + " have a match.");
    }


    public void winningMessage() {
        goFishConsole.println(name +" have won! Would you like to play again?");
    }

    public void losingMessage() {
        goFishConsole.println("You Lose. Would you like to try again?");
    }

    public void printResult(boolean gameReuslt) {
        if(gameReuslt = true) {
            winningMessage();
        } else if (gameReuslt = false) {
            losingMessage();
        }
    }

    public void cardDrawnMessage(Card card){
        goFishConsole.println(name + " - You have drawn - "+
                getDisplayString(card, card.getSign().toString() + " "));

    }

    private String getDisplaySymbol(Card card, String initalString){
        String value = initalString;
        if(card.getSign() == SignType.Spade) {value += "♠";}
        else if(card.getSign() == SignType.Clover) {value += "♣";}
        else if(card.getSign() == SignType.Diamond) {value += "♦";}
        else if(card.getSign() == SignType.Heart) {value += "♥";}

        return value;
    }

    public void exitMessage() {
        goFishConsole.println("Thank you for playing. Have a good day! ♠♦♥♣");
    }


}

