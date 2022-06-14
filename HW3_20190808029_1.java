import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author HUSEYIN EMRE UGDUL
 * @since 27.12.2021
 */
public class HW3_20190808029_1 {
    Node root;
    public static void main(String[] args) {
        List<String> textArray = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            textArray =
                    Arrays.asList(br.readLine().split(" "));


        } catch (Exception e) {
            e.printStackTrace();
        }
        HW3_20190808029_1 tree = new HW3_20190808029_1();
        for (int i = 0; i < textArray.size() ; i++) {
            tree.insert((Integer.parseInt(textArray.get(i))));
        }
        System.out.println(tree.balance(tree.root));
    }
    public boolean balance(Node node){
        int leftH;
        int rightH;

        if(node == null){
            return true;
        }

        leftH = treeHeight(node.left);
        rightH = treeHeight(node.right);

        if (Math.abs(leftH - rightH) <= 1 && balance(node.left) && balance(node.right)){
            return true;
        }
        return false;

    }
    public int treeHeight(Node node){
        if (node == null){
            return 0;
        }
        return 1 + Math.max(treeHeight(node.left), treeHeight(node.right));
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
