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
         for(int row = 0; row < board.length(); row++)
         {
            for(int col = 0; col < board[row].length(); col++)
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
      for(int row = 0; row < board.length(); row++)
      {
         for(int col = 0; col < board[row].length(); col++)
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
      int[][] copyboard = new int[board.length][];
      for (int i = 0; i < board.length; i++)
      {
        copyboard[i] = Arrays.copyOf(board[i], board[i].length);
      }
      copy.board = copyboard;
      return copy;
   }
   public boolean up()
   {
      
   }
   public boolean down()
   {
      
   }
   public boolean left()
   {
      
   }
   public boolean right()
   {
      
   }
   public int[][] getBoard()
   {
      
   }
}