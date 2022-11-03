package com.company.dataStructures;

/**
 * 10.4-5 ?
 * Write an O.n/-time nonrecursive procedure that, given an n-node binary tree,
 * prints out the key of each node. Use no more than constant extra space outside
 * of the tree itself and do not modify the tree, even temporarily, during the procedure.
 */
public class BinaryTreeNoExtraSpace {
    public static final int MAX_SIZE = 10;

    public class Node {
        public Node left;
        public Node right;
        public Node parent;
        public int key;
    }

    public class Globals {

        public static int[] keys = new int[MAX_SIZE];
        public static int count = 0;

        public static void store(int key) {
            keys[count++] = key;
        }

        public static void printTree(Node n) {
            Node prev;
            prev = null;

            while (n != null) {
                if (prev == n.parent) {
                    store(n.key);
                    prev = n;
                    n = n.left != null ? n.left : n.right != null ? n.right : n.parent;
                } else if (prev == n.left && n.right!=null) {
                    prev = n;
                    n = n.right;
                } else {
                    prev = n;
                    n = n.parent;
                }
            }
        }

        public static void resetStorage() {
            count = 0;
        }
    }

}
