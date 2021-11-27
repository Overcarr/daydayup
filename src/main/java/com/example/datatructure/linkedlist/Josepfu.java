package com.example.datatructure.linkedlist;

import lombok.Data;


/**
 * 约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {

    }
}

class CircleSingleLinkedList{
    private Boy first = null;

    //构建环形队列
    public void addBoy(int nums){
        if (nums<1){
            System.out.println("参数不符合规范...");
            return;
        }
        Boy temp = null;
        for (int i=1;i<=nums;i++){
            Boy boy = new Boy(i);
            if (i==1){
                first = boy;
                first.setNext(first);
                temp  = first;
            }else {
                temp.setNext(boy);
                boy.setNext(first);
                temp = boy;
            }
        }
    }

    //查看环形队列
    public void list(){
        if (first==null){
            System.out.println("环形链表为空~");
            return;
        }
        Boy temp = first;
        while (temp!=null){
            System.out.println("小孩的编号:"+temp.getNo());
            temp = temp.getNext();
        }
    }


    /**
     * 出列的顺序
     * @param k 第几个开始
     * @param n 数几下
     * @param nums 人数
     */
    public void countBoy(int k,int n,int nums){
        if (first==null || k < 1 || k > nums){
            System.out.println("参数有误...");
            return;
        }

        //辅助节点 移动到链表的结尾
        Boy curBoy = first;
        while (true){
            if (curBoy.getNext()==first){
                break;
            }
            curBoy = curBoy.getNext();
        }


        //讲辅助节点及first移动k-1次
        for (int i=0;i<k-1;i++){
            first = first.getNext();
            curBoy = curBoy.getNext();
        }

        while (true){
            if (first==curBoy){
                break;
            }
            for (int i=0;i<n-1;i++){
                first = first.getNext();
                curBoy =curBoy.getNext();
            }
            System.out.println("需要出圈小孩的编号:"+first.getNo());
            first = first.getNext();
            curBoy.setNext(first);
        }

        System.out.println("最后一个小孩的编号:"+first.getNo());

    }



}


@Data
class Boy{
    int no;
    Boy next;

    public Boy(int no) {
        this.no = no;
    }
}
