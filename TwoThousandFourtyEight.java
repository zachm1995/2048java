import java.util.*;
public class TwoThousandFourtyEight
{
   private int score;
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
               switch(board[row][col])
               {
                  case 2:
                     tempscore += 2;
                     break;
                  case 4:
                     tempscore += 4+2;
                     break;
                  case 8:
                     tempscore += 8+4+2;
                     break;
                  case 16:
                     tempscore += 16+8+4+2;
                     break;
                  case 32:
                     tempscore += 32+16+8+4+2;
                     break;
                  case 64:
                     tempscore += 64+32+16+8+4+2;
                     break;
                  case 128:
                     tempscore += 128+64+32+16+8+4+2;
                     break;
                  case 256:
                     tempscore += 256+128+64+32+16+8+4+2;
                     break;
                  case 512:
                     tempscore += 512+256+128+64+32+16+8+4+2;
                     break;
                  case 1024:
                     tempscore += 1024+512+256+128+64+32+16+8+4+2;
                     break;
                  case 2048:
                     tempscore += 2048+1024+512+256+128+64+32+16+8+4+2;
                     break;
                  case 4096:
                     tempscore += 4096+2048+1024+512+254+128+64+32+16+8+4+2;
                     break;                           
               }
            }
         }   
      }
      score = tempscore;
      return score;
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
      board = TwoDimensional2048.up();
      TwoDimensional2048.addNewValue();
      if (TwoDimensional2048.numUnoccupied == 0)
      {
         return false;
      }
   }
   public boolean down()
   {
      board = TwoDimensional2048.down();
      TwoDimensional2048.addNewValue();
      if (TwoDimensional2048.numUnoccupied == 0)
      {
         return false;
      }
   }
   public boolean left()
   {
      board = TwoDimensional2048.left();
      TwoDimensional2048.addNewValue();
      if (TwoDimensional2048.numUnoccupied == 0)
      {
         return false;
      }
   }
   public boolean right()
   {
      board = TwoDimensional2048.right();
      TwoDimensional2048.addNewValue();
      if (TwoDimensional2048.numUnoccupied == 0)
      {
         return false;
      }
   }
   public int[][] getBoard()
   {
      
   }
}