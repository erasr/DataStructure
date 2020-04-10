package com.erasr.listnode;

//运用递归来解决
class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

//        if(head == null)
//            return head;
//
//        ListNode res = removeElements(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }

        if(head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] arr = {6, 6, 1, 2, 6, 3, 6, 4, 5, 6};
        ListNode list = new ListNode(arr);
        System.out.println(list);

        ListNode res = new Solution().removeElements(list, 6);
        System.out.println(res);
    }
}