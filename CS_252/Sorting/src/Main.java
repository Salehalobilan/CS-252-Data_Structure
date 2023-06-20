public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static void bubbleSort(int a[]) {
        for (int i = 0; i< a.length - 1; i++) {
            for (int j = 1; j < a.length - i; j++) {
                //swap adjacent out-of-order elements
                if (a[j - 1] > a[j]) {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }

            }
        }
    }

    public static void insertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            //slide element down to make room for a[i]
            int j = i;
            while (j > 0 && a[j-1] > temp){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }

    public static void selectionSort(int a[]) {
        for (int i = 0; i< a.length; i++) {
            //find index of smallest element
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[j] < a[minIndex])
                    minIndex = j;
            }
        int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;

        }
    }
}