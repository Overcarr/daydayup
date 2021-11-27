package com.example.datatructure.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);
        System.out.println(arrayQueue.pikeHead());
        System.out.println(arrayQueue.take());
        arrayQueue.add(5);
        System.out.println(arrayQueue.take());
        System.out.println(arrayQueue.take());
        System.out.println(arrayQueue.take());
        System.out.println(arrayQueue.pikeHead());
    }
}

class ArrayQueue{
    private int max; //表示数组的最大的容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr;


    public ArrayQueue(int max){
        this.max = max;
        front=-1;
        rear=-1;
        arr = new int[max];
    }


    //判断队列是否满
    public boolean isFull(){
        return max-1 ==rear;
    }


    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //添加元素到队列
    public void add(int i){
        if (isFull()){
            throw new RuntimeException("队列已满....");
        }
        rear++;
        arr[rear] = i;
    }


    //从队列中取元素
    public int take(){
        if (isEmpty()){
            throw new RuntimeException("队列为空....");
        }
        front++;
        return arr[front];
    }


    //查看队列尾元素
    public int pikeHead(){
        if (isEmpty()){
            throw new RuntimeException("队列为空....");
        }
        return arr[rear];
    }


}
