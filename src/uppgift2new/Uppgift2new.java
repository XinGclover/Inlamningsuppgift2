/*
 *  
Java18-OOJ
 */

package uppgift2new;

import java.io.File;
import java.time.Period;
import javax.swing.JOptionPane;


public class Uppgift2new {

  
    public static void main(String[] args) {
       
        checkMedlem();
        punchCard();     
    }
    
    public static void checkMedlem(){
        
        File readout= new File("src/customers.txt"); 
        String input;
        Gym bGE= new Gym();
        bGE.getKundlist(readout);
        
        Object[] options = {"Avbryt","Personnummer","Namn",};
        int response=JOptionPane.showOptionDialog ( null, "Vilket sätt ska du välja för att söka? ",
                     "Sök Kund System ",JOptionPane.YES_OPTION ,JOptionPane.PLAIN_MESSAGE,
                     null, options, options[0] ) ;

        switch (response) { //Avbryt
            case 0:
                System.exit(0);
        
            case 1:         //Söka kund genom personnummer
                input=JOptionPane.showInputDialog("Anger Personnummer.");
                if(input==null)
                    System.exit(0);
                else
                    printInfo(bGE.sokKundsnum(input));
                break;
                
            case 2:         //genome namn
                input=JOptionPane.showInputDialog("Anger Namn.");
                if(input==null)
                    System.exit(0);
                else
                    printInfo(bGE.sokKundsnamn(input));
                break;
                
            default:
                break;
            }
        }
        
    public static void punchCard(){
        
        int knapp;
        File writein= new File("src/trainingrecord.txt");
        
        if(Medlem.member==true){
          knapp=JOptionPane.showConfirmDialog(null, "Vill du träna idag?");
          
           switch (knapp) {
               case 0:  //ja
                   JOptionPane.showMessageDialog(null,"Välkommer.");
                   Gym.writeRecord(writein); //Skriva medlems information till ny fil
                   break;
                   
               case 1:   //nej
                   JOptionPane.showMessageDialog(null,"Hejdå.");
                   break;
                   
               case 2:   //avbryt
                   break;
                   
               default:
                   break;
                 }
             }
       else
           System.exit(0); 
        
    }

     public static void printInfo(Kund d){
      
        String medleminfo;
       
        if(d==null){
           JOptionPane.showMessageDialog(null,"Aldrig har varit medlem och är obehörig.");
        }
        else{
           medleminfo=Medlem.omMedlem(d);
           JOptionPane.showMessageDialog(null,"Avgiften betalas "+ d.getBetaldatum()
                                         +"\n"+medleminfo);
        }         
    }
}
