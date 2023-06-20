import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Book_Viewer {

    String bookname;
 static int pagenum=1;
 
    static LinkedStack <String > mybook = new LinkedStack <String> ();
    static LinkedStack <String > temp = new LinkedStack <String> ();

    static Scanner input ;

   public  Book_Viewer(String Bookname){
    this.bookname =Bookname;
    try{
    readAllBytes();
        System.out.println(mybook.top());
   }
    catch(Exception e){System.out.println(" ERRORR IN FILE");}
  
     
   }
    public void readAllBytes ()throws Exception {
        

    for (int i=4; i>=1 ; i--){

        String num = Integer.toString(i) ;
        String file_name = "page_" + num +".txt";
         
        

    String page = new String(Files.readAllBytes(Paths.get(file_name)));
        mybook.push(page);
        
    }
    }

  
  
  public static void next(){
 if(pagenum<4)
 {
      temp.push(mybook.pop());
      System.out.println(mybook.top());
    pagenum++; 
 }
 else
 
if(pagenum==4)
{ System.out.println("you are in Last page...");
    System.out.println(mybook.top());
} 
 
  } 
  
  public static void previous(){
       if(pagenum>1)
       {
        mybook.push(temp.pop());
      System.out.println(mybook.top());
   pagenum--;
       
       }
       else
           
     
         
      if(pagenum==1){
          System.out.println("you are in first page... "); 
          System.out.println(mybook.top());
     
      }
     
      
      

  }

    public static void GoToPage(int n){
pagenum=1;
        String p;

  while(!temp.isEmpty())
      mybook.push(temp.pop());
  
  if(n==1)
  {System.out.println(mybook.top());
  return;
  }
  
for(int i=1;i<n;i++){
    temp.push(mybook.pop());
        pagenum++;
}
System.out.println(mybook.top());
  
    }

    public static void main(String[] args) {
      Book_Viewer book = new Book_Viewer ("How To Program");
        int select;
        Scanner input2= new Scanner (System.in);
      

     

        do {
            System.out.println("\n");
            System.out.println("Would you like to:");
            
            System.out.println("1- Go to the the next page ");
            System.out.println("2- Go to the previous page");
            System.out.println("3- Search by number ");
            System.out.println("4-  Exit.");
            System.out.print("Enter the number of your selection:  ");
            select = input2.nextInt();

            switch (select) {
                

                case 1:
                    
                   next();
                   
                    break;

                case 2:
                previous();
                    break;
                
                case 3:
                System.out.print("Enter the page  you want to read   ");
                 int pagenumber  = input2.nextInt();
                 GoToPage(pagenumber);
                    break;

                case 4:
                    System.out.println("Thank you , See you soon.");
                    break;

            }
        } while (select != 4);
         


    }
    
}
