package datastruct;

public class ListNode {
  public int val;
  public ListNode next, prev;

  public ListNode() {

  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
    this.next.prev = this;
  }
}
