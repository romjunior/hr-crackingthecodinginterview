package com.estudo.codingInterview.datastructures;

import static com.estudo.study.datastructures.BinaryTree.Node;

public class BinarySearchTree {

    public static void main(String[] args){
        /*Node root = new Node(4);
        root.insert(2);
        root.insert(6);
        root.insert(1);
        root.insert(3);
        root.insert(5);
        root.insert(7);*/
        Node root = new Node(3);
        root.insert(2);
        root.insert(1);
        root.insert(4);
        root.insert(6);
        root.insert(5);
        root.insert(7);
        root.printInOrder();
        System.out.println(checkBST(root));
    }

    static boolean checkBST(Node root) {
        return checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBst(Node root, int min, int max){
        if (root == null) return true;

        return
                min < root.data &&
                        root.data < max &&
                        checkBst(root.left, min, root.data) &&
                        checkBst(root.right, root.data, max);
    }

}
