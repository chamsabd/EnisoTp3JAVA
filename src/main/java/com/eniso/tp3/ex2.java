/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.eniso.tp3;

import java.util.ArrayList;

public class ex2 {
    
    
    
public static ArrayList<String> splitEqually(String text, int size) {
    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i < text.length(); i += size) {
        result.add(text.substring(i, Math.min(i + size, text.length())));
    }
    return result;
}



    public static String chiffrement(String text,String key){
       
  ArrayList<String> in = splitEqually(text,key.length());
    StringBuilder result = new StringBuilder();
    for(String s:in){
      
            for(int i=0;i<s.length();i++){
                 char xoredChar = (char) (s.charAt(i) ^ key.charAt(i));
            result.append(xoredChar);
            }
    }

        return result.toString();
        
    }
    
    
      public static  String dechiffrement(String text,String key){
       
  ArrayList<String> in = splitEqually(text,key.length());
    StringBuilder result = new StringBuilder();
    for(String s:in){
      
            for(int i=0;i<s.length();i++){
                 char xoredChar = (char) (s.charAt(i) ^ key.charAt(i));
            result.append(xoredChar);
            }
    }

        return result.toString();
        
    }
    public static void main(String args[]) {
      String text="hello 123";
      String key="ex";
    String enc=  chiffrement(text,key);
    System.out.println("enc"+enc);
     String dec=  dechiffrement(enc,key);
      System.out.println("dec "+dec);
    }
}
