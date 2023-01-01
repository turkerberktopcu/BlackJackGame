Sample Input ==> 50,3,37,38,32,18,17,7,2,30,19,20,22,21,24,23,12,13,14,15,8,10,9,11,25,26,27,28,29,31,33,34,35,36,39,40,41,42,44,43,46,45,51,48,47,49,4,1,0,5,6,16,50,3,37,38,32,18,17,7,2,30,19,20,22,21,24,23,12,13,14,15,8,10,9,11,25,26,27,28,29,31,33,34,35,36,39,40,41,42,44,43,46,45,51,48,47,49,4,1,0,5,6,16

The algorithm implemented in this code is designed to maximize the player's earnings by considering all possible combinations of hitting and standing and choosing the one that results in the highest earnings.
Te algorithm stores the maximum earnings at each stage of the game in a dynamic programming table and uses recursion to calculate the maximum earnings from the remaining cards.



-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------




The rules for the game of blackjack are as follows:
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
-> The player and the dealer are each dealt two cards. The dealer's first card is dealt face up, while the second card is dealt face down (the "hole" card). 
The player's two cards are dealt face up.

-> The player can then choose to "hit" (receive another card) or "stand" (stop receiving cards). 
If the player goes over 21, they lose the game (bust).

-> After the player stands, the dealer reveals their hole card and hits or stands according to a set of rules. 
The dealer must hit if their hand value is less than 17, and must stand if their hand value is 17 or higher. If the dealer busts, the player wins the game.

-> If the player and the dealer do not bust, the hand with the highest value wins.

In this code is designed to maximize the player's earnings by considering all possible combinations of hitting and standing and choosing the one that results in the highest earnings.
The algorithm stores the maximum earnings at each stage of the game in a dynamic programming table and uses recursion to calculate the maximum earnings from the remaining cards.

The maxEarnings() function is a recursive function that takes in the following parameters:
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

-> deck: the deck of cards as an integer array
-> currentCardIndex: the current index of the card being considered
-> currentHandValue: the current hand value of the player
-> dealerHandValue: the current hand value of the dealer
The base case for the function is when the current hand value is greater than 21, in which case the function returns 0. This is because the player has busted and cannot earn any more points.
The function also has a base case for when the current card index is greater than the length of the deck, in which case it also returns 0. This is because there are no more cards left to consider.
And function checks if the maximum earnings at the current stage of the game have already been calculated and stored in the earningsTable array. If they have, the function simply returns the stored value.
The function calculates the maximum earnings by considering two cases: taking the current card or not taking it. It calculates the maximum earnings for each case by calling the maxEarnings() function recursively and passing in the updated parameters.
Then the function stores the calculated maximum earnings in the earningsTable array for future reference and returns the maximum earnings.

The getCardValue() function:
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Takes in a card as an integer and returns its value in the game of blackjack. If the card is an ace, it returns the value of 11, because this is usually more beneficial to the hand. 
If the card is a jack, queen, or king, it returns the value of 10.
Otherwise, it returns the value of the card modulo 13 (the remainder when the card value is divided by 13), which gives the face value of the card.

The getEarnings() function:
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Takes in the hand values of the player and the dealer as integers and returns the earnings for the player. 
If the player's hand value is greater than 21 (bust), the function returns -1 because the player loses. 
If the dealer's hand value is greater than 21 (bust) or the player's hand value is greater than the dealer's hand value, the function returns 1 because the player wins. 
Otherwise, it returns 0 because the game is a tie.

The generateRandomDeck() function:
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Generates a random order of cards by creating an array of integers from 0 to 103 (the maximum number of cards in the deck), 
shuffling the array using the shuffleArray() function, and returning the shuffled array.

The shuffleArray() function:
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Shuffles an array of cards by using the Fisher-Yates shuffle algorithm, which randomly swaps the elements of the array.

The main() function:
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Initializes the earningsTable array with -1 and gets the deck of cards from the user or generates a random deck using the getDeckFromUserOrGenerateRandom() function.
It then calculates the maximum earnings using the maxEarnings() function and prints the result.





