package com.erasr.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //对比和下边的两个 add() 递归方式
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//        } else {
//            add(root, e);
//        }
//    }
//
//    private void add(Node node, E e) {
//        if(e.equals(node.e)) {
//            return;
//        } else if(e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if(e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//
//        if(e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }
//    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e){
        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    //看二分搜索树中是否包含元素e
    public Boolean contains(E e) {
        return contains(root, e);
    }

    //获取搜索树中的最小元素
    public E miniMum() {
        if(size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return miniMum(root).e;
    }

    //返回以node为根的二分搜索树的最小值所在的节点
    //这个操作相当于：「链表」找尾节点的递归操作，这个left指针就相当于是链表的next指针
    private Node miniMum(Node node) {
        if(node.left == null) {
            return node;
        }
        return miniMum(node.left);
    }

    //获取搜索树中的最大元素
    public E maxiMum() {
        if(size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maxiMum(root).e;
    }

    //返回以node为根的二分搜索树的最大值所在的节点
    private Node maxiMum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maxiMum(node.right);
    }

    //以node为根的二分搜索树是否包含元素e，递归算法
    private Boolean contains(Node node, E e) {

        if(node == null) {
            return false;
        }

        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //非递归的前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();

            System.out.println(cur.e);

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void levleOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    //从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMin() {
        E ret = miniMum();
        root = removeMin(root);
        return ret;
    }

    //删除掉以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    //注意理解这里递归算法的「宏观语义」
    private Node removeMin(Node node) {
        //递归终止条件
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    //从BST中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    //删除以node为根的BST中值为e的节点，递归
    //返回删除节点后新的BST的根
    private Node remove(Node node, E e) {
        //按照BST的规则（左小右大）找下去，找不到这个待删除的节点，所以「node == null」是递归到底的条件
        if (node == null) {
            return null;
        }
        //待删除的节点值比当前节点值小，就去左子树找
        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;

        //待删除的节点值比当前节点值大，就去右子树找
        } else if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {  // 此时 e == node.e，是待删除的节点
            //待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            /**待删除节点左右子树都不为空的情况  采用 Hibbard Deletion 方法（由Hibbard于1962年提出）
             *如果要删除的节点（后面称为d）的左右子树都不为空，那么选择d的后继节点（即：BST中存在的比d大的最小的节点，后面称为s），
             *将s.right = removeMin(node.right);（即：s.right = d删除掉s后的右子树），然后s.left = node.left; 执行完这两步后，
             * d的左后子树已经分别被s的左右子树接到了。这时候d的左右子树可以置空了。最后只需将s返回即可。
             *
             * 这里不用维护size，因为调用removeMin(node.right)时已经 「size --;」 了。
            */
            Node successor = miniMum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if(node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 2, 4};
        for(int num : nums) {
            bst.add(num);
        }
//        bst.preOrder();

//        bst.preOrderNR();

        bst.levleOrder();
//        bst.removeMin();
        bst.remove(0);
        bst.levleOrder();

//        System.out.println(bst);
    }
}
