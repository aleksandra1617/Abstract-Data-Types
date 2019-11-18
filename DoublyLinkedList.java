package ads_ica2;


/**
 * Represents a doubly linked list.
 * 
 * @author Aleksandra Petkova
 * @since 23/04/2017
 */
public class DoublyLinkedList
{
    /**
     * Stores the first node in the list.
     */
    DoublyLinkedListNode head;

    /**
     * Creates a new doubly linked list.
     */
    public DoublyLinkedList()
    {
        /* We want to create an empty list. An empty list has a null `head` (that is, 0 elements). This method is given 
           to you. Do not modify it. */
           
        head = null;
    }
      
    /**
     * Creates a new doubly linked list from an existing array.
     *
     * @param array the array to create the new linked list from
     */
    public DoublyLinkedList(int[] array)
    {
        /* We need to loop over the array of integers given to us in `array` and add them as list nodes, one at a time. 
           This method is given to you. Do not modify it. */
           
        for (int i = array.length - 1; i >= 0; i--)
        {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(array[i], head, null);
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        }
    }

    /**
     * Adds a node containing the given data at the end of this list.
     *
     * @param data  the data to add
     */
    public void addLast(int data)  //no change in grade
    {
        // Add a node at the end of the list.
        // FILL THIS IN.
        
        DoublyLinkedListNode current = head;
        
        
        while(current.next != null)
        {
            current = current.next;
        }
       
            
        if(current.next == null)
        {
            DoublyLinkedListNode last = new DoublyLinkedListNode(data);
            current.next = last;
			last.prev = current;
        }
    }

    /**
     * Returns the last value in this list.
     *
     * @return  the last value in this list
     */
    public int getLast() //got form 27 to 30 % - 3%
    {
        // Retrieve the data stored in the last node of the list, if it exists. Otherwise return 999.
        // FILL THIS IN.
		
	    DoublyLinkedListNode current = head;
	    
	    if(head.next == null)
	    {
			return 999;
	    }else{
            
			while(current.next != null)
			{
				current = current.next;
			}
        }
        return current.data;
    }

    /**
     * Adds a containing the given data after the given position index in the list.
     *
     * @param data  the data to add
     * @param index the index to add the new node after
     * @return      true on successful insert, otherwise false
     */
    public boolean addAfterPos(int data, int index) //38 to 42 % - 4%
    {
        // Adds a node after position `index`, if it exists, and returns true. Returns false on failure.
        // FILL THIS IN.
		
		boolean added = false;
		
        DoublyLinkedListNode current = head;
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        DoublyLinkedListNode holder ;
        
        for(int i = 1; i <= index; i++)
        {
            
            if(i == index)
            {            

                    holder = current.next;

                    newNode.next = holder;
                    holder.prev = newNode;
                    newNode.prev = current;
                    current.next = newNode;

                    return added = true;
            }
            
            if(current == null)
            {
                return added;
            }
            
            current = current.next;
        }


        return added;
    }
    
    /**
     * Returns a string with the data of all nodes starting from the last node.
     *
     * @return  the list reversed, represented as a comma-separated string
     */
    public String toString_in_reverse() //from 50 to 57% - 7%
    {
        // Returns a string with the data of all nodes starting from the last node. 
        // FILL THIS IN.
		
		String reversedData = "";
		
        DoublyLinkedListNode current = head;
		
		
            while(current.next != null)
            {
                    current = current.next;
			}
		
            if(current.next == null)
            {
                reversedData += current.data + ", ";
                
            }
		
            while(current.prev != null)
            {
                    current = current.prev;
                    if(current.prev == null)
                    {
                        reversedData += current.data;
                    } else{
                        reversedData += current.data+ ", ";
                    }
            }

		return reversedData;
    }
} 
