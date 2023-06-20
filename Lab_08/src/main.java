import java.util.Scanner;
import java.nio.file.Paths;

public class main {
    public static void main (String [] args)throws Exception {

        BST <Integer, Student>Students = new BST();

        Scanner input= new Scanner (Paths.get("students.txt"));

        while (input.hasNextLine()){

            Student s1 = new Student(input.nextInt(), input.next(), input.nextFloat());

            Students.insert(s1.getID(), s1);
        }

        System.out.println ("Root before the remove : \n" + Students.Getroot().getData());
        System.out.println();
        Students.Inorder(Students.Getroot());

        Students.remove(118);

        System.out.println ("\n: ");

        System.out.println ("\nRoot after the remove : \n " +Students.Getroot().getData());

        System.out.println();

        Students.Inorder(Students.Getroot());



        BST<Integer, Integer> tree = new BST();
        tree.insert(7, 3);
        tree.insert(2, 1);
        tree.insert(8, 1);
        tree.insert(7, 7);

        System.out.println("\n\nDoes it found the value? "+tree.contains(3));
        System.out.println("\nNodes leaf count: "+tree.GetleafCount()+"\n");



        BST<Integer,Student> studtree =new BST();
        studtree.insert(8, new Student(5,"Nora",88));
        studtree.insert(1, new Student(3,"Hamad",79));
        studtree.insert(18, new Student(8,"Sarah",99));


    }
}

