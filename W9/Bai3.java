import java.util.Scanner;

// Bài 3: Chèn một đỉnh vào cây tìm kiếm nhị phân (BST)
//
// Input:
//   Dòng 1: n (số đỉnh của cây ban đầu)
//   Dòng 2: n giá trị của cây ban đầu (chèn lần lượt từ trái sang phải, số đầu tiên là gốc)
//   Dòng 3: giá trị muốn thêm vào
//
public class Bai3 {
    // Mỗi đỉnh của cây gồm: giá trị, con trái, con phải
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Hàm chèn (đệ quy)
    public static Node insert(Node root, int data) {
        // Cây rỗng: tạo đỉnh mới ngay tại đây
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            // Nhỏ hơn thì đi sang trái
            root.left = insert(root.left, data);
        } else {
            // Lớn hơn thì đi sang phải
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Duyệt giữa (trái - gốc - phải): với BST sẽ in ra dãy tăng dần
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Duyệt trước (gốc - trái - phải): giúp thấy rõ hình dạng cây
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Đọc cây ban đầu
        System.out.print("Nhap so dinh cua cay ban dau: ");
        int n = sc.nextInt();

        Node root = null;
        System.out.print("Nhap " + n + " gia tri cua cay: ");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            root = insert(root, x);
        }

        // 2. Đọc giá trị muốn thêm
        System.out.print("Nhap gia tri muon them: ");
        int value = sc.nextInt();

        // In cây trước khi thêm
        System.out.println();
        System.out.print("Cay ban dau (duyet giua)   : ");
        inOrder(root);
        System.out.println();

        // 3. Thêm đỉnh mới
        root = insert(root, value);

        // In cây sau khi thêm
        System.out.print("Cay sau khi them (duyet giua)  : ");
        inOrder(root);
        System.out.println();
        System.out.print("Cay sau khi them (duyet truoc) : ");
        preOrder(root);
        System.out.println();

        sc.close();
    }

}
