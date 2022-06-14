import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
/**
 * @author HUSEYIN EMRE UGDUL
 * @since 27.12.2021
 */
public class HW3_20190808029_2 {
    Node root;
    Stack<Integer> paths = new Stack<Integer>();
    int temp;
    int result;
    int isTrue;
    public static void main(String[] args) {
        List<String> textArray = new ArrayList<>();
        HW3_20190808029_2 tree = new HW3_20190808029_2();
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            textArray =
                    Arrays.asList(br.readLine().split(" "));
            tree.result = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < textArray.size() ; i++) {
            tree.insert((Integer.parseInt(textArray.get(i))));
        }
        tree.findPaths(tree.root);
        if (tree.isTrue == 0){
            System.out.println("false");
        }
    }
    public void findPaths(Node root){
        if (root == null)
            return;
        paths.push(root.data);
        temp += paths.peek();
        findPaths(root.left);
        if (root.left == null && root.right == null){
            if (temp == result){
                isTrue += 1;
                if (isTrue == 1){
                    System.out.println("true");
                }
                String truePath =
                        paths.toString().replaceAll(", ", "-").replaceAll("\\["
                                ,"").replaceAll("\\]", "");
                System.out.println(truePath);
            }
        }
        findPaths(root.right);
        temp -= paths.peek();
        paths.pop();

    }
    public void insert(int data){
        Node node = root;
        Node parent = null;
        while(node!=null){
            parent = node;
            if (data < node.data){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
        Node newNode = new Node(data);
        if (parent == null){
            this.root = newNode;
            newNode.parent = null;
        }else if (data < parent.data){
            parent.left = newNode;
            newNode.parent = parent;
        }
        else{
            parent.right = newNode;
            newNode.parent = parent;
        }
    }

    private static class Node{
        int data;
        Node parent, right, left;

        public Node(int data){
            this.data = data;
        }
    }
}
