import java.util.ArrayList;
import java.util.Random;

public class AI {
   
   public int pickSpot(TicTacToe game) {
      ArrayList<Integer> options = new ArrayList();
      
      for (int i = 0; i < 9; i++) {
         if (game.board[i] == '-') {
            options.add(i + 1);
         }
      }
      int index = (int) Math.floor(Math.random() * options.size());
      int choice = options.get(index);
      return choice;
   }
}