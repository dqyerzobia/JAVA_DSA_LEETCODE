/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    return swap(head);
};

var swap = (head)=>{
    if(head == null || head.next == null)return head;
    
    let first = head;
    let sec = head.next;

    first.next = swap(sec.next);
    sec.next = first;

    return sec;
}