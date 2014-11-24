public class TwoDimensional2048
{
   public static boolean validateBoard(int[][] b)
   {
      for(int row = 0; row < b.length; row++)
      {
         if(!(OneDimensional2048.validateRow(b[row])))
         {
            return false;
         }
      }
      return true;
   }
   public static int[][] blankBoard(int x, int y)
   {
      int[][] board = new int [x][y];
      for(int row = 0; row < board.length; row++)
      {
         for(int col = 0; col < board[row].length; col++)
         {
            board[row][col] = 0;
         }
      }
      return board;
   }
   public static boolean identicalBoard(int[][] a, int[][] b)
   {
      boolean identical = true; 
      for (int row = 0; row < a.length; row++)
      {
         for (int col = 0; col < a[row].length; col++)
         {
            if (a[row][col] != b[row][col])
            {
               return false;
            }
         }
      }
      return identical;
   }
   public static int numUnoccupied(int[][] b)
   {
      int zerocount = 0;
      for (int row = 0; row < b.length; row++)
      {
         for (int col = 0; col < b[row].length; col++)
         {
            if (b[row][col] == 0)
            {
               zerocount += 1;
            }
         }
      }
      return zerocount;
   }
   public static int[] randCoord(int[][] b, int offset)
   {
      int zerocount = 0;
      int[] coord = new int[2];
      for (int row = 0; row < b.length; row++)
      {
         for(int col = 0; col < b[row].length; col++)
         {
            if (b[row][col] == 0)
            {
               zerocount += 1;
            }
            if (offset == zerocount-1)
            {
               coord[0] = row;
               coord[1] = col;
               return coord;
            }
         }
      }
      return coord;
   }
   public static boolean addNewValue(int[][] b)
   {
      int val = Rnd2048.randValue();
      int zerocount = numUnoccupied(b);
      int offset = Rnd2048.randValue();
      int[] coord = randCoord(b, offset);
      return true;
   }
   public static int[][] combineLeft(int[][] b)
   {
      for(int row = 0; row < b.length; row++)
      {
         b[row] = combineLeft2(b[row]);
      }
      return b;
   }
   public static int[][] rotateLeft(int[][] b)
   {
      int[][] newarray = new int[b.length][b.length];
      for (int row = 0; row < b.length; row++)
      {
         for (int col = 0; col < b[row].length; col++)
         {
            newarray[row][col] = b[row][col];
         }
      }
      if(b[0].length == newarray.length)
      {
         return newarray;
      }
      return b;
   }
   public static boolean validateValue(int value, int maxPowerOfTwo)
   {
      boolean isValid = false;
      if (value >= 0 && value <= maxPowerOfTwo)
      {
         if (value == 0)
         {
            isValid = true;
         }
         for (int i = 1; i < 30; i++)
         {
            if (Math.pow(2, i) == value)
            {
               isValid = true;
            }
         }
      }
      return isValid;
   }
   public static int[][] left(int[][] b)
   {
      combineLeft(b);
      return b;
   }
   public static int[][] right(int[][] b)
   {
      rotateLeft(b);
      rotateLeft(b);
      combineLeft(b);
      rotateLeft(b);
      rotateLeft(b);
      return b;
   }
   public static int[][] up(int[][] b)
   {
      rotateLeft(b);
      combineLeft(b);
      rotateLeft(b);
      rotateLeft(b);
      rotateLeft(b);
      return b;
   }
   public static int[][] down(int[][] b)
   {
      rotateLeft(b);
      rotateLeft(b);
      rotateLeft(b);
      combineLeft(b);
      rotateLeft(b);
      return b;
   }
   public static boolean validateRow(int[] row)
   {
      boolean validate = true;
      for (int i = 0; i < row.length; i++)
      {
         if(!validateValue(row[i],2048))
         {
            validate = false;
         }
      }
      return validate;
   }
   public static boolean moveLeft(int[] row)
   {
      if (validateRow(row))
      {
         int numMoved = 0;
         for (int i = 0; i < row.length; i++)
         {
            if (row[i] != 0)
            {
               row[numMoved] = row[i];
               numMoved++;
            }
         }
         for (int j = numMoved; j < row.length; j++)
         {
            row[j] = 0;
         }
         return true;
      } 
      else 
      {
         return false;
      }
   }

   public static int[] combineLeft2(int[] row)
   {
      if (validateRow(row))
      {
         moveLeft(row);
         for (int i = 0; i < row.length - 1; i++)
         {
            if (row[i] == row[i+1])
            {
               row[i] = row[i] * 2;
               row[i+1] = 0;
               moveLeft(row);
            }
         }
         return row;
      }
      else
      {
         System.out.println("invalid");
      }
      return row;
   }
}