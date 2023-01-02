package com.company.dataStructures;

/**
Exercise 12.1.3
  Give a nonrecursive algorithm that performs an inorder tree walk.
  A more complicated, but elegant, solution uses no stack but assumes that we can test two points of equality
*/


public class BinarySearchTree
{
    static class Node
    {
        int key;
        Node left, right, parent;

        public Node(int key)
        {
            this.key = key;
            left = right = parent = null;
        }
    }

    Node root;

    void insertNoRecursion(int v){
        Node z = new Node(v);
        Node y=null;
        Node x = root;
        while (x!=null){
            y = x;
            if (z.key < x.key){
                x = x.left;
            } else {
                x = x.right;
            }
        }

        z.parent = y;
        if (y == null){
            root = z; // tree was empty
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }

    }


    /* A utility function to insert a new node with
       given key in BST */
    Node insertRecursion(Node node, int key)
    {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);

        /* Otherwise, recur down the tree */
        if (key <= node.key)
        {
            node.left = insertRecursion(node.left, key);
            node.left.parent = node;
        }
        else if (key > node.key)
        {
            node.right = insertRecursion(node.right, key);
            node.right.parent = node;
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    Node insertRecursion2(Node x,int key){

        if (x==null){
            this.root = new Node(key);
            return this.root;
        }

        Node y = x;

      if (x.key < key){
          x = x.right;
      } else {
          x = x.left;
      }

      if (x!=null){
          x = insertRecursion2(x, key);
      } else {
          x = new Node(key);
          x.parent = y;
          if (y.key < key) {
              y.right = x;
          } else {
              y.left = x;
          }
      }

      return x;
    }


    // Function to print inorder traversal using parent
    // pointer
    void inorder(Node root)
    {
        boolean leftdone = false;

        // Start traversal from root
        while (root != null)
        {
            // If left child is not traversed, find the
            // leftmost child
            if (!leftdone)
            {
                while (root.left != null)
                {
                    root = root.left;
                }
            }

            // Print root's data
            System.out.print(root.key + " ");

            // Mark left as done
            leftdone = true;

            // If right child exists
            if (root.right != null)
            {
                leftdone = false;
                root = root.right;
            }

            // If right child doesn't exist, move to parent
            else if (root.parent != null)
            {
                // If this node is right child of its parent,
                // visit parent's parent first
                while (root.parent != null
                        && root == root.parent.right)
                    root = root.parent;

                if (root.parent == null)
                    break;
                root = root.parent;
            }
            else
                break;
        }
    }


    Node max(Node x){
        while (x.right!=null){
            x=x.right;
        }
        return x;
    }

    Node min(Node x){
        while (x.left!=null){
            x=x.left;
        }
        return x;
    }

    /*
        if the right subtree of
        node x is empty and x has a successor y, then y is the lowest ancestor of x whose
        left child is also an ancestor of x
     */
    Node successor(Node x){
        if (x.right!=null){
            max(x.right);
        }
        Node y=x.parent;
        while(y!=null && y.right==x){
            x=y;
            y=y.parent;
        }
        return y;
    }

    /*
      if the left subtree of
      node x is empty and x has a successor y, then y is the lowest ancestor of x whose
      rigth child is also an ancestor of x
   */
    Node predecessor(Node x){
        if (x.left!=null){
            max(x.left);
        }
        Node y=x.parent;
        while(y!=null && y.left==x){
            x=y;
            y=y.parent;
        }
        return y;
    }

    Node search(Node x, int k){
        if (x==null || x.key == k){
            return x;
        }

        if (k < x.key){
            return search(x.left,k);
        } else {
            return search(x.right,k);
        }
    }

    void delete(Node z){
        if (z.left==null){
          transplant(z, z.right);
        } else if (z.right==null) {
          transplant(z, z.left);
        } else {
            Node y = min(z.right);
            if (y.parent!=z){
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z,y);
            y.left = z.left;
            y.left.parent = y;
        }
    }

    void transplant(Node u, Node v){
        if (u.parent==null){
            root = v;
        } else if (u.parent.left == u) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v!=null){
            v.parent = u.parent;
        }
    }

    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        /*
        tree.root = tree.insertRecursion(tree.root, 24);
        tree.root = tree.insertRecursion(tree.root, 27);
        tree.root = tree.insertRecursion(tree.root, 29);
        tree.root = tree.insertRecursion(tree.root, 34);
        tree.root = tree.insertRecursion(tree.root, 14);
        tree.root = tree.insertRecursion(tree.root, 4);
        tree.root = tree.insertRecursion(tree.root, 10);
        tree.root = tree.insertRecursion(tree.root, 22);
        tree.root = tree.insertRecursion(tree.root, 13);
        tree.root = tree.insertRecursion(tree.root, 3);
        tree.root = tree.insertRecursion(tree.root, 2);
        tree.root = tree.insertRecursion(tree.root, 6);
         */

/*        tree.insertNoRecursion(24);
        tree.insertNoRecursion(27);
        tree.insertNoRecursion(29);
        tree.insertNoRecursion(34);
        tree.insertNoRecursion(14);
        tree.insertNoRecursion(4);
        tree.insertNoRecursion(10);
        tree.insertNoRecursion(22);
        tree.insertNoRecursion(13);
        tree.insertNoRecursion(3);
        tree.insertNoRecursion(2);
        tree.insertNoRecursion(6);*/

        tree.insertRecursion2(tree.root, 24);
        tree.insertRecursion2(tree.root, 27);
        tree.insertRecursion2(tree.root, 29);
        tree.insertRecursion2(tree.root, 34);
        tree.insertRecursion2(tree.root, 14);
        tree.insertRecursion2(tree.root, 4);
        tree.insertRecursion2(tree.root, 10);
        tree.insertRecursion2(tree.root, 22);
        tree.insertRecursion2(tree.root, 13);
        tree.insertRecursion2(tree.root, 3);
        tree.insertRecursion2(tree.root, 2);
        tree.insertRecursion2(tree.root, 6);


        System.out.println("Inorder traversal is ");
        tree.inorder(tree.root);

        System.out.println();
        System.out.println("Min " + tree.min(tree.root).key);
        System.out.println("Max " + tree.max(tree.root).key);

        Node n13 = tree.search(tree.root,13);

        System.out.println("13 successor "+tree.successor(n13).key);

        Node n6 = tree.search(tree.root,6);

        System.out.println("6 predecessor "+tree.predecessor(n6).key);

    }
}