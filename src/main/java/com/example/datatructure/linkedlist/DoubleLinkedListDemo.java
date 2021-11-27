package com.example.datatructure.linkedlist;

import lombok.Data;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");


    //添加节点链尾
    public void add(HeroNode2 heroNode2){
        HeroNode2 temp = head.getNext();
        //找到最后的节点
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode2);
        head.setPre(head);
    }


    //遍历
    public void list(){
        HeroNode2 temp = head.getNext();
        if (temp==null){
            System.out.println("链表为空~");
            return;
        }
        while (temp!=null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    //删除节点
    public void del(int no){
        if (head.getNext()==null){
            System.out.println("链表为空,删除失败....");
            return;
        }
        HeroNode2 temp = head.getNext();
        boolean flag = false;
        while (temp!=null){
            if (temp.getNo() == no){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            HeroNode2 simple = temp;
            temp.getPre().setNext(simple.getNext());
            temp.getNext().setPre(simple.getPre());
        }else {
            System.out.println("节点未找到....");
        }
    }



}

@Data
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 pre;
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "pre=" + pre +
                ", next=" + next +
                '}';
    }
}
