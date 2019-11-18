package ads_ica2;

/**
 * Represents a node in a doubly linked list. Do not modify this file.
 *
 * @author Aleksandra Petkova
 * @since 23/04/2017
 */
public class DoublyLinkedListNode
{
    /**
     * Stores the data for the node (an integer value).
     */
    int data;
    
    /**
     * Stores the link to the next node.
     */
    DoublyLinkedListNode next;    
    
    /**
     * Stores the link to the previous node.
     */
    DoublyLinkedListNode prev;

    /**
     * Creates a new empty node.
     */
    public DoublyLinkedListNode()
    {
        data = 0;
        next = null;
        prev = null;
    }

    /**
     * Creates a new node with `data` stored in it.
     *
     * @param data  the data to store in the new node
     */
    public DoublyLinkedListNode(int data)
    {
        this.data = data;
        next = null;
        prev = null;
    }

    /**
     * Creates a new node storing `data` and linked to `next` and `previous`.
     *
     * @param data  the data to store in the new node
     * @param next  the next node in the list
     * @param prev  the previous node in the list
     */
    public DoublyLinkedListNode(int data, DoublyLinkedListNode next, DoublyLinkedListNode prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
