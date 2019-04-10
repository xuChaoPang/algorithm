package com.ray.leetcode;

/**
 * Created by xuChaoPang on 2019/4/9.
 * Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
public class LC86 {
    public ListNode partition(ListNode head, int x) {

        ListNode minNodeHead = new ListNode(0);
        ListNode maxNodeHead = new ListNode(0);
        ListNode minNode = minNodeHead;
        ListNode maxNode = maxNodeHead;
        if (head == null) {
            return null;
        }
        ListNode currNode = head;
        while (currNode != null) {
            if (currNode.val < x) {
                minNode.next = currNode;
                currNode = currNode.next;
                minNode = minNode.next;
                minNode.next = null;
            } else  {
                maxNode.next = currNode;
                currNode = currNode.next;
                maxNode = maxNode.next;
                maxNode.next = null;
            }

        }
        minNode.next = maxNodeHead.next;
        return minNodeHead.next;
    }

    public static void main (String [] args) {
        //1->4->3->2->5->2
    }
}
