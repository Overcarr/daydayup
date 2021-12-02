package com.example.datatructure.linkedlist;

/**
 * 快慢指针
 * @author overcare
 */
public class SpeedPointer {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        System.out.println(ringStartPoint(head));
    }

    /**
     * 判断链表是否存在环形
     *
     * @param head
     * @return
     */
    public static boolean isRing(ListNode head) {
        ListNode fast, slow;
        fast = head;
        slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回环形链表 环形开始的点
     *
     * @param head
     * @return
     */
    public static int ringStartPoint(ListNode head) {
        ListNode fast, slow;
        fast = head;
        slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    /**
     * 找到单链表的中间节点
     *
     * @param head
     * @return
     */
    public static ListNode midPoint(ListNode head) {
        ListNode fast, slow;
        fast = head;
        slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode delPoint(ListNode head, int n) {
        ListNode fast, slow;
        fast = head;
        slow = head;
        while (n > 0 ) {
            fast = fast.next;
            n--;
        }

        while (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
