/*
 *  
Java18-OOJ
 */
package uppgift2new;

import java.io.File;
import junit.framework.TestCase;
import org.junit.Test;

 
public class GymTest {
       Gym g= new Gym();
       Kund k1=new Kund("7603021234","Alhambra Aromes","2017-07-01");
       Kund k2=new Kund("8104021234","Bear Belle","2017-12-02");
       Kund k3=new Kund("8512021234", "Chamade Coriola", "2016-03-12");
       Kund k4=new Kund("7608021234", "Diamanda Djedi","2018-01-30");
      
       
   @Test
   public void testSplit(){
       String s1="7603021234,Alhambra Aromes";
       String s2="7603021234,Alhambra,Aromes";
       String s3="7603021234 Alhambra Aromes";
          
       String[]s1expect= {"7603021234","Alhambra Aromes"};
       String[]s2expect= {"7603021234","Alhambra","Aromes"};
       String[]s3expect= {"7603021234 Alhambra Aromes"};
   
       
       String[]s1array= Gym.SplitKomma(s1);
       String[]s2array= Gym.SplitKomma(s2);
       String[]s3array= Gym.SplitKomma(s3);

       TestCase.assertTrue(s1expect[0].equals(s1array[0]));
       TestCase.assertFalse(s1expect[1].equals(s2array[1]));
       TestCase.assertTrue(s3expect[0].equals(s3array[0])); 
       TestCase.assertTrue(s2expect[1].equals(s2array[1]));

   }
   
   @Test
   public void testgetKundList(){
       File f=new File("src/customers.txt");
       g.getKundlist(f);
       
       Kund p1=g.kundlist.get(0);
       Kund p2=g.kundlist.get(1);
       Kund p3=g.kundlist.get(2);
       Kund p4=g.kundlist.get(3);
       
  
       TestCase.assertEquals(k1.getNamn(), p1.getNamn());
       TestCase.assertEquals(k2.getNamn(), p2.getNamn());
       TestCase.assertEquals(k3.getPersonnummer(), p3.getPersonnummer());
       TestCase.assertEquals(k4.getBetaldatum(), p4.getBetaldatum());  
   }
   
   
   @Test
   public void testsokKundsnum(){
       g.kundlist.add(k1);
       g.kundlist.add(k2);
       g.kundlist.add(k3);
       g.kundlist.add(k4);
       
       String p1num= "7603021234";
       String p2num= "8104021234";
       String p3num= "ijie322";
       String p4num= "7608021234";
         
       Kund p1expect=k1;
       Kund p2expect=k2;
       Kund p3expect=null;
       Kund p4expect=k4;  
       
       Kund p1= g.sokKundsnum(p1num);
       Kund p2= g.sokKundsnum(p2num);
       Kund p3= g.sokKundsnum(p3num);
          
       TestCase.assertEquals(p1expect,p1);
       TestCase.assertEquals(p2expect,p2);
       TestCase.assertEquals(p3expect,p3);   

   }
  
}
