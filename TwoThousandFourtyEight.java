import java.util.*;
public class TwoThousandFourtyEight
{
   private int hightile;
   private int[][] board;
   public TwoThousandFourtyEight()
   {
   }
   public TwoThousandFourtyEight(int x, int y)
   {
      board =  TwoDimensional2048.blankBoard(x,y);
   }
   public int getScore()
   {
      int tempscore = 0;
      {
         for(int row = 0; row < board.length; row++)
         {
            for(int col = 0; col < board[row].length; col++)
            {
               for(int i = 2; i <= board[row][col];)
               {
                  if(board[row][col] > 0)
                  {
                     tempscore += i;
                  }
                  i = i*2;
               }
            }
         }
      }
      return tempscore;
   }
   public int getHighestTile()
   {
      int temp = 0;
      for(int row = 0; row < board.length; row++)
      {
         for(int col = 0; col < board[row].length; col++)
         {
            if (board[row][col] > temp)
            {
               temp = board[row][col];
            }
         }
      }
      hightile = temp;
      return hightile;
   }
   public TwoThousandFourtyEight copy()
   {
      TwoThousandFourtyEight copy = new TwoThousandFourtyEight();
      int[][] copyboard = new int[this.board.length][this.board[0].length];
      for (int row = 0; row < board.length; row++)
      {
         for(int col = 0; col < board[row].length; col++)
         {
            copyboard[row][col] = board[row][col];
         }
      }
      copy.board = copyboard;
      return copy;
   }
   public boolean up()
   {
      board = TwoDimensional2048.up(board);
      TwoDimensional2048.addNewValue(board);
      if (TwoDimensional2048.numUnoccupied(board) == 0)
      {
         return false;
      }
      return true;
   }
   public boolean down()
   {
      board = TwoDimensional2048.down(board);
      TwoDimensional2048.addNewValue(board);
      if (TwoDimensional2048.numUnoccupied(board) == 0)
      {
         return false;
      }
      return true;
   }
   public boolean left()
   {
      board = TwoDimensional2048.left(board);
      TwoDimensional2048.addNewValue(board);
      if (TwoDimensional2048.numUnoccupied(board) == 0)
      {
         return false;
      }
      return true;
   }
   public boolean right()
   {
      board = TwoDimensional2048.right(board);
      TwoDimensional2048.addNewValue(board);
      if (TwoDimensional2048.numUnoccupied(board) == 0)
      {
         return false;
      }
      return true;
   }
   public int[][] getBoard()
   {
      int[][] copyboard = new int[this.board.length][this.board[0].length];
      for (int row = 0; row < board.length; row++)
      {
         for(int col = 0; col < board[row].length; col++)
         {
            copyboard[row][col] = board[row][col];
         }
      }
      return copyboard;
   }
   public void printBoard()
   {
      for(int row = 0; row < board.length; row++)
      {
         for(int col = 0; col < board[0].length; col++)
         {
            System.out.print(board[row][col]);
         }
         System.out.println();
      }
   }  
}