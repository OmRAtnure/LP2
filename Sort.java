public class Sort {
    static void selectionSort(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++) {
            int minIndex=i;
            for(int j=i+1;j<n;j++) {
                if(arr[j]<arr[minIndex]) {
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;

        }
    }


public static void printArray(int[] arr) {
    int n=arr.length;
    for(int i=0;i<n;i++) {
        System.out.print(arr[i] + " ");
    }
    System.out.println();
}
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Unsorted array:");
        printArray(arr);
        selectionSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}