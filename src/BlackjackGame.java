import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BlackjackGame {
  // Constants for card values
  private static final int ACE_LOW_VALUE = 1;
  private static final int ACE_HIGH_VALUE = 11;
  private static final int JACK_QUEEN_KING_VALUE = 10;

  // Constants for the maximum number of cards in a deck
  private static final int MAX_NUM_CARDS_IN_DECK = 104;

  // Dynamic programming table for storing maximum earnings
  private static int[][] earningsTable;

  // Recursive function for calculating maximum earnings
  private static int maxEarnings(int[] deck, int currentCardIndex, int currentHandValue, int dealerHandValue) {
    // Base case: if the current hand value is greater than 21, return 0
    if (currentHandValue > 21) {
      return 0;
    }

    // Base case: if the current card index is greater than the length of the deck, return 0
    if (currentCardIndex >= deck.length) {
      return 0;
    }

    // Check if the value has already been calculated and stored in the table
    if (earningsTable[currentCardIndex][currentHandValue] != -1) {
      return earningsTable[currentCardIndex][currentHandValue];
    }

    // Get the value of the current card
    int currentCardValue = getCardValue(deck[currentCardIndex]);

    // Calculate the maximum earnings by taking the current card or not taking it
    int maxEarnings = Math.max(
      // Case 1: take the current card and calculate the maximum earnings from the remaining cards
      maxEarnings(deck, currentCardIndex + 1, currentHandValue + currentCardValue, dealerHandValue) + getEarnings(currentHandValue + currentCardValue, dealerHandValue),
      // Case 2: don't take the current card and calculate the maximum earnings from the remaining cards
      maxEarnings(deck, currentCardIndex + 1, currentHandValue, dealerHandValue)
    );

    // Store the calculated value in the table for future reference
    earningsTable[currentCardIndex][currentHandValue] = maxEarnings;

    return maxEarnings;
  }

  // Function for getting the value of a card
  private static int getCardValue(int card) {
    if (card % 13 == 0 || card % 13 > 9) {
      return JACK_QUEEN_KING_VALUE;
    } else if (card % 13 == 1) {
      return ACE_HIGH_VALUE;
    } else {
      return card % 13;
    }
  }

  // Function for getting the earnings from a hand
  private static int getEarnings(int playerHandValue, int dealerHandValue) {
    if (playerHandValue > 21) {
      return -1;
    } else if (dealerHandValue > 21 || playerHandValue > dealerHandValue) {
      return 1;
    } else {
      return 0;
    }
  }

  

    // Function for shuffling an array of cards
    private static void shuffleArray(int[] deck) {
      Random rand = new Random();
      for (int i = deck.length - 1; i > 0; i--) {
        int index = rand.nextInt(i + 1);
        int temp = deck[index];
        deck[index] = deck[i];
        deck[i] = temp;
      }
    }

    public static void main(String[] args) {
      // Initialize the dynamic programming table with -1
      earningsTable = new int[MAX_NUM_CARDS_IN_DECK][22];
      for (int[] row : earningsTable) {
        Arrays.fill(row, -1);
      }

      // Get the deck of cards from the user or generate a random deck
      int[] deck = getDeckFromUserOrGenerateRandom();

      // Calculate and print the maximum earnings
      int maxEarnings = maxEarnings(deck,
    		  0, 0, getDealerHandValue(deck[0]));
      System.out.println("Maximum earnings: " + maxEarnings);
    }

    // Function for getting the deck of cards from the user or generating a random deck
    private static int[] getDeckFromUserOrGenerateRandom() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter 1 to enter the sequence of the deck or 2 to generate a random deck:");
      int choice = scanner.nextInt();
      if (choice == 1) {
        return getDeckFromUser();
      } else {
        return generateRandomDeck();
      }
    }
    
    // Function for generating a random order of cards
    private static int[] generateRandomDeck() {
      int[] deck = new int[MAX_NUM_CARDS_IN_DECK];
      for (int i = 0; i < MAX_NUM_CARDS_IN_DECK; i++) {
          deck[i] = i;
        }
        shuffleArray(deck);
        System.out.print("Deck = [");
        for(int i = 0 ; i < deck.length ; i++) {
      	  System.out.print(deck[i]+",");
        }
        System.out.print("]\n");
        return deck;
      }
    
    // Function for getting the deck of cards from the user
    private static int[] getDeckFromUser() {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the sequence of the deck in the form c0,c1,...,cn-1 (e.g. 5,4,11,29,39,45,...):");
      String[] input = scanner.nextLine().split(",");
      int[] deck = new int[input.length];
      for (int i = 0; i < input.length; i++) {
        deck[i] = Integer.parseInt(input[i]);
      }
      System.out.print("Deck = [");
      for(int i = 0 ; i < deck.length ; i++) {
    	  System.out.print(deck[i]+",");
      }
      System.out.print("]\n");
      return deck;
    }

    // Function for getting the starting hand value of the dealer
    private static int getDealerHandValue(int dealerCard1) {
      int dealerHandValue = getCardValue(dealerCard1);
      if (dealerHandValue == ACE_HIGH_VALUE && dealerHandValue + ACE_LOW_VALUE <= 21) {
        dealerHandValue += ACE_LOW_VALUE;
      }
      return dealerHandValue;
    }
  }
