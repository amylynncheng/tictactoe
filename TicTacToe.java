public class TicTacToe {
   protected char[] board;
   protected char userMarker;
   protected char aiMarker;
   protected char currentMarker;
   protected char winner;
   
   public TicTacToe(char playerToken, char aiToken) {
      userMarker = playerToken;
      aiMarker = aiToken;
      winner = '-';
      board = setBoard();
      currentMarker = userMarker;
   
   }
   
   public static char[] setBoard() {
      char[] board = new char[9];
      for (int i = 0; i < board.length; i++) {
         board[i] = '-';
      }
      return board;
   }
   
   public boolean playTurn(int placement) {
      boolean isValid = withinRange(placement) && !isSpotTaken(placement);
      if (isValid) {
         board[placement - 1] = currentMarker;
         currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
      }
      return isValid;
   }
   
   public boolean withinRange(int placement) {
      return placement > 0 && placement < board.length + 1;
   }
   
   public boolean isSpotTaken(int placement) {
      return board[placement - 1] != '-';
   }
   
   public void printBoard() {
      System.out.println();
      for (int i = 0; i < board.length; i++) {
         if (i % 3 == 0 && i != 0) {
            System.out.println();
            System.out.println("--------------");
         }
         System.out.print(" | " + board[i]);
      }
      System.out.println();
   }
   
   public static void printIndexBoard() {
      System.out.println();
      for (int i = 0; i < 9; i++) {
         if (i % 3 == 0 && i != 0) {
            System.out.println();
            System.out.println("--------------");
         }
         System.out.print(" | " + (i + 1));
      }
      System.out.println();
   }
   
   public boolean winnerExists() {
      boolean diagonalsAndMiddles = (rightDiag() || leftDiag() || secondRow() || secondCol())
         && board[4] != '-';
      boolean firsts = (firstRow() || firstCol()) && board[0] != '-';
      boolean thirds = (thirdRow() || thirdCol()) && board[8] != '-';
      
      if (diagonalsAndMiddles) {
         this.winner = board[4];
      } else if (firsts) {
         this.winner = board[0];
      } else if (thirds) {
         this.winner = board[8];
      } 
      
      return diagonalsAndMiddles || firsts || thirds;
   }
   
   public boolean firstRow() {
      return board[0] == board[1] && board[1] == board[2];
   }
   
   public boolean secondRow() {
      return board[3] == board[4] && board[4] == board[5];
   }
   
   public boolean thirdRow() {
      return board[6] == board[7] && board[7] == board[8];
   }

   public boolean firstCol() {
      return board[0] == board[3] && board[3] == board[6];
   }
   
   public boolean secondCol() {
      return board[1] == board[4] && board[4] == board[7];
   }
   
   public boolean thirdCol() {
      return board[2] == board[5] && board[5] == board[8];
   }
   
   public boolean rightDiag() {
      return board[0] == board[4] && board[4] == board[8];
   }
   
   public boolean leftDiag() {
      return board[2] == board[4] && board[4] == board[6];
   }
   
   public boolean isBoardFull() {
      for (int i = 0; i < board.length; i++) {
         if (board[i] == '-') {
            return false;
         }
      }
      return true;
   }
   
   public String gameOver() {
      boolean hasWinner = winnerExists();
      if (hasWinner) {
         return "We have a winner! The winner is " + winner + "'s.";
      } else if (isBoardFull()) {
         return "Draw: Game Over!";
      } else {
         return "Game still going";
      }
   
   }
}