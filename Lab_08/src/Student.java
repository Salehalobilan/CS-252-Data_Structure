

public class Student {
   int ID;
   String name;
   double exam_mark;

   public Student(int iD, String name, double exam_mark) {
    ID = iD;
    this.name = name;
    this.exam_mark = exam_mark;
}
   public int getID() {
       return ID;
   }

   public void setID(int iD) {
       ID = iD;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public double getExam_mark() {
       return exam_mark;
   }

   public void setExam_mark(double exam_mark) {
       this.exam_mark = exam_mark;
   }

   public String toString(){

    return String.format ("Name : %s , ID : %d ,  Mark %f ", name,ID, exam_mark);
   }
   
   

    
}
