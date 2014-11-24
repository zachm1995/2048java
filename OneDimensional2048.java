public class OneDimensional2048
{
   public static void main (String [] argv)
   {
      int[] row;

      assert(!validateValue(8, 4));
      assert(validateValue(8, 8));
      assert(validateValue(8, 16));
      assert(validateValue(0, 16));
      assert(validateValue(2, 2048));
      assert(!validateValue(7, 2048));
      assert(!validateValue(1023, 2048));
      assert(!validateValue(1025, 2048));
   
      assert(validateRow(new int[]{2, 2, 2, 2}));
      assert(validateRow(new int[]{0, 2, 4, 0, 32}));
      assert(!validateRow(new int[]{2, 2, 0, 3, 4, 0}));
      assert(validateRow(new int[]{}));
      assert(!validateRow(new int[]{8, 2, 64, 32, 30}));

      row = new int[]{0,0,4,0,0};
      assert(moveLeft(row) && identicalRows(new int[]{4,0,0,0,0}, row));
      row = new int[]{0,0,4,0,0};
      assert(moveLeft(row) && !identicalRows(new int[]{4,0,0,0,0,0}, row));
      row = new int[]{2,0,4,0,0,16};
      assert(moveLeft(row) && identicalRows(new int[]{2,4,16,0,0,0}, row));
      row = new int[]{0,0,0};
      assert(moveLeft(row) && identicalRows(new int[]{0,0,0}, row));
      assert(!moveLeft(new int[]{2,0,31}));
      row = new int[]{4,16,2048};
      assert(moveLeft(row) && identicalRows(new int[]{4,16,2048}, row));
   
      row = new int[]{8,8,16,16,32,32};
      assert(combineLeft(row) && identicalRows(new int[]{16,32,64,0,0,0}, row));
      row = new int[]{2,0,2,8,0,8,64,0,64,0};
      assert(combineLeft(row) && identicalRows(new int[]{4,16,128,0,0,0,0,0,0,0}, row));
      row = new int[]{2,0,8,2,0,64,4,0,64,0};
      assert(combineLeft(row) && identicalRows(new int[]{2,8,2,64,4,64,0,0,0,0}, row));
      row = new int[]{2,0,8,2,0,64,4,0,64,0};
      assert(combineLeft(row) && identicalRows(new int[]{2,8,2,64,4,64,0,0,0,0}, row));
      row = new int[]{0,0,2,2,128,64,0,64};
      assert(combineLeft(row) && identicalRows(new int[]{4,128,128,0,0,0,0,0}, row));
      row = new int[]{0,0,2,2,128,1234,64,0,64};
      assert(!combineLeft(row));
      row = new int[]{};
      assert(combineLeft(row) && identicalRows(new int[]{}, row));

      row = new int[]{0,1024,512,256,128,64,32,16,8,4,2,0,2,0};
      assert(combineLeft(row) && combineLeft(row) && combineLeft(row) && combineLeft(row) && 
      combineLeft(row) && combineLeft(row) && combineLeft(row) && combineLeft(row) && 
      combineLeft(row) && combineLeft(row) && identicalRows(new int[]{2048,0,0,0,0,0,0,0,0,0,0,0,0,0}, row));
   }
   public static boolean identicalRows(int[] row1, int[] row2)
   {
      boolean isidentical = true;
      if (row1.length == row2.length)
      {
         for (int i = 0; i < row1.length; i++)
         {
            if (row1[i] != row2[i])
            {
               isidentical = false;
            }
         }
      }
      else
      {
         isidentical = false;
      }
      return isidentical;
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
   public static boolean combineLeft(int[] row)
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
         return true;
      }
      else
      {
         return false;
      }
   }
}