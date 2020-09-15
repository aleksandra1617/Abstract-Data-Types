package ads_ica2;

/**
 * Represents a linked list.
 * 
 * @author Aleksandra Petkova
 * @since 26/03/2017
 */
public class LinkedList
{
    /**
     * Stores the first node in the list.
     */
    ListNode head;

    /**
     * Creates a new linked list.
     */
    public LinkedList()
    {
        /* We want to create an empty list. An empty list has a null `head` (that is, 0 elements). This method is given 
           to you. Do not modify it. */
           
        head = null;
    }
    
    /**
     * Creates a new linked list from an existing array.
     *
     * @param array the array to create the new linked list from
     */
    public LinkedList(int[] array)
    {
        /* We need to loop over the array of integers given to us in `array` and add them as list nodes, one at a time. 
           This method is given to you. Do not modify it. */
           
        for (int i = array.length - 1; i >= 0; i--)
        {
            head = new ListNode(array[i], head);
        }
    }

    /**
     * Adds a node containing the given data at the beginning of this list.
     *
     * @param data  the data to add
     */
    public void addFirst(int data)
    {
        // Add a node at the beginning of the list.
        // FILL THIS IN.
		
	if(head == null) 
        {
            head = new ListNode(data);
        }
	else
	{
            ListNode newNode = new ListNode(data);
            newNode.next = head; 
            head = newNode;
        }
    }

    /**
     * Returns the first value in this list.
     *
     * @return  the first value in this list
     */
	 
    public int getFirst()
    {
        // Retrieve the data stored in the first node of the list, if it exists. Otherwise return 999.
        // FILL THIS IN.
		
	return head.data;
    }

    /**
     * Returns the value stored at the given index in the list.
     *
     * @param index the index to retrieve the value at
     * @return      the value stored at the given index in the list
     */
    public int getAtPos(int index) //from 46 to 50% - 4%
    {
        // Retrieve the data in the node located at position `index`, if it exists. Otherwise return 999.
        // FILL THIS IN.
		
		
        ListNode current = head;
            
	for (int i = 0; i <= index; i++) 
	{
	     if(i == index)
	     {
		 return current.data;   
             } 
             else if(current.next == null)
             {
                 return 999;
             }
                 current = current.next;
	}
       
        return 999;
    }

    /**
     * Returns the first node containing the desired value.
     *
     * @param value the value to search for
     * @return      the first node containing the desired value
     */
    public ListNode searchPointer(int value) //from 30 to 38% - 8
    {
        // Return the first node containing `value`. If not found, return null.
        // FILL THIS IN.
		
	ListNode node = head;
        
        while(node.data != value && node.next != null)
        {
	    node = node.next;  
        }
        
        if(node.next == null)
        {
            return null;
        }

        return node;
    }
}
