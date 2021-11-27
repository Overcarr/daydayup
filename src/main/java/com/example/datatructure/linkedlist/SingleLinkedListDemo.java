package com.example.datatructure.linkedlist;

import lombok.Data;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

    }


    //获取有效节点的个数
    public static int getLength(HeroNode head){
        HeroNode temp = head.getNext();
        int sum=0;
        /*while (true){
            if (temp!=null){
                sum++;
                temp=temp.getNext();
            }else {
                break;
            }
        }*/
        while (temp!=null){
            sum++;
            temp = temp.getNext();
        }

        return sum;
    }


    //找到倒数第n的节点
    public static HeroNode findLastIndexNode(HeroNode head,int n){
        int length = SingleLinkedListDemo.getLength(head);//链表有效节点的个数
        int i = length-n;
        HeroNode temp = head.getNext();
        for (int j=0;j<i;j++){
            temp = temp.getNext();
        }
        return temp;
    }


    //单链表反转
    public static HeroNode reverse(HeroNode head){
        if (head.getNext()==null || head.getNext().getNext()==null){
            return head;
        }
        HeroNode temp = head.getNext();
        HeroNode xx = new HeroNode(0,"","");
        while (temp!=null){
            HeroNode next = temp.getNext();
            temp.setNext(xx.getNext());
            xx.setNext(temp);
            temp = next;
        }
        head.setNext(xx.getNext());
        return head;
    }
}


class SingleLinkedList{
    //定义一个头结点
    private HeroNode head = new HeroNode(1,"","");

    //添加链尾节点
    public void add(HeroNode HeroNode){
        HeroNode temp = head;
        while (true){
            if (temp.getNext()==null){
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(HeroNode);
    }

    //查看链表数据
    public void Check(){
        HeroNode temp = head.getNext();
        if (temp==null){
            System.out.println("链表为空~");
            return;
        }
        while (true){
            System.out.println(temp);
            if (temp.getNext()==null){
                break;
            }
            temp = temp.getNext();
        }
    }

    //根据节点no删除节点
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.getNext()==null){
                break;
            }
            if (temp.getNext().getNo()==no){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.setNext(temp.getNext().getNext());
            System.out.println("删除成功...");
        }else {
            System.out.println("不存在该节点，删除失败...");
        }
    }

    //按顺序插入节点
    public void insertOrder(HeroNode HeroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.getNext()==null){
                break;
            }
            if (temp.getNext().getNo() > HeroNode.getNo()){
                flag =  true;
                break;
            }else if (temp.getNext().getNo() == HeroNode.getNo()){

            }
            temp = temp.getNext();
        }
        if (flag){
            HeroNode.setNext(temp.getNext());
            temp.setNext(HeroNode);
        }else {
            System.out.println("节点已经存在.....");
        }
    }

}





@Data
class HeroNode{
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;


    public HeroNode(int n,String name,String nickName){
        this.no = n;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
