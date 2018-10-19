/*
 *  
Java18-OOJ
 */
package uppgift2new;


public class Kund {
   private String namn;
    private String personnummer;
    private String betaldatum;
      
    public Kund(String personnummer,String namn,String betaldatum){
        this.namn= namn;
        this.personnummer=personnummer;
        this.betaldatum=betaldatum;
    }

    Kund() {
        
    }
    
    public String getNamn(){
        return namn;
    }
    
    public String getPersonnummer(){
        return personnummer;
    }
    
    public String getBetaldatum(){
        return betaldatum;
    }
    
   @Override
    public String toString(){
        return personnummer+","+namn+","+betaldatum;
    } 
}
