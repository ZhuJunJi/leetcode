package com.leetcode.solution;

import com.leetcode.solution.data.structure.ListNode;
import org.junit.Test;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author zhujunji
 */
public class LeetCodeNo21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(), p1 = l1, p2 = l2, current = root;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                current.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                current.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            current = current.next;
        }
        current.next = p1 == null ? p2 : p1;
        return root.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 第一个节点较小的链
        ListNode p1, p2, root;
        if (l1.val < l2.val) {
            p1 = l1;
            p2 = l2;
        } else {
            p1 = l2;
            p2 = l1;
        }
        root = p1;
        while (p2 != null) {
            if (p1.next != null) {
                if (p1.next.val > p2.val) {
                    p1.next = new ListNode(p2.val, p1.next);
                    p2 = p2.next;
                }
            } else {
                p1.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p1 = p1.next;

        }
        return root;
    }

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = mergeTwoLists(listNode1, listNode4);
        while (listNode != null) {
            System.out.printf(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();

    }
}
