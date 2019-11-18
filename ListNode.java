package ads_ica2;

/**
 * Represents a node in a linked list. Do not modify this file.
 *
 * @author Aleksandra Petkova
 * @since 26/03/2017
 */
public class ListNode
{
    /**
     * Stores the data for the node (an integer value).
     */
    int data;

    /**
     * Stores the link to the next node. This is also sometimes called the node's `tail`.
     */
    ListNode next;

    /**
     * Creates a new empty node.
     */
    public ListNode()
    {
        data = 0;
        next = null;
    }

    /**
     * Creates a new node with `data` stored in it.
     *
     * @param data  the data to store in the new node
     */
    public ListNode(int data)
    {
        this.data = data;
        next = null;
    }

    /**
     * Creates a new node storing `data` and linked to `next`.
     *
     * @param data  the data to store in the new node
     * @param next  the next node in the list
     */
    public ListNode(int data, ListNode next)
    {
        this.data = data;
        this.next = next;
    }
}
