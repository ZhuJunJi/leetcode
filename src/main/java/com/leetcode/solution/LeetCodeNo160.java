package com.leetcode.solution;

import com.leetcode.solution.data.structure.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("all")
/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @author zhujunji
 */
public class LeetCodeNo160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode girlsLife = headA,boysLife = headB,girl = girlsLife, boy = boysLife;
        while (girl != boy){
            if(girl == null){
                girl = boysLife;
            }else {
                girl = girl.next;
            }
            if(boy == null){
                boy = girlsLife;
            }else {
                boy = boy.next;
            }
        }
        return girl;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        Set<Integer> addressSet = new HashSet<>();
        while (headA != null || headB != null){
            if(headA != null){
                Integer addressA = System.identityHashCode(headA);
                if(addressSet.contains(addressA)){
                    return headA;
                }else {
                    addressSet.add(addressA);
                    headA = headA.next;
                }
            }
            if(headB != null){
                Integer addressB = System.identityHashCode(headB);
                if(addressSet.contains(addressB)){
                    return headB;
                }else {
                    addressSet.add(addressB);
                    headB = headB.next;
                }
            }
        }
        return null;
    }

    @Test
    public void test(){
        ListNode listNodeA = new ListNode(4);
        listNodeA.next = new ListNode(1);

        ListNode listNodeB = new ListNode(5);
        listNodeB.next = new ListNode(0);
        listNodeB.next.next = new ListNode(1);

        ListNode listNode = new ListNode(8);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);

        listNodeA.next.next = listNode;
        listNodeB.next.next.next = listNode;

        System.out.println(listNode);
        System.out.println(getIntersectionNode(listNodeA,listNodeB));

    }
}
