/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.eniso.tp3;

import java.util.ArrayList;

/**
 *
 * @author chams
 */
public class Tp3 {

    public static void main(String[] args) {
     FileHandler fileHandler = new FileHandler("file.log");
     int lineIndexToreverse=1 ;
     fileHandler.reverseString(lineIndexToreverse);
     int lineIndexToRemoveDuplicates =2;
     fileHandler.removeDuplicates(lineIndexToRemoveDuplicates);
     String pattern="epoch";
        ArrayList<String> linesWithPattern=fileHandler.findLinesWithPattern(pattern);
     String str1="hello";
     String str2="Hello";
     System.out.println("Comparaison avec equals "+fileHandler.compareString1(str1, str2));
      String str3="hello";
     String str4="HELLO";
     System.out.println("Comparaison avec equalsIgnoreCase "+fileHandler.compareString2(str3, str4));
       String str5="hello";
     String str6="hello";
      System.out.println("Comparaison avec == "+fileHandler.compareString3(str5, str6));
  
   System.out.println("Comparaison avec == "+fileHandler.compareString3(new String("hello"), "hello"));
    System.out.println("Comparaison avec == "+fileHandler.compareString3(new String("hello"), new String("hello")));
  

    
      System.out.println("ligne contenant le motif '"+pattern+"' "+linesWithPattern.get(0));
   
    }
}
