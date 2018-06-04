package com.estudo.study.datastructures;

public class BinaryTree {

    public static class Node{
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }

        public void insert(int value){
            if(value < data){
                if(left == null){
                    left = new Node(value);
                }else{
                    left.insert(value);
                }
            }else{
                if(value > data){
                    if(right == null){
                        right = new Node(value);
                    }else {
                        right.insert(value);
                    }
                }
            }
        }

        public boolean contains(int value){
            if(value == data){
                return true;
            }else if(value < data){
                if(left == null){
                    return false;
                }else{
                    return left.contains(value);
                }
            }else{
                if(right == null){
                    return false;
                }else{
                    return right.contains(value);
                }
            }
        }

        public void printInOrder(){
            //Tranversals
            //In-Order = left, root, right
            //Pre-Order = root, left, right
            //Post-Order = left, right, root

            //left
            if(left != null){
                left.printInOrder();
            }
            //root
            System.out.println(data);

            //right
            if(right != null){
                right.printInOrder();
            }
        }
    }

    public static void main(String[] args){
        Node root = new Node(4);
        root.insert(2);
        root.insert(6);
        root.insert(1);
        root.insert(3);
        root.insert(5);
        root.insert(7);
        root.printInOrder();
    }
}
