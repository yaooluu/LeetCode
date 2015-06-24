package linkedlist;

public class P025_ReverseNodesinKGroup {

	public static void main(String[] args) {
		ListNode head = null, pre = null;
		for(int i=0;i<1;i++) {
			ListNode node = new ListNode(i+1);
			if(i==0) {
				head = node;
				pre = node;
			} else {
				pre.next = node;
				pre = node;
			}
		}
		
		print(head);
		
		print(reverseKGroup(head,2));

	}
	
	public static void print(ListNode head) {
		ListNode h = head;
		while(h!=null) {
			System.out.print(h.val + ", ");
			h = h.next;
		}
		System.out.println();
	}
	
	//Definition for singly-linked list.
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode start = head, end = head, p = null, q = null, preStart = null, tmp = null ,newHead = head;
        while(start != null) {
            end = start;
            int i = 0;
            while(i<k-1 && end.next != null) {
                end = end.next;
                i++;
            }
            
            if(i != k-1) break;
            p = start;
            q = start.next;
            
            i = 0;
            while(i<k-1) {
                tmp = q.next;
                q.next = p;
                p = q;
                q = tmp;
                i++;
            }

            start.next = q;
            if(preStart != null) preStart.next = p;
            else newHead = end;
            
            preStart = start;
            start = start.next;
        } 
        return newHead;
	}
}
