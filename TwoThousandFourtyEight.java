public class TwoThousandFourtyEight
{
   private int score;
   private int hightile;
   public int getScore()
   {
      int tempscore = 0;
      for(int row = 0; row < board.length(); row++)
      {
         for(int col = 0; col < board[row].length(); col++)
         {
            if(board[row][col] > tempscore)
            {
               tempscore = board[row][col];
            }
         }
      }
      score = tempscore;
      return score;
   }
   public int getHighestTile()
   {
      return hightile;
   }
   public TwoThousandFourtyEight copy()
   {
      TwoThousandFourtyEight copy = new TwoThousandFourtyEight();
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
   public TwoThousandFourtyEight(int x, int y)
   {
   
   }
   public int[][] getBoard()
   {
   
   }
}