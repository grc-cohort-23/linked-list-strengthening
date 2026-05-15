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
        if (head == null) {
            return 0;
        }

        int count = 0;
        ListNode current = head;

        while (current != null) {
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
        ListNode newHead = new ListNode(toAdd);

        newHead.next = head;

        return newHead;
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
        if (head == null || length(head) == 1) {
            return null;
        }

        ListNode current = head;

        while (current.next.next != null) {
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
        if (head == null) {
            return Integer.MAX_VALUE;
        }

        if (head.next == null) {
            return head.data;
        }

        int min = head.data;
        ListNode current = head;

        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
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
        if (head == null || length(head) == 1) {
            return null;
        }

        int minVal = min(head);

        if (head.data == minVal) {
            return head.next;
        }

        ListNode current = head;

        while (current.next != null && current.next.data != minVal) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }

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
        if (smallList == null && bigList == null) {
            return true;
        }

        if (length(smallList) != length(bigList)) {
            return false;
        }

        ListNode currentS = smallList;
        ListNode currentB = bigList;

        while (currentS != null) {
            if (currentS.data * 2 != currentB.data) {
                return false;
            }
           
            currentS = currentS.next;
            currentB = currentB.next;
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
        if (head == null) {
            return null;
        }

        k = k % length(head);

        if (k == 0) {
            return head;
        }

        ListNode current = head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }

        ListNode newHead = current.next;

        current.next = null;

        ListNode end = newHead;
        while (end.next != null) {
            end = end.next;
        }

        end.next = head;

        return newHead;
    }
}
