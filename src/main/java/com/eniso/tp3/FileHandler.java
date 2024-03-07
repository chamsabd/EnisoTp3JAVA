/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.tp3;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author chams
 */
public class FileHandler {
    private String filePath;
    private Integer fileSizeInKb;
    private Integer numberOfLines;
    private ArrayList<String> fileContent;
   
public FileHandler(String ilePath){
    File f1=new File(ilePath);
   if(f1.exists()){
       
   this.filePath= ilePath;
  this.readFile(f1);
   }
   else{
       System.out.println("file not found");
   }

}

public ArrayList<String> findLinesWithPattern(String pattern){
    ArrayList<String> liste=new ArrayList<String>();
    for(String line :this.fileContent){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(line);
if (matcher.find()) {
    liste.add(line);
}
    }
    
    return liste;
    
}
 public boolean compareString1(String str1,String str2){
  
     return str1.equals(str2);
 }
 public int compareString2(String str1,String str2){
  
     return str1.compareToIgnoreCase(str2);
 }
 public boolean compareString3(String str1,String str2){
  
     return str1==str2;
 }
public void reverseString(int lineIndex){
    
  String l=  this.fileContent.get(lineIndex);
 StringBuilder input1 = new StringBuilder();
 
        
        input1.append(l);
 
        input1.reverse();
        
       this.fileContent.set(lineIndex, input1.toString()) ;
        Path pa = Paths.get(this.filePath); 
        try {
      Files.write(pa,this.fileContent,StandardCharsets.UTF_8);
      } catch (IOException e) {
            e.printStackTrace();
        }
}
public void removeDuplicates(int lineIndex){
   
String l = this.fileContent.get(lineIndex).toLowerCase();
StringBuilder sb1 = new StringBuilder(l);
StringBuilder sb2 = new StringBuilder();
for(int i=0;i<sb1.length();i++){
    if(sb2.indexOf(""+sb1.charAt(i))==-1 ){
        sb2.append(sb1.charAt(i));

    }
    else{
        sb1.replace(i, i+1, " ");
    }
        
}

 this.fileContent.set(lineIndex, sb1.toString()) ;
        Path pa = Paths.get(this.filePath); 
        try {
      Files.write(pa,this.fileContent,StandardCharsets.UTF_8);
      } catch (IOException e) {
            e.printStackTrace();
        }
    
    
    
}
private void readFile(File f1){
  this.fileContent=new ArrayList<>();
     try { 
         this.fileSizeInKb=(int) f1.length()/1024;
         this.numberOfLines=0;
    
       Scanner r = new Scanner(f1);
        
        String scan;
        while(r.hasNextLine()) {
            scan = r.nextLine();
           
             this.numberOfLines++;
                this.fileContent.add(scan);
        }
       
         } catch (FileNotFoundException ex) {
        Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, "File Not Found", ex);
    }
       

}

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getFileSizeInKb() {
        return fileSizeInKb;
    }

    public void setFileSizeInKb(Integer fileSizeInKb) {
        this.fileSizeInKb = fileSizeInKb;
    }

    public Integer getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(Integer numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public ArrayList<String> getFileContent() {
        return fileContent;
    }

    public void setFileContent(ArrayList<String> fileContent) {
        this.fileContent = fileContent;
    }
    
}
