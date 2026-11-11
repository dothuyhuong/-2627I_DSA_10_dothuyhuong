import java.util.Scanner;

// Bài 4: Tìm tổ tiên chung gần nhất (LCA) của 2 đỉnh trong cây tìm kiếm nhị phân (BST)
//
// Input:
//   Dòng 1: n (số đỉnh của cây)
//   Dòng 2: n giá trị của cây (chèn lần lượt từ trái sang phải, số đầu tiên là gốc)
//   Dòng 3: hai giá trị v1 v2 cần tìm tổ tiên chung (chắc chắn có trong cây)
//
public class Bai4 {
    // Mỗi đỉnh của cây gồm: giá trị, con trái, con phải
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Hàm chèn (dùng để dựng cây từ input)
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // Hàm tìm LCA (đệ quy)
    public static Node lca(Node root, int v1, int v2) {
        // Cả hai nhỏ hơn root: LCA ở bên trái
        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }

        // Cả hai lớn hơn root: LCA ở bên phải
        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }

        // Hai giá trị tách ra hai phía (hoặc trùng root): root chính là LCA
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Đọc cây
        System.out.print("Nhap so dinh cua cay: ");
        int n = sc.nextInt();

        Node root = null;
        System.out.print("Nhap " + n + " gia tri cua cay: ");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            root = insert(root, x);
        }

        // 2. Đọc 2 đỉnh cần tìm tổ tiên chung
        System.out.print("Nhap 2 dinh can tim to tien chung: ");
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        // 3. Tìm và in kết quả
        Node ans = lca(root, v1, v2);
        System.out.println();
        System.out.println("To tien chung gan nhat cua " + v1 + " va " + v2 + " la: " + ans.data);

        sc.close();
    }
}
