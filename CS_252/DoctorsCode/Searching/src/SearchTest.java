public class SearchTest {

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

    public static int searchArray(int[] array, int key) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == key)
                return i;

        return -1;
    }

    public static int searchLinkedList(singlyLinkedList<Integer> ll, Integer key) {
        // for (int i = 0; i < array.length; i++)
        // if (array[i] == key)
        // return i;

        ll.moveToStart();

        for (int i = 0; i < ll.size(); i++) {
            if (ll.getValue() == key)
                return ll.currPos();
            ll.next();
        }
        /*
         * if (ll.getValue() == key)
         * return ll.currPos();
         * while (ll.)
         */

        return -1;
    }

    /**
     * Returns true if the target value is found in the indicated portion of the
     * data array.
     * This search only considers the array portion from data[low] to data[high]
     * inclusive.
     */
    public static boolean binarySearch(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;

        /*
         * if (low > high)
         * return false; // interval empty; no match
         * else {
         *
         * int mid = (low + high) / 2;
         * System.out.println("Mid " + mid);
         * if (target == data[mid])
         * return true; // found a match
         * else if (target < data[mid])
         * return binarySearch(data, target, low, (mid - 1)); // recur left of the
         * middle
         * else
         * return binarySearch(data, target, mid + 1, high); // recur right of the
         * middle
         * }
         */
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return true;
            if (target < data[mid]) {
                high = (mid - 1);
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

}