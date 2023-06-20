import java.util.Date;

public class prescriptions {
 
    int P_ID;
    Date date;
    Medication P_Medication ;
    

    public prescriptions ( int P_id,Medication P_Medication ){

        this.P_ID=P_id;
        this.P_Medication= P_Medication;
        this.date = new Date();
        
    }

   
   public void print () {
       System.out.println(" \n The medcation is");
        System.out.println (P_Medication);
       System.out.println( "\nThe date is : " + date);
       
   }

}
