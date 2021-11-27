package com.example.datatructure.tree;

import lombok.Data;


/**
 * 二叉树
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "武松");
        HeroNode node3 = new HeroNode(3, "武大郎");
        HeroNode node4 = new HeroNode(4, "西门庆");
        HeroNode node5 = new HeroNode(5, "潘金莲");
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node3.setRight(node5);
        BinaryTree binaryTree = new BinaryTree(node1);
        //binaryTree.backList();
        HeroNode heroNode = binaryTree.frontSearch(5);
        System.out.println(heroNode);


    }
}


class BinaryTree{
    private HeroNode root;

    public BinaryTree(HeroNode heroNode){
        this.root = heroNode;
    }

    public HeroNode frontSearch(int no){
        if (this.root!=null){
            return this.root.frontSearch(no);
        }else {
            System.out.println("二叉树为空~");
        }
        return null;
    }

    /**
     * 前序遍历
     * 先输出当前节点
     * 向左遍历
     * 向右遍历
     */
    public void frontList(){
        if (this.root!=null){
            this.root.frontList();
        }else {
            System.out.println("二叉树为空~");
        }
    }


    /**
     * 中序遍历
     * 向左遍历
     * 输出节点
     * 向右遍历
     */
    public void midList(){
        if (this.root!=null){
            this.root.midList();
        }else {
            System.out.println("二叉树为空~");
        }
    }

    /**
     * 后序遍历
     * 向左遍历
     * 向右遍历
     * 输出节点
     */
    public void backList(){
        if (this.root!=null){
            this.root.backList();
        }else {
            System.out.println("二叉树为空~");
        }
    }
}


@Data
class HeroNode{
    public int id;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void frontList(){
        System.out.println(this);
        if (this.getLeft()!=null){
            this.getLeft().frontList();
        }
        if (this.getRight()!=null){
            this.getRight().frontList();
        }
    }

    public void midList(){
        if (this.getLeft()!=null) {
            this.getLeft().midList();
        }
        System.out.println(this);
        if (this.right!=null) {
            this.getRight().midList();
        }

    }

    public void backList(){
        if (this.getLeft()!=null) {
            this.getLeft().backList();
        }
        if (this.getRight()!=null) {
            this.getRight().backList();
        }
        System.out.println(this);
    }

    /**
     * 前序查找
     * @param id
     * @return
     */
    public HeroNode frontSearch(int id){
        if (this.getId()==id){
            return this;
        }
        HeroNode heroNode = null;
        if (this.getLeft()!=null){
            heroNode =  this.getLeft().frontSearch(id);
        }
        if (heroNode!=null){
            return heroNode;
        }
        if (this.getRight()!=null){
            heroNode =  this.getRight().frontSearch(id);
        }
        return heroNode;
    }

    /**
     * 中序查找
     * @param id
     * @return
     */
    public HeroNode midSearch(int id){
        HeroNode heroNode = null;
        if (this.getLeft()!=null){
            heroNode =  this.getLeft().midSearch(id);
        }
        if (heroNode!=null){
            return heroNode;
        }
        if (this.getId()==id){
            return this;
        }
        if (this.getRight()!=null){
            heroNode =this.getRight().midSearch(id);
        }
        return heroNode;
    }

    /**
     * 后序查找
     * @param id
     * @return
     */
    public HeroNode backSearch(int id){
        HeroNode heroNode = null;
        if (this.getLeft()!=null){
            heroNode = this.getLeft().backSearch(id);
        }
        if (heroNode!=null){
            return heroNode;
        }
        if (this.getRight()!=null){
            heroNode = this.getRight().backSearch(id);
        }
        if (heroNode!=null){
            return heroNode;
        }
        if (this.getId()==id){
            return this;
        }
        return heroNode;
    }

    /**
     * 删除节点
     * @param id
     */
    public void delete(int id){
        if (this.getLeft()!=null&&this.getLeft().getId()==id){
            this.setLeft(null);

            return;
        }
        if (this.getRight()!=null&&this.getRight().getId()==id){
            this.setRight(null);
            return;
        }
        if (this.getLeft()!=null){
            this.getLeft().delete(id);
        }
        if (this.getRight()!=null){
            this.getRight().delete(id);
        }
    }
}
