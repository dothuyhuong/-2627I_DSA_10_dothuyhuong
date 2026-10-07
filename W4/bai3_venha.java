import java.util.Scanner;

public class bai3_venha {

    // Chèn phần tử cuối mảng vào đúng vị trí trong phần đã sắp xếp
    static void insertIntoSorted(int[] arr) {
        int n = arr.length;
        int value = arr[n - 1];      // phần tử cần chèn
        int i = n - 2;

        // Dịch các phần tử lớn hơn value sang phải 1 vị trí
        while (i >= 0 && arr[i] > value) {
            arr[i + 1] = arr[i];
            printArray(arr);         // in trạng thái sau mỗi lần dịch
            i--;
        }

        arr[i + 1] = value;          // đặt value vào đúng vị trí
        printArray(arr);             // in trạng thái cuối cùng
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
        insertIntoSorted(ar);
    }
}
