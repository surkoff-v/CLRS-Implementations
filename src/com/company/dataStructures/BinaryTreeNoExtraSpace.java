package com.company.dataStructures;

import java.util.Stack;

/**
 * 10.4-5 ?
 * Write an O.n/-time nonrecursive procedure that, given an n-node binary tree,
 * prints out the key of each node. Use no more than constant extra space outside
 * of the tree itself and do not modify the tree, even temporarily, during the procedure.
 */

/*

12.1-3
        Give a nonrecursive algorithm that performs an inorder tree walk. (Hint: An easy
        solution uses a stack as an auxiliary data structure.

 */


/* Class to print the inorder traversal */
public class BinaryTreeNoExtraSpace {

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    void inorder() {
        if (root == null)
            return;

        Stack<Node> s = new Stack<>();
        Node curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {

            /* Reach the left most Node of the
            curr Node */
            while (curr != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.key + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
    }

    public static void main(String... args) {

        BinaryTreeNoExtraSpace tree = new BinaryTreeNoExtraSpace();

        Node n = new Node(6);
        tree.root = n;
        n.left = new Node(5);
        n.right = new Node(7);
        Node nl = n.left;
        nl.left = new Node(2);
        nl.right = new Node(5);

        Node nr = n.right;
        nr.right = new Node(8);

        tree.inorder();

    }
}




