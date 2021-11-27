package com.example.datatructure.queue;

public class CircleQueueDemo {
}

class CircleQueue{
    int front;
    int rear;
    int max;
    int[] arr;


    //初始化环形队列
    public CircleQueue(int max){
        this.max = max;
        arr = new int[max];
    }

    public boolean isFull(){
        return (rear+1) % max ==front;
    }

    public boolean isEmpty(){
        return front==rear;
    }

    public void add(int i){
        if (isFull()){
            throw new RuntimeException("队列已满.....");
        }
        arr[rear] = i;
        rear = (rear+1) % max;
    }

    public int take(){
        if (isEmpty()){
            throw new RuntimeException("队列已空.....");
        }
        int i=arr[front];
        front = (front+1) % max;
        return i;
    }


    //有效个数
    public int size(){
        return (rear+max-front) % max;
    }

    public int pickHead(){
        return arr[front];
    }
}
