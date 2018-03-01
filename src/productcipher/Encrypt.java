/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author HP
 */
public class Encrypt {
    
    private static int key;
    private static int value;
    private static String add;
    private static int length;
    private static StringBuilder shiftedString;
    private static StringBuilder permutedString;
    
    static String getKey(int length) {
        //key=random value+length of the text
        Random random=new Random();
        key=random.nextInt(5)+1;
        return key+""+length;
    }
    static String encrypt(String text,String key) {
        //encrypt using subtitution- add key value to the ASCII value and get a new character
        shiftedString= new StringBuilder();
        value=Character.getNumericValue(key.charAt(0));
        for(int i=0;i<text.length()-1;i++){
           int index=(int)text.charAt(i)+value;
           shiftedString.append((char)index);
          
        }
        //encrypt using permutation
        //here a fixed block size=4 is used and change the position of each character in the block 
        permutedString= new StringBuilder();
        //if the text can not be divided in to full size 4 blocks fill the text with "x"
        switch(shiftedString.toString().length()%4){
            case 1: add="xxx";
                    break;
            case 2: add="xx";
                    break;
            case 3: add="x";
                    break;
        }
        shiftedString.append(add);
       //change the character positions in the block
        for(int i=0;i<shiftedString.toString().length();i+=4){
            permutedString.append(shiftedString.toString().charAt(i+2));
            permutedString.append(shiftedString.toString().charAt(i+1));
            permutedString.append(shiftedString.toString().charAt(i+3));
            permutedString.append(shiftedString.toString().charAt(i));
           
        }
        
        return permutedString.toString();
    }

    
    
}
