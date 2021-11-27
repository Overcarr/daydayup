package com.example.datatructure.tree;


import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node node = huffmanTree(arr);

        node.preList(node);
    }

    private static Node huffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            Node node = new Node(i);
            nodes.add(node);
        }

        while (nodes.size() > 1){
            Collections.sort(nodes);

            Node node1 = nodes.get(0);
            Node node2 = nodes.get(1);
            Node node = new Node(node1.getWeight() + node2.getWeight());
            node.setLeft(node1);
            node.setRight(node2);

            nodes.remove(node1);
            nodes.remove(node2);
            nodes.add(node);
        }

        return nodes.get(0);
    }
}


@Data
class Node implements Comparable<Node>{
    private int weight;
    private Node left;
    private Node right;


    public Node(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    public void preList(Node node){
        System.out.println(node);

        Node left = node.getLeft();
        if (left != null) {
            preList(left);
        }

        Node right = node.getRight();
        if (right != null) {
            preList(right);
        }
    }
}
