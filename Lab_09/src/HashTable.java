public class HashTable {
    private words table[];
    
    public HashTable(int N) {
		table = new words[N];
		for (int i = 0; i < table.length; i++)
			table[i] = new words (" ",0);
	}

    public static int hash(char key) {
    
      return ((int)key) - 97;
      
	} 

    public void put(words w) {
        int ind =hash( w.getWord().charAt(0));

        if (table[ind].getFrequency() == 0){
            table[ind] = w;
            return ;
        }
        while (ind < table.length && table[ind].getFrequency() != 0){
          ind++;
        }

        table[ind]=w;
       
    }


    public words get (String w){

      int index =hash(w.charAt(0));
      
      
              if (table[index].getWord().equals(w)){
                  return table[index] ;
              }
              
              while (index < table.length && !table[index].getWord().equals(w)){
      
                index++;
      
              }
            if (index==table.length){
              return null;
            }
             return table[index] ;
      
        }

    public words remove(String e) {
        
      int ind = hash(e.charAt(0));
      
      if (table[ind].getWord().equals(e)){
        words word =table[ind];
        table[ind]=new words (" ",0);
        return word;
      }
    

        while (ind < table.length && !table[ind].getWord().equals(e)){  ++ind;  }

        if (ind < table.length && table[ind].getWord().equals(e)){
          words word = table[ind];
        table[ind]=new words (" ",0);
        return word; 
        }
        else {   return null;   }

      }



    public void print() {
        for (int i = 0; i < table.length; i++) {
                if (table[i].getFrequency()!=0){
          System.out.println("num is " + i +" the word is " + table[i].getWord());}
        }
    }

   
    
   
    
    
}
