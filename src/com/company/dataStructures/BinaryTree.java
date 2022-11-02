package com.company.dataStructures;

/*
10.4-2
        Write an O.n/-time recursive procedure that, given an n-node binary tree, prints
        out the key of each node in the tree

10.4-3
Write an O.n/-time nonrecursive procedure that, given an n-node binary tree,
prints out the key of each node in the tree. Use a stack as an auxiliary data structure.

 */
public class BinaryTree {

    static class Node {
        Node top;
        Node left;
        Node right;
        int key;
    }

    StackNode top = null;

    static class StackNode {
        StackNode next;
        Node key;
        StackNode(Node key){
            this.key = key;
        }
    }

    void pushStack(Node n){
            if (n!=null) {
                StackNode stackNode = new StackNode(n);
                stackNode.next = top;
                top = stackNode;
            }
    }

    Node getFromStack(){
        if (top==null){
            throw new RuntimeException("Stack is empty");
        }
        Node res = top.key;
        top = top.next;
        return res;
    }

    public Node root;

    public BinaryTree(){
        this.root = new Node();
        this.root.top = null;
        this.root.right = null;
        this.root.left = null;
    }

    Node addLeftChild(Node n,int key){
       Node c =  new Node();
       c.top = n;
       c.key = key;
       n.left = c;
       return c;
    }

    Node addRightChild(Node n, int key){
        Node c =  new Node();
        c.top = n;
        n.right = c;
        c.key = key;
        return c;
    }

    public void printTreeRecurs(Node n){
        if (n!=null) {
            System.out.println(n.key);
            printTreeRecurs(n.left);
            printTreeRecurs(n.right);
        }
    }

    public void printTree(Node n){
        top=null;
        pushStack(n);
        while (top!=null) {
            Node cr = getFromStack();
            System.out.println(cr.key);
            pushStack(cr.left);
            pushStack(cr.right);
        }
    }



    public static void main(String ...arr){
        BinaryTree tree = new BinaryTree();
        tree.root.key = 1;
        Node nodel = tree.addLeftChild(tree.root, 2);
        tree.addLeftChild(nodel, 4);
        tree.addRightChild(nodel, 6);
        Node noder =tree.addRightChild(tree.root,3);
        tree.addLeftChild(noder, 7);
        tree.addRightChild(noder, 8);

        //tree.printTreeRecurs(tree.root);

        tree.printTree(tree.root);
    }

}
