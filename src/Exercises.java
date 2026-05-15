

public class Exercises {
    /**
     * Returns a count of how many nodes are in the linked list.
     * 
     * Returns 0 if head is null.
     * 
     * Example: 
     * Input: 9 -> 2 -> 10 -> 1
     * Output: 4
     * 
     * @param head the head of the linked list
     * @return the length of the list
     */
    public static int length(ListNode head) {

        int count = 0;
        
        ListNode current = head;

        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Adds a new value to the front of the list and returns the new head.
     * 
     * Example:
     * head: 7 -> 6 -> 0
     * toAdd: 4
     * 
     * Output: 4 -> 7 -> 6 -> 0
     * 
     * @param head the head of the linked list
     * @param toAdd the value to add to the front
     * @return the new head of the linked list
     */
    public static ListNode prepend(ListNode head, int toAdd) {
        ListNode node = new ListNode(toAdd);
        node.next = head;
        return node;
    }

    /**
     * Removes the last element in the linked list and returns the head.
     * 
     * If head is null or the only element in the list, returns null.
     * 
     * Example:
     * Input: 6 -> 4 -> 9 -> 2
     * Output: 6 -> 4 -> 9
     *  
     * @param head the head of the linked list
     * @return the head of the list with the last element removed
     */
    public static ListNode removeLast(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode cur = head;
        ListNode dummy = cur;

        while (cur.next.next!=null) { 
            cur = cur.next;
        }
        cur.next = null;
        head = dummy;

        return head;
    }

    /**
     * Returns the minimum value in the linked list, or Integer.MAX_VALUE if
     * head is null.
     * 
     * Example:
     * Input: 3 -> -4 -> 9 -> 2
     * Output: -4
     * 
     * @param head the head of the linked list
     * @return the minimum value in the list 
     */
    public static int min(ListNode head) {
        int min = Integer.MAX_VALUE;
        ListNode cur = head;

        while(cur != null){ 
            min = Math.min(min, cur.data);
            cur = cur.next;
        }
        return min;
    }

    /**
     * Removes the first instance of the node with the minimum value from the
     * list and returns the head. If head is null or the only element in the list,
     * returns null.
     * 
     * Examples:
     * Input: 3 -> 9 -> 0 -> -1 -> 5
     * Output: 3 -> 9 -> 0 -> 5
     * 
     * Input: 2 -> 4 -> 2 -> 9
     * Output: 4 -> 2 -> 9
     * 
     * HINT: use min as a helper method
     * 
     * @param head the head of the linked list
     * @return the head of the list with the first instance of the minimum value removed
     */
    public static ListNode removeMin(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        int min = head.data;
        ListNode cur = head;

        while(cur != null){ 
            min = Math.min(min, cur.data);
            cur = cur.next;
        }
        System.out.println(min);

        ListNode node = new ListNode(0);
        ListNode node2 = node;
        while (head!= null) { 
            if (head.data == min) {
                node.next = head.next;
                return node2.next;

            }
            node.next = new ListNode(head.data);
            head = head.next;
            node = node.next;
        }
        return node2.next;
    }

    /**
     * Returns whether two lists are of equal length AND each value in bigList is double
     * that of the corresponding value in smallList. Returns false otherwise.
     * 
     * If BOTH lists are null, returns true.
     * 
     * Example:
     * smallHead: 4 -> 3 -> 9
     * bigHead:   8 -> 6 -> 18
     * Output: true
     * 
     * smallHead: 4 -> 3 -> 9
     * bigHead:   8 -> 6 -> 7
     * Output: false
     * 
     * 
     * @param smallHead the head of the list with the half values
     * @param bigHead the head of the list with the doubled values
     * @return whether the values in bigList are twice the values in smallList
     */
    public static boolean isDoubled(ListNode smallList, ListNode bigList) {
        if(smallList == null && bigList == null){
            return true;
        }

        while (smallList!=null && bigList !=null) { 
            if (smallList.data * 2 != bigList.data) {
                return false;
            }
            smallList = smallList.next;
            bigList = bigList.next;
        }
        if( bigList != null || smallList !=null){
            return false;
        }
        return true;
    }

    /**
     * Rotates a list by k elements to the left and returns the new head.
     * 
     * If head is null, return null.
     * 
     * Example:
     * head: 1 -> 2 -> 3 -> 4 -> 5
     * k: 2
     * Output: 3 -> 4 -> 5 -> 1 -> 2
     * 
     * @param head the head of the linked list
     * @param k the number of positions to rotate
     * @return the head of the new list after k rotations to the left
     */
    public static ListNode rotateLeft(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        int size = 0;
        ListNode s = head;

        while(s!=null){
            size++;
            s = s.next;
        }

        if(k == size){
            return head;
        }
        if(k > size){
            k = k%size;
        }

        ListNode head2 = head;
        ListNode dummy2 = new ListNode(head2.data);
        ListNode dummy = dummy2;
        
        for(int i = 0; i < k ; i++){
            dummy2.next = new ListNode(head2.data);    
            dummy2 = dummy2.next;
            head = head.next;
            head2 = head2.next;

            System.out.println(dummy2.data + " | D2");
        }

        ListNode head3 = head2;
        while(head3.next != null){

            head3 = head3.next;
            System.out.println(head3.data + " | H3");

        }
        
        head3.next = dummy.next;

        return head2;
    }
}
