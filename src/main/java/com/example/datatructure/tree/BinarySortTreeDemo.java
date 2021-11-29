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

    /**
     * 查找删除的节点
     *
     * @param weight
     * @return
     */
    private void del(int weight) {
        if (root == null) {
            return;
        } else {
            SortNode node = this.search(weight);
            if (node == null) {
                return;
            }

            if (root.getLeft() == null && root.getRight() == null){
                root = null;
                return;
            }

            SortNode searchFather = this.searchFather(weight);

            if (node.getLeft() == null && node.getRight() == null) {
                if (searchFather != null) {
                    if (searchFather.getLeft()!=null && searchFather.getLeft().getWeight() == weight) {
                        searchFather.setLeft(null);
                    } else if (searchFather.getRight()!=null && searchFather.getRight().getWeight() == weight) {
                        searchFather.setRight(null);
                    }
                }
            } else if(node.getLeft() != null && node.getRight() != null) {
                int rightMinWeight = getRightMinWeight(node);
                node.setWeight(rightMinWeight);
            } else {
                if (node.getLeft() != null) {
                    if (searchFather != null) {
                        if (searchFather.getLeft().getWeight() == weight) {
                            searchFather.setLeft(node.getLeft());
                        } else {
                            searchFather.setRight(node.getLeft());
                        }
                    } else {
                        root = node.getLeft();
                    }
                } else {
                    if (searchFather != null) {
                        if (searchFather.getLeft().getWeight() == weight) {
                            searchFather.setLeft(node.getRight());
                        } else {
                            searchFather.setRight(node.getRight());
                        }
                    } else {
                        root = node.getRight();
                    }
                }
            }
        }
    }

    /**
     * 获取右子树最小的值
     *
     * @param node
     * @return
     */
    private int getRightMinWeight(SortNode node) {
        SortNode target = node;

        while (target.getLeft() != null) {
            target = target.getLeft();
        }

        del(target.getWeight());
        return target.getWeight();
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
            return root.search(weight);
        }
    }

    /**
     * 查找删除节点的父节点
     *
     * @param weight
     * @return
     */
    private SortNode searchFather(int weight) {
        if (root == null) {
            return null;
        } else {
            return root.searchFather(weight);
        }
    }

    /**
     * 左旋转
     *
     */
    private void leftRotate(){
        SortNode node = new SortNode(root.getWeight());
        node.setLeft(root.getLeft());
        node.setRight(root.getRight().getLeft());
        root.setWeight(root.getRight().getWeight());
        root.setRight(root.getRight().getRight());
        root.setLeft(node);
    }

    /**
     * 右旋转
     *
     */
    private void rightRotate() {
        SortNode node = new SortNode(root.getWeight());
        node.setRight(root.getRight());
        node.setLeft(root.getLeft().getRight());
        root.setWeight(root.getLeft().getWeight());
        root.setRight(node);
        root.setLeft(root.getLeft().getLeft());

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
            if (this.getLeft() != null && this.getWeight() > weight) {
                return this.getLeft().searchFather(weight);
            } else if (this.getRight() != null && this.getWeight() < weight) {
                return this.getRight().searchFather(weight);
            } else {
                return null;
            }
        }
    }
}
