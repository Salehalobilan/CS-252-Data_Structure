/* Student Name: saleh wleed alobaylan
 * ID: 443014070
 * Section:  072
 */
package ADTs;

import java.util.Scanner;

public class PatientSystem {

    static LinkedQueue <patient> list = new LinkedQueue<>();

    public static void AddPatient (patient d){

        if(list.isEmpty())
        { list.enqueue(d);
            System.out.println("Patient added sucessfully");

        }

        else{

            LinkedQueue <patient> list2 = new LinkedQueue<>();

            boolean found = false;
            while (!list.isEmpty()){
                patient dd = list.dequeue();
                if(dd.getId() == d.getId())
                    found=true;
                list2.enqueue(dd);
            }
            while(!list2.isEmpty())
                list.enqueue(list2.dequeue());
            if(found == false){
                list.enqueue(d);
                System.out.println("Patient added sucessfully");
            }else
                System.out.println("Patient is already in list");
        }
    }
    public static void CallPatient(){
        if(list.isEmpty())
            System.out.print("List is empty");
        else
        {
            System.out.println("first patient is " + list.dequeue());



            }

    public static void main(String[] args) throws Exception {

        PatientSystem pa = new PatientSystem();
        int choice;
        Scanner input = new Scanner(System.in);
        patient p;

        do {

            System.out.println("\nPlease enter your choice:");
            System.out.println("1- call the first patient");
            System.out.println("2- add a new patient");
            System.out.println("3- Exit");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    CallPatient();
                    break;

                case 2:
                    System.out.println("enter Patient id  name");
                    AddPatient(new patient(input.nextInt(),input.next()));
                    break;

                break;
            }

        } while (choice != 3);
    }
}
