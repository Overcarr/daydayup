package com.example.datatructure.hash;


import lombok.Data;

/**
 * 哈希散列
 */
public class HashTabDemo {
    public static void main(String[] args) {

    }
}

@Data
class Emp{
    private int id;
    private int name;
    private Emp next;

    public Emp(int id, int name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{
    private Emp head;

    //添加节点
    public void add(Emp emp){
        if (head==null){
            head = emp;
        }
        Emp temp = head;
        while (true){
            if (temp.getNext()==null){
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(emp);
    }

    public void list(){

    }
}
