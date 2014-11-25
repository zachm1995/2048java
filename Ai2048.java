import java.util.*;
public class Ai2048
{
	static void playLeft(TwoThousandFourtyEight board)
   {
		while (board.left())
      {
			
		}
	}
	static void playRandom(TwoThousandFourtyEight board)
   {
      new java.util.Random();
      double rand = Math.random();
      if (rand <= .25)
      {
         rand = 1;
      }
      else if (rand <= .5)
      {
         rand = 2;
      }   
      else if (rand <= .75)
      {
         rand = 3;
      }
      else
      {
         rand = 4;
      }
      while(board.left() || board.right() || board.up() || board.down())
      {
         switch ((int)rand)
         {
            case 1:
               board.left();
               break;
            case 2:
               board.right();
               break;
            case 3:
               board.up();
               break;
            case 4:
               board.down();
               break;         
         }
      }
	}
	static void playAI(TwoThousandFourtyEight board)
   {
      while(board.left() || board.right() || board.up() || board.down())
      {
         board.left();
         board.right();
         board.up();
      }
	}
}
