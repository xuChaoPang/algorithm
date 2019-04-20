package com.ray.leetcode;

/**
 * Created by xuChaoPang on 2019/4/20.
 *
 * Swap Nodes in Pairs Level -M
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */

import java.util.Stack;

/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/

public class LC24 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode ret = new ListNode(0);
        ListNode curr = ret;

        while (head != null) {

            if (head.next == null) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            } else {
                ListNode node1 = head;
                ListNode node2 = head.next;
                curr.next = node2;
                head = node2.next;
                node2.next = node1;
                node1.next = null;
                curr.next = node2;
                curr = node1;
            }
        }

        return ret.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next .next.next= new ListNode(4);
        new LC24().swapPairs(node);
    }
}
