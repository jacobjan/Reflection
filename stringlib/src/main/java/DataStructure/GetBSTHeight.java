package DataStructure;

/**
 * Created by AiYeSus on 12/21/2017.
 */
import java.util.*;
import java.io.*;
class bstNode{
    bstNode left,right;
    int data;
    bstNode(int data){
        this.data=data;
        left=right=null;
    }
}

public class GetBSTHeight {

    private static int heightL, heightR;

    public static int getHeight(bstNode head){
        heightL=heightR=0;
        if ( head != null ) {
            getHeightRC(head.left);
            getHeightRC(head.right);
        }
        return Math.max(heightL, heightR);
    }

    public static void getHeightRC(bstNode root){
        if ( root != null && root.left != null ) {
            heightL++;
            System.out.println("heightL :"+heightL+ " "+root.left.data);
            getHeightRC(root.left);
        }
        if ( root != null && root.right != null ) {
            heightR++;
            System.out.println("heightR :"+heightR+ " "+root.right.data);
            getHeightRC(root.right);
        }
    }

    // Iterative method to find height of Bianry Tree
    public static int treeHeight(bstNode node) {
        // Base Case
        if (node == null)
            return 0;

        // Create an empty queue for level order tarversal
        Queue<bstNode> q = new LinkedList();

        // Enqueue Root and initialize height
        q.add(node);
        int height = 0;

        while (1 == 1)
        {
            // nodeCount (queue size) indicates number of nodes
            // at current lelvel.
            int nodeCount = q.size();
            if (nodeCount == 0)
                return --height;
            height++;

            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0)
            {
                bstNode newnode = q.peek();
                q.remove();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
    }

    public static bstNode insert(bstNode root,int data){
        if(root==null){
            return new bstNode(data);
        }
        else{
            bstNode cur;
            if(data<=root.data){
                System.out.println("inserting :"+data+ " to the left of "+root.data);
                cur=insert(root.left,data);
                root.left=cur;
            } else {
                System.out.println("inserting :"+data+ " to the right of "+root.data);
                cur=insert(root.right, data);
                root.right=cur;
            }
            return root;
        }
    }

    public static void main(String args[]){
        int[] arr = {7, 3, 5, 2, 1, 4, 6, 7};

        bstNode root = null;
        for(int i=0; i<arr[0]; i++) {
            root = insert(root, arr[i]);
        }
        int Height=getHeight(root);
        System.out.println( Height );
        bstNode root4 = null;
        int[] arr1 = {9, 20, 50, 35, 44, 9, 15, 62, 11, 13};

        for(int i=0; i<arr1[0]; i++) {
            root4 = insert(root4, arr1[i]);
        }
        Height=getHeight(root4);
        System.out.println( Height );

        int[] arr2 = {13, 25, 39, 12, 19, 9, 23, 55, 31, 60, 35, 41, 70, 90};
        bstNode root5 = null;
        for(int i=0; i<arr2[0]; i++) {
            root5 = insert(root5, arr2[i]);
        }
        Height=getHeight(root5);
        System.out.println( Height );
/*        Scanner sc=new Scanner(System.in);
        int height;
        do {
            int T = sc.nextInt();
            height=0;
            root = null;
            while (T-- > 0) {
                int data = sc.nextInt();
                root = insert(root, data);
            }
            height = getHeight(root); //treeHeight(root);
            System.out.println(height);
        } while ( height != 0 );*/
    }
}
/**7 3 5 2 1 4 6 7
 A: 3
 9
 20 50 35 44 9 15 62 11 13
 Ans 4
 13
 25 39 12 19 9 23 55 31 60 35 41 70 90
 Ans 5
 */