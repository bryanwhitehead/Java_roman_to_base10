public class RomanNumerals {

  public static String toRoman(int n) {
    if (n == 0) return null;                // check for  blank and return null per instructions.
    
    String s = "";
    
    int[] baseTen = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] baseRom = {"M", "CM", "D", "CD" , "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    int i = 0;
   
      for (int x = 0; x < 13; x++)          // loop through each value pair and subtract out the base 10 value and add the roman numeral to the string s
      {
        if (n - baseTen[x] >= 0)
        {
          s += baseRom[x];
          n -= baseTen[x];
          x--;
        }
      }
    return s;
  }
  
  public static int fromRoman(String romanNumeral) {

    int[] baseTen = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] baseRom = {"M", "CM", "D", "CD" , "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    int num = 0;
    
    for (int i = 1; i < 13; i += 2)                                 // loop over every other item to add values to num for the 2 letter numerals and pop them out.
    {
      num += (( romanNumeral.split(baseRom[i], -1).length ) - 1) * baseTen[i];
      romanNumeral = romanNumeral.replace(baseRom[i],"");
    }
    for (int i = 0; i < 13; i += 2)                                 // loop over every other item to add values to num for the 1 letter numerals.
    {
      num += (( romanNumeral.split(baseRom[i], -1).length ) - 1) * baseTen[i];
    }
    
    return num;
  }
}