package com.erasr.listnode;

//带虚拟头结点的链表
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {6, 6, 1, 2, 6, 3, 4, 5, 6};
        ListNode list = new ListNode(arr);
        System.out.println(list);

        ListNode res = new Solution().removeElements(list, 6);
        System.out.println(res);

        //这里为什么打印这个 list 结果就不对了
//        new Solution().removeElements(list, 6);
//        System.out.println(list);
    }
}