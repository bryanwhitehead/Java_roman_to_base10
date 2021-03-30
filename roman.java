public class RomanNumerals {

  public static String toRoman(int n) {
    if (n == 0) return null;
    
    String s = "";
    
    int[] baseTen = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] baseRom = {"M", "CM", "D", "CD" , "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    int i = 0;
   
      for (int x = 0; x < 13; x++)
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
    
    for (int i = 1; i < 13; i += 2)
    {
      num += (( romanNumeral.split(baseRom[i], -1).length ) - 1) * baseTen[i];
      romanNumeral = romanNumeral.replace(baseRom[i],"");
    }
    for (int i = 0; i < 13; i += 2)
    {
      num += (( romanNumeral.split(baseRom[i], -1).length ) - 1) * baseTen[i];
    }
    
    return num;
  }
}