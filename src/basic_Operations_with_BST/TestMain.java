package basic_Operations_with_BST;

import java.util.List;

public class TestMain {
public static void main(String[] args) {
	 // Tạo một node gốc cho BST
    BST<Integer> bst = new BST<>();

    // Thêm các node vào BST
    bst.add(5);
    bst.add(15);
    bst.add(3);
    bst.add(7);
    bst.add(12);
    bst.add(20);

   
   

    System.out.println("Depth of node 3: " + bst.depth(3));
    System.out.println("Height of BST: " + bst.height());
    System.out.println("Size of BST: " + bst.size());
    System.out.println("BST contains 6: " + bst.contains(6));
    System.out.println("Minimum element in BST: " + bst.findMin());
    System.out.println("Maximum element in BST: " + bst.findMax());
    System.out.println("Descendants of node 5: " + bst.descendants(5));
    System.out.println("Ancestors of node 4: " + bst.ancestors(4));

    // Các phương thức duyệt cây có thể được kiểm tra ở đây nếu cần thiết
}

}



