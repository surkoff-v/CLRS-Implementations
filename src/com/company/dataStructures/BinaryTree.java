package com.company.dataStructures;
/*
10.4-2
        Write an O.n/-time recursive procedure that, given an n-node binary tree, prints
        out the key of each node in the tree
 */
public class BinaryTree {

    static class Node {
        Node top;
        Node left;
        Node rigth;
        int key;
    }

    public Node root;

    public BinaryTree(){
        this.root = new Node();
        this.root.top = null;
        this.root.rigth = null;
        this.root.left = null;
    }

    Node addLeftChild(Node n,int key){
       Node c =  new Node();
       c.top = n;
       c.key = key;
       n.left = c;
       return c;
    }

    Node addRigthChild(Node n,int key){
        Node c =  new Node();
        c.top = n;
        n.rigth = c;
        c.key = key;
        return c;
    }

    public void printtree(Node n){
        if (n!=null) {
            System.out.println(n.key);
            printtree(n.left);
            printtree(n.rigth);
        }
    }

    public static void main(String ...arr){
        BinaryTree tree = new BinaryTree();
        tree.root.key = 1;
        Node nodel = tree.addLeftChild(tree.root, 2);
        tree.addLeftChild(nodel, 4);
        tree.addRigthChild(nodel, 6);
        Node noder =tree.addRigthChild(tree.root,3);
        tree.addLeftChild(noder, 7);
        tree.addRigthChild(noder, 8);

        tree.printtree(tree.root);

    }

}
