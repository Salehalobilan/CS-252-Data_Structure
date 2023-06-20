import java.awt.*;
import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main (String [] args)throws Exception {

        Scanner input = new Scanner (System.in);
         int k; 
        String filename = "wordcount.txt";
    
       System.out.println("Enter the number for resolving collision: ");
       System.out.println(" 1- Separate Chaining.");
       System.out.println(" 2- Linear probing.");
       int choice = input.nextInt();

       input = new Scanner (Paths.get(filename));


      switch (choice){
          default: System.out.println("Invalid input"); break;
          case 1 :
              {
                  HashTableChain  hashtable  = new HashTableChain();
                  while (input.hasNext()){

                      String currentword = input.next().toLowerCase();

                      words word= hashtable.get(currentword);

                      if (word==null){
                          word = new words (currentword,1);
                          hashtable.put(word);}
                      else {
                          hashtable.remove(word.getWord());

                          word.setFrequency(word.getFrequency()+1);
                          hashtable.put(word);}

                  }
                  hashtable.print();
              }


          case 2 :
          {
              HashTable  hashtable2  = new HashTable(500);

              while (input.hasNext()){

                  String currentword = input.next().toLowerCase();


                  words word= hashtable2.get(currentword);

                  if (word==null){

                      word = new words (currentword,1);
                      hashtable2.put(word);}
                  else {

                      word =hashtable2.remove(word.getWord());

                      word.setFrequency(word.getFrequency()+1);

                      hashtable2.put(word);}
              }
              hashtable2.print();
          }

      }






    }

}

   

