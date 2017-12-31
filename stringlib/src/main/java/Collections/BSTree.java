package Collections;
/*
* Created by AiYeSus on 12/8/2017.
 *  Java Program to Implement Binary Search Tree
 */

 import java.util.Scanner;

/* Class BinarySearchTree */
public class BSTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of BST */
        BST bst = new BST();
        System.out.println("Binary Search Tree Test\n");
        int sz = 20;
        bst.insert(sz/2 + 1);
        for(int i=1; i<=sz; i++) {
            if ( i != sz/2 + 1 ) bst.insert(i);
        }
        int choice=1;
        /*  Perform tree operations  */
        do {
            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. search");
            System.out.println("4. count nodes");
            System.out.println("5. check empty");
            System.out.println("6. find largest and second largest");
            System.out.println("7. Modify Tree size");
            System.out.println("Anything else, exit");

            choice = scan.nextInt();
            switch (choice) {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    bst.insert( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter integer element to delete");
                    bst.delete( scan.nextInt() );
                    break;
                case 3 :
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : "+ bst.search( scan.nextInt() ));
                    break;
                case 4 :
                    System.out.println("Nodes = "+ bst.countNodes());
                    break;
                case 5 :
                    System.out.println("Empty status = "+ bst.isEmpty());
                    break;
                case 6 :
                    int[] ret = bst.findLargests();
                    System.out.println("*** 2nd Largest value = "+ret[0]+", Largest "+ret[1] );
                    break;
                case 7 :
                    sz = scan.nextInt();
                    bst.clear();
                    bst.insert(sz/2 + 1);
                    for(int i=1; i<=sz; i++) {
                        if ( i != sz/2 + 1 ) bst.insert(i);
                    }
                    ret = bst.findLargests();
                    System.out.println("*** 2nd Largest value = "+ret[0]+", Largest "+ret[1] );

                    break;
                default :
                    System.out.println("Exit \n ");
                    break;
            }
            /*  Display tree  */
            //String[] hrstr = {"One", "Two"};
           /* System.out.print("\nPost order : ");
            bst.postorder();
            System.out.print("\nPre order : ");
            bst.preorder();
            System.out.print("\nIn order : ");
            bst.inorder();*/
        } while (choice > 0 && choice < 8);
    }
}

class BSTNode {
    BSTNode left, right;
    int data;
    /* Constructor */
    public BSTNode() {
        left = null;
        right = null;
        data = 0;
    }
    /* Constructor */
    public BSTNode(int n) {
        left = null;
        right = null;
        data = n;
    }
    /* Function to set left node */
    public void setLeft(BSTNode n) {
        left = n;
    }
    /* Function to set right node */
    public void setRight(BSTNode n) {
        right = n;
    }
    /* Function to get left node */
    public BSTNode getLeft() {
        return left;
    }
    /* Function to get right node */
    public BSTNode getRight() {
        return right;
    }
    /* Function to set data to node */
    public void setData(int d) {
        data = d;
    }
    /* Function to get data from node */
    public int getData() {
        return data;
    }
}

/* Class BST */
class BST {
    private BSTNode root;
    private int srchCount = 0, idx=0;
    private int[] arr=new int[2];

    /* Constructor */
    public BST() {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Function to check if tree is empty */
    public void clear() {
        root = null;
    }

    /* Functions to insert data */
    public void insert(int data) {
        root = insert(root, data);
    }
    /* Function to insert data recursively */
    private BSTNode insert(BSTNode node, int data) {
        if (node == null)
            node = new BSTNode(data);
        else {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
    /* Functions to delete data */
    public void delete(int k) {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry "+ k +" is not present");
        else {
            root = delete(root, k);
            System.out.println(k+ " deleted from the tree");
        }
    }

    private BSTNode delete(BSTNode root, int k) {
        BSTNode p, p2, n;
        if (root.getData() == k) {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData())
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else
        {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }
    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(BSTNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(int val) {
        return search(root, val);
    }
    /* Function to search for an element recursively */
    private boolean search(BSTNode bnode, int val) {
        srchCount++;
        boolean found = false;
        while ((bnode != null) && !found) {
            int rval = bnode.getData();
            if (val < rval)
                bnode = bnode.getLeft();
            else if (val > rval)
                bnode = bnode.getRight();
            else {
                found = true;
                System.out.println("Number of calls to search(BSTNode, val) : "+srchCount);
                break;
            }
            found = search(bnode, val);
        }
        return found;
    }

    public int[] findLargests() {
        if ( root == null ) return null;
        BSTNode node = root;
        int[] nums = new int[2];   // 0 - 2nd largest,  1 - largest
        nums[0] = nums[1] = node.getData();
        while ( node.right != null ) {
            nums[0] = node.getData();
            node = node.right;
            nums[1] = node.getData();
            //System.out.println("largest process :"+nums[0] +" "+nums[1]);
        }
        if ( node.left != null && nums[0] < node.left.getData()) {
            nums[0] = node.left.getData();
        };
        return nums;
    }

    /* Function for inorder traversal */
    public void inorder() {
        //arr = new int[6];
        inorder(root);
    }
    private void inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(BSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(BSTNode r)
    {
        if (r != null)
        {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }
}
