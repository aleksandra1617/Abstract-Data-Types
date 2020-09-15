package ads_ica2;


/**
 * Represents a circular linked list.
 * 
 * @author Aleksandra Petkova
 * @since 23/04/2017
 */
public class CircularLinkedList
{
    /**
     * Stores the first node in the list. In this case this node is always a dummy node with a sentinel value of 999.
     */
    ListNode head;

    /**
     * Creates a new circular linked list.
     */
    public CircularLinkedList()
    {
        /* We want to create an empty list. An empty list has a sentinel `head` node with a value of 999. This method is
           given to you. Do not modify it. */
           
        ListNode newNode = new ListNode(999); // Add sentinel node.
        head = newNode;
        newNode.next = head; // Sentinel node links to itself.
    }
    
    /**
     * Creates a new linked list from an existing array.
     *
     * @param array the array to create the new linked list from
     */
    public CircularLinkedList(int[] array)
    {
        /* We need to loop over the array of integers given to us in `array` and add them as list nodes, one at a time. 
           This method is given to you. Do not modify it. */
           
        ListNode last = null;
        ListNode newNode = null;
        ListNode prev = null;
        
        for (int i = 1; i <= array.length; i++) {
            newNode = new ListNode(array[array.length - i], prev);
            if (i == 1) {
              last = newNode;
            }
            prev = newNode;
        }
        head = new ListNode(999, newNode);
        last.next = head;
    }

    /**
     * Returns true if the list is empty, otherwise returns false.
     *
     * @return  true if the list is empty, otherwise false
     */
    public boolean isEmpty() //from 65 to 73% - 8%
    {
        // Returns true if the list is empty, otherwise returns false.
        // FILL THIS IN.
		
		boolean empty = false;
		
		int size = getSize();
		
		if(size < 1)
		{
			empty = true;
		}
		
		if(size >= 1)
		{
			empty = false;
		}
		
		return empty;
    }
    
    /**
     * Returns the size of the linked list.
     *
     * @return  the size of the linked list
     */
    public int getSize() // from 57 to 65 - 8%
    {
        // Return the size of the linked list.
        // FILL THIS IN.
		
		int instence = 0;	
        int size = 0;
        ListNode traverse = head;
        ListNode current = head.next;
        int cValue = current.data;

            while(instence !=2)
            {
                size++;
                traverse = traverse.next;
                
                if(traverse.data == cValue)
                {
                    instence ++;
                }
            }

        return size-2;
    }

    /**
     * Deletes the node at the given position in the list.
     *
     * @param index the index of the node to delete
     * @return      true on success, false on failure
     */
    public boolean deleteAtPos(int index) //from 42 to 46 % - 4%
    {
        // Delete the node at index `index` in the list. Return true on success, false on failure.
        // FILL THIS IN.	
		
        boolean deleted = false;
        ListNode current = head;

        for(int i = 0; i <= index; i++)
        {
                if(i == index)
                {
                        ListNode toDelete = current.next;
                        
                        current.next = current.next.next;
                        toDelete.next = null;

                        deleted = true;
                        return deleted;
                }
                current = current.next;
        }

        return deleted;
    }

    /**
     * Returns the 1-based index of the first node in the list containing the specified value.
     * 
     * @param value the value to search for
     * @return      the 1-based index of the first node in the list containing the specified value
     */
    public int searchIndex(int value) // from 73 to 76.9 - 4%
    {
        /* Return the ONE-BASED (1-BASED) index of the first node in the list containing `value` as data. If not found,
         * return -1. 
         */
		 
	ListNode node = head.next;
        int index = 1;

        while(node.data != value)
        {
                node = node.next;
                index++;
                
                if(node.data == 999)
                {
                    return -1;
                }
        }

        return index;
    }
}
