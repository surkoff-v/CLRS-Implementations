package com.company.dataStructures;

import javax.swing.*;

/*
10.4-4
        Write an O.n/-time procedure that prints all the keys of an arbitrary rooted tree
        with n nodes, where the tree is stored using the left-child, right-sibling representation.
 */
public class MultiNodedTree {

    Node root;

    public MultiNodedTree(int key) {
        root = new Node(key);
    }

    static class Node{
        private Node leftChild;
        private Node rightSibling;

        public Node(int key) {
            this.key = key;
        }

        int key;
        Node addLeftChild(int key){
            Node n = new Node(key);
            this.leftChild = n;
            return n;
        }
        Node addRightSibling(int key){
            Node n = new Node(key);
            this.rightSibling = n;
            return n;
        }
    }

    public void printTree(Node n){
        if (n!=null){
            System.out.println(n.key);
            printTree(n.leftChild);
            printTree(n.rightSibling);
        }
    }

    public static void main(String ...arg){
        MultiNodedTree tree = new MultiNodedTree(1);
        Node leftChild1 = tree.root.addLeftChild(2).addLeftChild(4);
        leftChild1.addRightSibling(3).addRightSibling(9).addRightSibling(10);
        leftChild1.addLeftChild(5).addRightSibling(6).addRightSibling(7).addRightSibling(8);
        tree.printTree(tree.root);
    }


}
