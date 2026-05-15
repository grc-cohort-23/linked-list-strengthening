import java.util.List;

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
        int size = 0;
        ListNode current = head;
        
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
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
        ListNode newNode = new ListNode(toAdd);
        newNode.next = head;

        return newNode;
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
        if(head == null) return null;
        ListNode current = head;
        int size = length(head);
        if(size == 1){
            head = null;
            return head;
        }

        for(int i = 0; i < size-2; i++){
            current = current.next;
        }
        current.next = null;
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
        ListNode current = head;
        while(current != null){
            if(current.data < min) min = current.data;
            current = current.next;
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
        if(head == null) return head;
        if(head.next == null){
            head = null;
            return head;
        }
        int min = min(head);
        if(head.data == min){
            head = head.next;
            return head;
        }
        ListNode current = head;
        while(current.next.data != min){
            current = current.next;
        }
        current.next = current.next.next;
        return head;
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
        int smallSize = length(smallList);
        int bigSize = length(bigList);

        if(smallSize != bigSize) return false;

        ListNode small = smallList;
        ListNode big = bigList;

        for(int i = 0; i < smallSize; i++){
            if(big.data / 2 != small.data) return false;
            small = small.next;
            big = big.next;
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
        if(head == null) return null;
        ListNode end = head;
        while(end.next != null) end = end.next;

        ListNode temp = null;
        for(int i = 0; i < k; i++){
            temp = head;
            head = head.next;
            end.next = temp;
            end = end.next;
        }
        return head;
    }
}
