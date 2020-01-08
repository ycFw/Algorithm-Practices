package yc.java.listnode;

/**
 * @program: Algorithm-Practices
 * @description: 链表中倒数第k个节点
 * @author: yc
 * @create: 2019-11-29 14:59
 *
 * 1-->2-->3-->4-->5-->6-->null
 * 倒数第3个节点是4
 *
 * 设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K 个节点，
 * 则还有 N - K 个节点可以移动。此时让 P1 和 P2 同时移动，
 * 可以知道当 P1 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。
 **/


public class FindKthToTail {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        ListNode p1 = head;
        //k=2
        while (p1 != null && k-- > 0)
            p1 = p1.next;
        if (k > 0)
            return null;
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }

    public static void main(String[] args) {
        InitListNode listnode = new InitListNode();
        ListNode head = listnode.init();
        System.out.println(FindKthToTail(head, 2).val);
    }
}

class InitListNode {
    public ListNode head = null;
    public ListNode cur = null;

    //加入数据
    public void addData(int data) {
        if (head == null) {
            head = new ListNode(data);
            cur = head;
        } else {
            cur.next = new ListNode(data);
            cur = cur.next;
        }
    }

    //初始化链表并返回表头
    public ListNode init() {
        for (int i = 0; i < 6; i++) {
            this.addData(i + 1);
        }
        return head;
    }
}