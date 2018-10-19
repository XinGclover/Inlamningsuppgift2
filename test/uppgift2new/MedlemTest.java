/*
 *  
Java18-OOJ
 */
package uppgift2new;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author xingao
 */
public class MedlemTest {
    
    Kund k1=new Kund("7603021234","Alhambra Aromes","2017-07-01");
    Kund k2=new Kund("8104021234","Bear Belle","2017-12-02");
    Kund k3=new Kund("8512021234", "Chamade Coriola", "2016-03-12");
    Kund k4=new Kund("7608021234", "Diamanda Djedi","2018-01-30");
    
    @Test
    public void testCaculateduration(){ 
        
       long duration1= Medlem.Caculateduration(k1);
       long duration2= Medlem.Caculateduration(k2);
       long duration3= Medlem.Caculateduration(k3);
       
       TestCase.assertTrue(duration1==475);
       TestCase.assertTrue(duration2==321);
       TestCase.assertFalse(duration3==6);
       
    }
    
    @Test
    public void testomMedlem(){
        String s1= Medlem.omMedlem(k1);
        String s2= Medlem.omMedlem(k2);
        String s3= Medlem.omMedlem(k3);
        
        String messageNu="Nuvarande medlem.";
        String messageForre="En förre medlem.";
       
        TestCase.assertTrue(s1.equals(messageForre));
        TestCase.assertTrue(s2.equals(messageNu));
        TestCase.assertFalse(s1.equals(messageNu));
    
    }
}
