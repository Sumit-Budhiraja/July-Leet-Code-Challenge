class Solution {
    public Node flatten(Node head) {
        if(head != null){
           Node temp  = head;
            while(temp!=null){
                Node next = temp.next;
                if(temp.child != null){
                    Node flattenList = flatten(temp.child);
                    temp.child = null;
                    temp.next = flattenList;
                    flattenList.prev = temp;
                    while(temp.next != null){
                        temp = temp.next;
                    }
                    if(next!=null){
                        next.prev = temp;
                    }
                }
                temp.next = next;
                temp = temp.next;
            } 
        }
        return head;
    }
}