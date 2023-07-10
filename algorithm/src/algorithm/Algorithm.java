package algorithm;

public class Algorithm {

    public static void main(String[] args) {
        int linesize = 13; 
        String str = "      *      ";
        String space = "";
        for (int i = 0 ; i < linesize ; i ++){
            for (int j= 0 ; j < linesize ;j++ ){
              
            }
        }
    }

    public static int why(int num) {
        if (num < 0) {
            return 0;
        }
        return num + why(num - 1);

    }

    // this is the archive
    /*

         for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int largest = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[largest] < arr[j]) {
                    largest = j;
                }
            }
            swap(arr,i,largest);
    for (int i = 1; i < arr.length; i++) {
            int ele = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > ele; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j]=ele;
        }
        }*/
    public static int binarySearch(int[] arr, int value) {
        return binarySearch(arr, 0, arr.length, value);
    }

    public static int binarySearch(int[] arr, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] > value) {
            return binarySearch(arr, start, mid, value);
        } else {
            return binarySearch(arr, mid + 1, end, value);
        }

    }

    public static void linearSearch(int[] arr, int value) {
        boolean a = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                a = true;
                System.out.println("the node " + value + " is found at position: " + i);
                break;
            }
        }
        if (!a) {
            System.out.println("the node is not found");
        }
    }

    // bubble sort
    public static void bubble(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    // selection sort

    public static void selection(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int largest = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[largest]) {
                    largest = j;
                }
            }
            swap(arr, i, largest);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    // insertion sort
    public static void insertion(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int newEle = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > newEle; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = newEle;

        }
    }

    // merge sort #####################################
    // calling the method
    // splitting phase
    public static void merge(int arr[]) {
        int arrSize = arr.length;
        if (arrSize < 2) {
            return;
        }
        int mid = arrSize / 2;
        int[] left = new int[mid];
        int[] right = new int[arrSize - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        merge(left);
        merge(right);
        merge(arr, right, left);
    }

    // sorting phase
    public static void merge(int[] arr, int[] right, int[] left) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    // merge sort #####################################
    // quick sort #####################################
    // calling the main quick method
    public static void quick(int arr[]) {
        quick(arr, 0, arr.length);
    }

    // main quick sort method
    public static void quick(int arr[], int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivitIndex = partition(arr, start, end);
        quick(arr, start, pivitIndex);
        quick(arr, pivitIndex + 1, end);
    }
    // getting the right pos of the pivit

    public static int partition(int arr[], int start, int end) {
        // this method uses the first index as the pivit
        int pivit = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            // empty body loop just to get the element that less than the pivit
            while (i < j && arr[--j] >= pivit);
            if (i < j) {
                arr[i] = arr[j];
            }

            // empty body loop just to get the element that greater than the pivit
            while (i < j && arr[++i] <= pivit);
            if (i < j) {
                arr[j] = arr[i];
            }

        }
        arr[j] = pivit;
        return j;
    }
    // quick sort #####################################

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
