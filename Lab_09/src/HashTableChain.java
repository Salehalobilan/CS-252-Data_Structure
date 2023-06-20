import java.util.ArrayList;

public class HashTableChain {
	private ArrayList<words>[] table = new ArrayList[26];

	public HashTableChain(){
		for (int i = 0; i< table.length ; i++){
       table[i]= new ArrayList();
		}
	}


	public static int hash(char key) {
		
		return ((int)key)-97;
	} 


	public void put(words w) {
	  int index =hash (w.getWord().charAt(0));

	 table[index].add(w);
			
		
	}
	
	public words get(String w) {
        
		int index = hash(w.charAt(0));
		
			  for (int i = 0; i< table[index].size(); i++){
			
                if (table[index].get(i).getWord().equals(w))
					return table[index].get(i);
			  }
			return null;
			}


public words remove(String Char) {
        
		int index = hash(Char.charAt(0));
			  
			  for (int i = 0 ; i< table[index].size() ; i++){
                if (table[index].get(i).getWord().equals(Char)) {
					words exist = table[index].get(i);
					table[index].remove(i);
					return exist;
				}
			  }
			return null;
	    }
	


	public void print() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0 ; j < table[i].size() ; j++){
			System.out.println(" num is: "+ i + " the word is"+ table[i].get(j).getWord());}
		}
	}



}
