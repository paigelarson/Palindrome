

import javax.swing.JOptionPane;
import java.lang.Character;

// this class figures out if a word is a palindrome or not

public class Palindrome 
{

	    public boolean isPalindrome(String word) 
    {
        String first=word.substring(0,1);
        String last=word.substring(word.length()-1);
        boolean end=false;
        boolean pal = false;
        
        while(!end)
        {
            first = word.substring(0,1);
            last = word.substring(word.length()-1);
            if(word.length()<=3)
            {
                //System.out.println("word: " + word);
                //System.out.println(first);
                //System.out.println(last);
                if(first.equals(last)){
                   end = true; 
                   pal = true;
                }else{
                    end = true;
                    pal = false;
                }
            }
            else if(first.compareTo(last)==0 && word.length()>3)
            {
                word=word.substring(1,word.length()-1);
                end=false;
            }
            else if(first.compareToIgnoreCase(last)>0)
            {
                end= true;
                pal=false;
            }
            else if(first.compareToIgnoreCase(last)<0)
            {
                end= true;
                pal=false;
            } 
               System.out.println(word);
        }
        
      
        return pal;
    }
    
  
    public String cleanUp(String word)
    {
        word = word.replace(" ", "");
        for(int i=0; i < word.length(); i++)
        {
            char c= word.charAt(i);
            Character ch= new Character(c);
            if(!Character.isUnicodeIdentifierPart(ch) && !Character.isDigit(ch)){
                word = word.substring(0,i) + word.substring(i + 1);
            }else{
                i++;
            }
            //System.out.println(word);
        }
        return word;
    }
        public static void main(String[] args)
    {
        Palindrome yay= new Palindrome();
    	String user=JOptionPane.showInputDialog("Please give me a word.");
        String userOneWord= yay.cleanUp(user);
        String userCapital=userOneWord.toUpperCase();
        boolean finals=yay.isPalindrome(userCapital);
        if(finals==true)
        {
            JOptionPane.showMessageDialog(null,"Congrats friend! "+userCapital+"  is a palindrome.");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "I'm sorry, "+userCapital +" is not a palindrome.");
        }
        
        
    }
   
}