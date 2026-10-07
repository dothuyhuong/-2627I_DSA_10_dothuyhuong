import java.util.Scanner;

public class bai5_venha {

    // Chèn phần tử tại vị trí idx vào đoạn đã sắp xếp [0 .. idx-1]
    static void insertIntoSorted(int[] arr, int idx) {
        int value = arr[idx];
        int i = idx - 1;

        while (i >= 0 && arr[i] > value) {
            arr[i + 1] = arr[i];     // dịch sang phải
            i--;
        }
        arr[i + 1] = value;
    }

    static void insertionSortPart2(int[] ar) {
        for (int idx = 1; idx < ar.length; idx++) {
            insertIntoSorted(ar, idx);
            printArray(ar);          // in sau mỗi lần chèn xong
        }
    }

    // ===== Phần có sẵn =====
    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
    }
}
