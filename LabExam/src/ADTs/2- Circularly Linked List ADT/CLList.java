/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class CLList<T> {
private Node<T> head;       // Reference to first element
private Node<T> last;            // Reference to last element
private int size; // Size of list
/** Constructors */
CLList() {
last = head = null;
size = 0;
}

/** Remove all elements */
public void clear() {
last = head = null;
size = 0;
}

public int length()
{
    return size;
}

/** add "element" to the end of list */
public void add(T data) {
Node<T> temp = new Node<>(data, null);
if(head == null){
head = last = temp.next = temp;
}
else {
last.next = temp;
last = temp;
temp.next = head;
}
size++;
}


/** add "element" at specific position */
public void add(T data, int index) {
if (index > size || index < 0) {
System.out.println("Index out of bounds");
return;
}
Node<T> temp = new Node<>(data, null);
if(index == 0){  // Add at the front or empty list
if(head == null)
last = head = temp.next = temp;
else  {
temp.next = head;
head = temp;
last.next =head;
}
}
else { // Add at the middle 
Node<T> curr = head;
for(int i = 0; i < index-1; i++)
curr = curr.next;
temp.next = curr.next;
curr.next = temp;
if (last == curr) {  // Add at the end 
last = last.next;
last.next = head;
}
}
size++;
}

/** Remove and return the removed data */
public T remove(int index) {
if (index >= size || index < 0) {
System.out.println("Index out of bounds");
return null;
}
T data;
if(index == 0){ // remove front element 
data = head.data;
if (head.next == head)
head = last = head.next = null;
else
head = head.next;
last.next = head;
} 
else {
Node<T> curr = head;
for(int i = 0; i < index-1; i++)
curr = curr.next;

data = curr.next.data;
if (last == curr.next) // remove last element 
last = curr;
curr.next = curr.next.next; // Remove from list
}

size--; // Decrement count
return data;  // Return value
}

 public T get(int index) {
        Node<T> curr = head;
        if (index < 0 || index >= size) {
            System.out.println("Index out of range!");
            return null;
        } else {

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

        }
        return curr.data;
    }

    public void set(T data, int index) {
        Node<T> curr = head;
        if (index < 0 || index >= size) {
            System.out.println("Index out of range!");
        } else {

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr.data = data;
        }
    }

    public void print()
    {
        Node<T> curr = head;
          for (int i = 0; i < 10; i++) {
              System.out.println(curr.data);
                curr = curr.next;
            }
        
    }

}
