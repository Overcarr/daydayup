package com.example.datatructure.tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉排序树
 *
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int arr[] = {7, 3, 10, 12, 5, 1, 9, 2};
        List<SortNode> sortNodes = constructNode(arr);
        BinarySortTree binarySortTree = new BinarySortTree();

        for (SortNode sortNode : sortNodes) {
            binarySortTree.add(sortNode);
        }

        binarySortTree.midList();

    }

    private static List<SortNode> constructNode(int arr[]) {
        List<SortNode> sortNodes = new ArrayList<>();
        for (int i : arr) {
            SortNode sortNode = new SortNode(i);
            sortNodes.add(sortNode);
        }

        return sortNodes;
    }
}

class BinarySortTree{
    private SortNode root;

    public void midList() {
        if (root != null) {
            root.midList();
        } else {
            return;
        }
    }

    public void add(SortNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void del(int weight) {
        if (root == null) {
            return;
        } else {
            SortNode node = search(weight);
        }
    }

    /**
     * 查找删除的节点
     *
     * @param weight
     * @return
     */
    private SortNode search(int weight) {
        if (root == null) {
            return null;
        } else {
            SortNode node = root.search(weight);
        }
    }

}

@Data
class SortNode{
    private int weight;
    private SortNode left;
    private SortNode right;


    public SortNode(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                '}';
    }

    /**
     * 中序遍历
     *
     */
    public void midList() {
        SortNode leftNode = this.getLeft();
        if (leftNode != null) {
            leftNode.midList();
        }

        System.out.println(this);

        SortNode rightNode = this.getRight();
        if (rightNode != null) {
            rightNode.midList();
        }
    }

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(SortNode node) {
        if (node == null) {
            return;
        }

        if (node.getWeight() < this.getWeight()) {
            SortNode left = this.getLeft();
            if (left == null) {
                this.setLeft(node);
            } else {
                left.add(node);
            }
        } else {
            SortNode right = this.getRight();
            if (right == null) {
                this.setRight(node);
            } else {
                right.add(node);
            }
        }
    }

    /**
     * 查找要删除的节点
     *
     * @param weight
     * @return
     */
    public SortNode search(int weight) {
        if (this.getWeight() == weight) {
            return this;
        } else if (this.getWeight() < weight) {
            if (this.getLeft() != null) {
                return this.getLeft().search(weight);
            } else {
                return null;
            }
        } else {
            if (this.getRight() != null) {
                return this.getRight().search(weight);
            } else {
                return null;
            }
        }
    }

    /**
     * 查找要删除节点的父节点
     *
     * @param weight
     * @return
     */
    public SortNode searchFather(int weight) {
        if (this.getLeft() != null && this.getLeft().getWeight() == weight ||
                this.right != null && this.getRight().getWeight() == weight) {
            return this;
        } else {

        }
    }
}
