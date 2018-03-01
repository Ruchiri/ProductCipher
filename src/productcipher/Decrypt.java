/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher;

/**
 *
 * @author HP
 */
public class Decrypt {
    private static int key;
    private static int length;
    private static StringBuilder decrypt;
    private static String decryptText;
    private static StringBuilder originalText;
    String decrypt(String text,String key) {
        //take the shifting value
        this.key=Character.getNumericValue(key.charAt(0));
        //length of the original text
        this.length=Integer.parseInt(key.substring(1,key.length()));
        
        
        //original permutation
        decrypt=new StringBuilder();
        for(int i=0;i<text.toString().length()-3;i+=4){
            decrypt.append(text.charAt(i+3));
            decrypt.append(text.charAt(i+1));
            decrypt.append(text.charAt(i));
            decrypt.append(text.charAt(i+2));
        }
        
        //remove additional characters[filled to make a block of 4]
        decryptText=decrypt.substring(0,length);
        
        originalText=new StringBuilder();
        //make original text by shifting
        for(int i=0;i<decryptText.length();i++){
            originalText.append((char)((int)decryptText.charAt(i)-this.key));
        }
        
        return originalText.toString();
    }
    
}
