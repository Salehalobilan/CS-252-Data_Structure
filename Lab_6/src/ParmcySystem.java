import java.nio.file.Paths;
import java.util.Scanner;

public class ParmcySystem {

    static SinglyLinkedList<patient> p = new SinglyLinkedList<patient>();
    static LinkedQueue<prescriptions> PharmcyQueue = new LinkedQueue<prescriptions>();
    public static Scanner input;

    public ParmcySystem() throws Exception {

        input = new Scanner(Paths.get("Patient.txt"));
        while (input.hasNextLine()) {

            p.addLast(new patient(input.nextInt(), input.nextInt(), input.next()));
        }

    }

    public patient Search_Patient(int id) {
        p.moveToStart();
        for (int i = 0; i < p.size(); i++) {
            if (p.getValue().getId() == id) {
                return p.getValue();
            } else {
                p.next();
            }
        }

        return null;
    }

    public void PrintPatients() {
        p.moveToStart();
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.getValue());
            p.next();
        }
    }

    
    public static void main(String[] args) throws Exception {

        ParmcySystem myPharmcy = new ParmcySystem();
       
        int select;
        input = new Scanner(System.in);

        do {
            System.out.println("\n_________________________");
            System.out.println("1- print patiens data");
            System.out.println("2- Doctor System ");
            System.out.println("3- pharmacist System");
            System.out.println("4- Exit");
            System.out.println("_________________________");
            System.out.print("Enter your choice");
            select = input.nextInt();
            switch (select) {
                case 1:
                    myPharmcy.PrintPatients();
                    break;
                case 2:
                    System.out.println("Please enter the patient Id ");
                    int id = input.nextInt();
                    patient p = myPharmcy.Search_Patient(id);
                    if (p == null) {
                        System.out.print("invalid Id");
                        break;
                    } else {
                        System.out.println("id is found And the patient data is :" + p.toString());
                        System.out.println("Please enter a medicine name ");
                        String name = input.next();
                        System.out.println("Please enter a medicine dose: ");
                        String dose = input.next();
                        System.out.println("Please enter a medicine amount: ");
                        int amount = input.nextInt();
                        System.out.println("Please enter a medicine directions: ");
                        String directions = input.next();

                        Medication m = new Medication(name, dose, amount, directions);
                        prescriptions presc = new prescriptions(id, m);
                        PharmcyQueue.enqueue(presc);
                        System.out.println("prescriptions has been added to the queue!");
                    }

                    break;

                case 3:

                    System.out.printf("Hello,  there are %d unprepared prescriptions %n", PharmcyQueue.size());
                    if (PharmcyQueue.size() != 0) {
                        System.out.println("The first prescriptions is \n");
                        PharmcyQueue.first().print();
                        System.out.println("Once it is done please enter \"Done\" \n");
                        if (input.next().equals("Done")) {
                            PharmcyQueue.dequeue();
                        }
                    }

                    break;
            }
        } while (select != 4);

    }

}
