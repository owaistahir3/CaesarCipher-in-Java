 // Import the File class
 import java.io.File;

import java.io.FileNotFoundException;

 // Import the Scanner class to read text files
import java.util.Scanner; 

class CaesarCipher 
{    
    public static StringBuffer encrypt(String text, int s) 
    { 
        StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<text.length(); i++) 
        { 
            if (Character.isUpperCase(text.charAt(i))) 
            { 
                char ch = (char)(((int)text.charAt(i) + 
                                  s - 65) % 26 + 65); 
                result.append(ch); 
            } 
            else
            { 
                char ch = (char)(((int)text.charAt(i) + 
                                  s - 97) % 26 + 97); 
                result.append(ch); 
            } 
        } 
        return result; 
    } 

    public static StringBuffer Keys(String cipher) 
    { String text = "";


    try {
        File myObj = new File("Keys.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
        text = myReader.nextLine();
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        } 

       StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<cipher.length(); i++) 
        { 
            if (Character.isUpperCase(cipher.charAt(i))) 
            { 
                char ch = cipher.charAt(i);
                int n = ch;
                n = n - 65;
                result.append(text.charAt(n));
                n=0;
            }    
            else
            { 
                char ch = cipher.charAt(i);
                int n = ch;
                n = n - 97;
                result.append(text.charAt(n));
                n=0;
                
            } 
        }
        return result; 
    }

    public static StringBuffer Decrypt(String cipher, int s) 
    { String text = "";

    try {
        File myObj = new File("Keys.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
        text = myReader.nextLine();
        }
        myReader.close();
     } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
       StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<cipher.length(); i++) 
        { 
            for (int j = 0; j<text.length(); j++){

            if (cipher.charAt(i) == text.charAt(j)) 
            { 
                int n = j;
                n = n + 65;
                n = n - s - 65;

                if (n < 0){
                    n = 91 + n;
                    char ch2 = (char) n;
                    result.append(ch2);
                }
                else{
                char ch1 = (char)(n % 26 + 65); 
                result.append(ch1);
                }
                break;
            }    
        }  
        }
        return result; 
    }
  
    // Driver code 
    public static void main(String[] args) 
    { String text = "";
    try {
        File myObj = new File("Message.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          text = myReader.nextLine();
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      } 
        int s = 4; 
        System.out.println("Text  : " + text); 
        System.out.println("Shift : " + s); 
        System.out.println("Cipher: " + Keys(encrypt(text, s).toString()));
        System.out.println("Decrypted: " + Decrypt(Keys(encrypt(text, s).toString()).toString(), s));
    } 
}