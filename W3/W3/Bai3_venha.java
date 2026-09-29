package W3;

import java.util.Scanner;
import java.util.Stack;

public class Bai3_venha {

    // Lớp Queue tự cài đặt bằng 2 Stacks
    static class MyQueue<T> {
        private Stack<T> stackEnqueue = new Stack<>();
        private Stack<T> stackDequeue = new Stack<>();

        // 1. Thêm phần tử vào cuối queue
        public void enqueue(T item) {
            stackEnqueue.push(item);
        }

        // Chuyển toàn bộ dữ liệu từ stackEnqueue sang stackDequeue khi stackDequeue rỗng
        private void shiftStacks() {
            if (stackDequeue.isEmpty()) {
                while (!stackEnqueue.isEmpty()) {
                    stackDequeue.push(stackEnqueue.pop());
                }
            }
        }

        // 2. Xóa và trả về phần tử ở đầu queue
        public T dequeue() {
            shiftStacks();
            return stackDequeue.pop();
        }

        // 3. Trả về phần tử ở đầu queue mà không xóa
        public T peek() {
            shiftStacks();
            return stackDequeue.peek();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int q = scanner.nextInt();
            MyQueue<Integer> queue = new MyQueue<>();

            for (int i = 0; i < q; i++) {
                int type = scanner.nextInt();
                if (type == 1) {
                    int x = scanner.nextInt();
                    queue.enqueue(x); // Thao tác enqueue
                } else if (type == 2) {
                    queue.dequeue(); // Thao tác dequeue
                } else if (type == 3) {
                    System.out.println(queue.peek()); // In phần tử đầu queue
                }
            }
        }
        scanner.close();
    }
}
