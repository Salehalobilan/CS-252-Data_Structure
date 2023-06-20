public class Searching {
    public static void main(String[] args) {
        // int array[] = { 10, 4, 55, 3, 45, 66, 24, 56 };
        // System.out.println("Search for 1 in index " + searchArray(array, 1));
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(56);
        list.addFirst(124);
        list.addFirst(660);
        list.addFirst(4500);
        list.addFirst(30000);
        list.addFirst(55000);
        list.addFirst(400000);
        list.addFirst(1000000);

        // System.out.println("Search for " + list.binarySearch(4500));

        int sortedArray[] = { 10, 14, 55, 301, 450, 660, 2400, 5600 };
        int target = 450;
        System.out.println(
                "Search for " + target + " found " + binarySearch(sortedArray, target));

    }

    public static boolean shortBinarySearch(int data[] ,int target) {
        int low = 0;
        int high = data.length -1;

        if (low > high)
            return false; // interval empty; no match
        else {
            //cutting time
            while(low <= high) {
                int mid = (low+ high) / 2;
                if (target == data[mid])
                    return true; //this is the best result we want
                else if (target < data[mid])
                    high = mid - 1;
                else //if (target > data[mid])
                    low = mid + 1;
            }
            return false;
        }
    }

    public static boolean binarySearch(int data[] ,int target, int low, int high) {
//        int low = 0;
//        int high = data.length -1;

        if (low > high)
            return false; // interval empty; no match
        else {
            int mid = (low + high) / 2;
            System.out.println("Mid " + mid);
            if (target == data[mid])
                return true; // found a match
            else if (target < data[mid])
                return binarySearch(data, target, low, (mid - 1)); // recur left of the
            //middle
            else
                return binarySearch(data, target, mid + 1, high); // recur right of the
            //middle
                      }
    }


}