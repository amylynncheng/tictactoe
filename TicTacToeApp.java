import java.util.Scanner;

public class TicTacToeApp {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      boolean continuePlaying = true;
      
      while (continuePlaying) {
         System.out.println("Welcome to Tic Tac Toe! "
            + "First, enter a single character that will represent you on the board.");
         char playerToken = input.next().charAt(0);   
         System.out.println("Now enter a single character that will represent your opponent on the board.");
         char opponentToken = input.next().charAt(0);   
         
         TicTacToe game = new TicTacToe(playerToken, opponentToken);
         AI opponent = new AI();
         
         //Set up the game
         System.out.println();
         System.out.println("Now we can begin. To play, enter a number and your token will " 
            + "be put in its place!");
         TicTacToe.printIndexBoard();
         System.out.println();
                     
         //Playing game
         while (game.gameOver().equals("Game still going")) {
            if (game.currentMarker == game.userMarker) {
               //USER TURN
               System.out.println("It's your turn! Enter a number for your token: ");
               int number = input.nextInt();
               while (!game.playTurn(number)) {
                  System.out.println(number + " is invalid. Try again.");
                  number = input.nextInt();
               }
               System.out.println("You picked " + number);
            } else {
               //AI TURN
               System.out.println("It's my turn!");
               int AInumber = opponent.pickSpot(game);
               game.playTurn(AInumber);
               System.out.println("I picked " + AInumber);
            }
            //Print out new, updated board
            game.printBoard();
            System.out.println();
         
         }
         
         System.out.println(game.gameOver());
         System.out.println();
         
         System.out.println("Do you want to play again? Enter 'Y' for yes and 'N' for no.");
         char response = input.next().charAt(0);
         continuePlaying = (response == 'Y');
         System.out.println("\n\n");
      }
   }
}