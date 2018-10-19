/*
 *  
Java18-OOJ
 */
package uppgift2new;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Gym {
    List<Kund> kundlist= new LinkedList<>();
   
    public void getKundlist(File f) {
        String firstline;
        String secondline;     
        String [] kundFirstline;
        
        try(Scanner filscan= new Scanner(f)){
            while(filscan.hasNext()){
               firstline=filscan.nextLine();
               kundFirstline = SplitKomma(firstline);
               secondline=filscan.nextLine(); 
               Kund k = new Kund(kundFirstline[0].trim(),kundFirstline[1].trim(),secondline.trim());
               kundlist.add(k);         
            }
            
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
     
    }
        
       public static String[] SplitKomma(String s){
           return s.split(",");
       }
    
       public Kund sokKundsnum(String personnummer){
        for(Kund k:kundlist)
            if(personnummer.equalsIgnoreCase(k.getPersonnummer()))
            return k;
        return null;
    }
       
       public Kund sokKundsnamn(String namn){
        for(Kund k:kundlist)
            if(namn.equalsIgnoreCase(k.getNamn()))
            return k;
        return null;
    }
    
    public static void writeRecord (File f){   
      try (PrintWriter p= new PrintWriter(new BufferedWriter
                         (new FileWriter(f,true)))){
          String info=Medlem.medlemNamn+"\t"+Medlem.medlemNum+"\t"+LocalDateTime.now();
          p.print(info+"\n");
          p.close();
     }
     
      catch(Exception e){
          e.printStackTrace();
      }
   }  
  }

