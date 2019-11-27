package encryption;
import java.util.Scanner;

public class EncryptionProcedures {
  
    private static final String[] arrPeriodicTableValues = {"h", "he", "li", "be", "b", "c", "n", "o", "f", "ne", "na", "mg", "al", "si", "p", "s", "cl", "ar", "k", "ca", "sc", "ti", "v", "cr", "mn", "fe", "co", "ni", "cu", "zn", "ga", "ge", "as", "se", "br", "kr", "rb", "sr", "y", "zr", "nb", "mo", "tc", "ru", "rh", "pd", "ag", "cd", "in", "sn", "sb", "te", "i", "xe", "cs", "ba", "la", "ce", "pr", "nd", "pm", "sm", "eu", "gd", "tb", "dy", "ho", "er", "tm", "yb", "lu", "hf", "ta", "w", "re", "os", "ir", "pt", "au", "hg", "tl", "pb", "bi", "po", "at", "rn", "fr", "ra", "ac", "th", "pa", "u", "np", "pu", "am", "cm", "bk", "cf", "es", "fm", "md", "no", "lr", "rf", "db", "sg", "bh", "hs", "mt", "ds", "rg", "cn", "nh", "fl", "mc", "lv", "ts", "og"};
    public static boolean periodicEncrypt(){
       
        String strInput = scanString(); //Original String
        String strResult = ""; //Encrypted string
        String maybeElement = ""; //2-letter sample
        int strLength = strInput.length(); //Length of original string
        int counter = 0; //String position
        int sampleIndex = -1; //The periodic index of the sample
        
        // 1.
        while(counter < strLength){
            
            // 2.	
            if(counter == strLength-1){ //if there's nothing after the first letter, ignore the following one to prevent program crash
                maybeElement = strInput.substring(counter, counter+1);
                sampleIndex = -1; 
            }else{
                maybeElement = strInput.substring(counter, counter+2);
                sampleIndex = findIndex(arrPeriodicTableValues, maybeElement);
            }
            
            // 3.
            if(sampleIndex > -1){
                // a.
                strResult = strResult + (sampleIndex + 1);
                counter = counter + 2;
            }else{
                // b.
                sampleIndex = findIndex(arrPeriodicTableValues, maybeElement.substring(0,1));
                // i.
                if(sampleIndex > -1){
                    // a.
                    strResult = strResult + (sampleIndex + 1);
                    counter++;
                }else {
                    // b.
                    strResult = strResult  + maybeElement.substring(0,1);
                    counter++;
                }
            } 
            // 4.
        }
       // 5.
        System.out.println(strResult);
        return true;
    }
    
    private static int findIndex(String arr[], String sample){
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equalsIgnoreCase(sample)){
                index = i;
                break;
            }  
        }
        return index;
    }
    
    private static String scanString(){
       Scanner scan = new Scanner(System.in); 
       String input = scan.nextLine();
       return input;
    }
    
    public static boolean cesarShift(){
        System.out.print("Enter the word you want to be encrypted: ");
        String word = scanString();
        int lengthofword = word.length();
        char[] asciivalue = word.toCharArray();
        String codedword = "";
        System.out.print("Enter the amount of shift you want : ");
        int myShift = Integer.parseInt(scanString());
        for (int i = 0; i < lengthofword; i++) {             
            int ascii = (int)asciivalue[i];
            if(ascii >= 97 && ascii <= 122)
            {
                ascii= ascii + myShift;
                if(ascii>122){
                    ascii = ascii - 26;
                }
            }
            if(ascii >= 65 && ascii <= 90)
            {
                ascii= ascii + myShift;
                if(ascii>90){
                    ascii = ascii - 26;
                }
            }
            codedword = codedword + Character.toString ((char) ascii);
        }
        System.out.println("Your encryoted code is: " + codedword);
        return true;
    }
    
}
