/*
 *  
Java18-OOJ
 */
package uppgift2new;

import java.time.Duration;
import java.time.LocalDate;

public class Medlem {
   static boolean member = false;
   static String medlemNamn;
   static String medlemNum;
   
   public static long Caculateduration(Kund k){
       
        LocalDate betal= LocalDate.parse(k.getBetaldatum());
        LocalDate nu= LocalDate.now();
        return Duration.between(betal.atStartOfDay(),nu.atStartOfDay()).toDays();
   } 
   
   public static String omMedlem(Kund k){
       
        long duration=Caculateduration(k);
        if(duration<=365){
            member=true;
            medlemNamn=k.getNamn();
            medlemNum=k.getPersonnummer();
            return "Nuvarande medlem.";
        }
        else 
            return "En förre medlem.";
        
   }
}
