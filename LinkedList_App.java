package ads_ica2;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/* DO NOT MODIFY THIS FILE. THIS FILE WILL NOT HELP YOU WITH THE ICA. */
   
/**
 * The driver class for the linked list ICA.
 *
 * @author Saul Johnson - Senior Lecturer (saul.johnson@tees.ac.uk)
 * @author Eudes Diemoz - Senior Lecturer (e.diemoz@tees.ac.uk)
 * @since 30/04/2017
 */
public class LinkedList_App
{
    /**
     * Prints the contents of a singly linked list.
     *
     * @param list  the list to print
     */
    private static void printSinglyLinkedList(LinkedList list) 
    {
        System.out.print("List contents: ");
        ListNode current = list.head;
        while (current != null) {
            System.out.print((current == list.head ? "" : ", ") + current.data);
            current = current.next;
        }
        System.out.println();
    }
    
    /**
     * Prints the contents of a doubly linked list.
     *
     * @param list  the list to print
     */
    private static void printDoublyLinkedList(DoublyLinkedList list)
    {
        System.out.print("List contents: ");
        DoublyLinkedListNode current = list.head;
        while (current != null) {
            System.out.print((current == list.head ? "" : ", ") + current.data);
            current = current.next;
        }
        System.out.println();
    }
    
    /**
     * Prints the contents of a circular linked list.
     *
     * @param list  the list to print
     */
    private static void printCircularLinkedList(CircularLinkedList list)
    {
        System.out.print("List contents: ");
        ListNode current = list.head.next;
        while (current != list.head) {
            System.out.print((current == list.head.next ? "" : ", ") + current.data);
            current = current.next;
        }
        System.out.println();
    }
    
    /**
     * Compares a singly linked list to an array of integers.
     *
     * @param list          the list to compare
     * @param expectedData    the data expected to be inside the list
     * @return                true if identical, otherwise false
     */
    private static boolean compareSinglyLinkedList(LinkedList list, int[] expectedData) 
    {
        ListNode current = list.head;
        for (int i = 0; i < expectedData.length; i++) {
            if (current == null || expectedData[i] != current.data) {
                return false;
            }
            current = current.next;
        }
        return current == null;
    }
    
    /**
     * Compares a doubly linked list to an array of integers.
     *
     * @param list          the list to compare
     * @param expectedData    the data expected to be inside the list
     * @return                true if identical, otherwise false
     */
    private static boolean compareDoublyLinkedList(DoublyLinkedList list, int[] expectedData)
    {
        DoublyLinkedListNode current = list.head;
        for (int i = 0; i < expectedData.length; i++) {
            if (current == null || expectedData[i] != current.data) {
                return false;
            }
            current = current.next;
        }
        return current == null;
    }
    
    /**
     * Compares a circular linked list to an array of integers.
     *
     * @param list          the list to compare
     * @param expectedData    the data expected to be inside the list
     * @return                true if identical, otherwise false
     */
    private static boolean compareCircularLinkedList(CircularLinkedList list, int[] expectedData)
    {
        ListNode current = list.head.next;
        for (int i = 0; i < expectedData.length; i++) {
            if (current == list.head || expectedData[i] != current.data) {
                return false;
            }
            current = current.next;
        }
        return current == list.head;
    }
    
    /**
     * Checks if the given doubly linked list is correctly linked.
     *
     * @param list  the list to check
     * @return      true if correctly linked, otherwise false
     */
    private static boolean ensureDoublyLinkedListIntegrity(DoublyLinkedList list)
    {
        DoublyLinkedListNode current = list.head;
        DoublyLinkedListNode previous = null;
        while (current != null) {
            if (previous != null && current.prev != previous) {
                return false;
            }
            previous = current;
            current = current.next;
        }
        return true;
    }
    
    /**
     * Checks if the given circular linked list is correctly linked.
     *
     * @param list  the list to check
     * @return      true if correctly linked, otherwise false
     */
    private static boolean ensureCircularLinkedListIntegrity(CircularLinkedList list)
    {
        ListNode current = list.head.next;
        if (current == list.head) {
            return true;
        }
        
        ArrayList<ListNode> visited = new ArrayList<ListNode>();
        while (current != list.head) {
            if (current == null || visited.contains(current)) {
                return false;
            }
            visited.add(current);
            current = current.next;
        }
        return true;
    }
    
    /**
     * Checks if a value is the last value in a doubly linked list.
     *
     * @param list  the list to search in
     * @param value the value to search for
     * @return      true if the value is last in the list, otherwise false
     */
    private static boolean isLastInDoublyLinkedList(DoublyLinkedList list, int value)
    {
        DoublyLinkedListNode current = list.head;
        if (current == null) {
            return false;
        }
        while (current.next != null) {
            current = current.next;
        }
        return current.data == value;
    }
    
    /**
     * Gets the index of a value in an array.
     *
     * @param arr   the array to search in
     * @param value the value to search for
     * @return      the index of the value in the array, or -1 if not found
     */
    private static int arrayIndexOf(int arr[], int value)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Checks if a value is at the given position in a doubly linked list.
     *
     * @param list  the list to search in
     * @param index the position to check
     * @param value the value to check for
     * @return      true if the value is at the given position, otherwise false
     */
    private static boolean isAtPositionInDoublyLinkedList(DoublyLinkedList list, int index, int value)
    {
        DoublyLinkedListNode current = list.head;
        if (current == null) {
            return false;
        }
        int i = 0;
        while (current.next != null) {
            if (i == index && current.data == value) {
                return true;
            }
            current = current.next;
            i++;
        }
        return false;
    }
    
    /**
     * Checks a singly linked list for a term.
     *
     * @param list    the list to check
     * @param term    the data to search for
     * @return        true if found, otherwise false
     */
    private static boolean singlyLinkedListContains(LinkedList list, int term)
    {
        ListNode current = list.head;
        while (current != null) {
            if (current.data == term) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Returns a random array of integers.
     *
     * @param len    the length of the array to return
     * @return        a random array of integers
     */
    private static int[] randomIntegers(int len) {
        int[] output = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            output[i] = rand.nextInt(Integer.MAX_VALUE);
        }
        return output;
    }
    
    /**
     * Converts a string containing a comma-delimited list of integers into an integer array.
     *
     * @param str    the string to convert
     * @return        the string converted to an integer array
     */
    private static int[] parseIntArray(String str) {
        String[] split = str.split(",");
        int[] out = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            out[i] = Integer.parseInt(split[i].trim());
        }
        return out;
    }
    
    /**
     * Gets an integer read from the next input line.
     *
     * @param input the scanner to read from
     * @return      the integer that was read
     */
    private static int getInt(Scanner input) {
        return Integer.parseInt(input.nextLine());
    }
   
    /**
     * Returns a reversed array of integers as a comma-separated string.
     *
     * @param array the array to reverse and stringify
     * @return      the string representation of the array
     */
    private static String reverseStringify(int[] array) {
        String str = "";
        for (int i = array.length - 1; i >= 0; i--) {
            str += array[i] + (i == 0 ? "" : ", ");
        }
        return str;
    }
   
    /**
     * Eliminates the given index in the array.
     *
     * @param array the array to modify
     * @param index the index to eliminate
     * @return      the array with the value at the given index eliminated
     */
    private static int[] eliminateIndex(int[] array, int index) {
        int[] result = new int[array.length - 1];
        int i = 0;
        int j = 0;
        while (i < array.length) {
            if (i != index) {
                result[j] = array[i];
                j++;
            }
            i++;
        }
        return result;
    }
    
    /**
     * Tests the singly linked list.
     *
     * @param input    the scanner to use to recieve input
     */
    private static void testSinglyLinkedList(Scanner input) 
    {
        System.out.println("Starting assessment of singly linked list...");        
                
        // List is empty, head should be null.
        LinkedList subject = new LinkedList(); // Initialise list.
        if (subject.head == null) {
            System.out.println("Singly linked list initially has a null head, as expected.");
        } else {
            System.out.println("Empty singly linked list does not have a null head. Please don't modify any"
                + " constructors.");
        }        
        
        // Get list contents from input.
        System.out.println("Please enter a comma-separated list of integers to populate the list:");
        int[] data = parseIntArray(input.nextLine());
        
        // Constructor should correctly add data.
        subject = new LinkedList(data); // Reset list.
        if (subject.head == null || !compareSinglyLinkedList(subject, data)) {
            System.out.println("Singly linked list constructor is not working properly. Please do not modify any"
                + " constructors.");
        } else {
            printSinglyLinkedList(subject); // Show list so student can see it.
        }
        
        // Pause.
        System.out.println("Press enter to continue...");
        input.nextLine();
        
        // Test getFirst() method by itself.
        System.out.println("Testing getFirst() method...");
        int actual_1 = subject.getFirst();
        int expected_1 = (data.length >= 1) ? data[0] : 999;
        if (actual_1 == expected_1) {
            System.out.println("Great, getFirst() correctly returned the value " + actual_1 + " from the list.");
        } else {
            System.out.println("Oops, getFirst() returned the value " + actual_1 + " from the list when the"
                + " value " + expected_1 + " was expected");
        }
        
        // Test addFirst() method by itself.
        subject = new LinkedList(data); // Reset list.
        System.out.println("Testing addFirst() method...");
        System.out.println("Please enter the new number to add:");
        int expected_2 = getInt(input);
        subject.addFirst(expected_2);
        int actual_2 = subject.head.data;
        if (actual_2 == expected_2) {
            System.out.println("Great, addFirst() correctly added the value " + actual_2 + " to the start of the"
                + " list.");
        } else {
            System.out.println("Oops, addFirst() didn't seem to add the value " + expected_2 + " at the start of the"
                + " list.");
            printSinglyLinkedList(subject); // Show list so student can fix error.
        }
        
        // Test getAtPos(int index) by itself.
        subject = new LinkedList(data); // Reset list.
        System.out.println("Testing getAtPos(int index) method...");
        System.out.println("Please enter the index of the node to get:");
        int index = getInt(input);
        int actual_3 = subject.getAtPos(index);
        int expected_3 = (index >= 0) && (data.length > index) ? data[index] : 999;
        if (actual_3 == expected_3) {
            System.out.println("Great, getAtPos(" + index + ") correctly returned the value " + actual_3 + " from the"
                + " list.");
        } else {
            System.out.println("Oops, getAtPos(" + index + ") returned the value " + actual_3 + " from the list when"
                + " the value " + expected_3 + " was expected.");
        }
        
        // Test searchPointer(int value) by itself.
        subject = new LinkedList(data); // Reset list.
        System.out.println("Testing searchPointer(int value) method...");
        System.out.println("Please enter the data to search for:");
        int term = getInt(input);
        ListNode actual_4 = subject.searchPointer(term);
        if (singlyLinkedListContains(subject, term)) {
            if (actual_4 != null && actual_4.data == term) {
                System.out.println("Great, searchPointer(" + term + ") correctly returned the node containing " + term
                    + " from the list.");
            } else {
                System.out.println("Oops, searchPointer(" + term + ") returned " 
                    + (actual_4 == null ? "null" : "a node containing " + actual_4.data) + " from the list when a "
                    + "node containing " + term + " was expected.");
            }
        } else {
            if (actual_4 == null) {
                System.out.println("Great, searchPointer(" + term + ") correctly returned null because the data " + term
                    + " is not in the list.");
            } else {
                System.out.println("Oops, searchPointer(" + term + ") returned a node containing " + actual_4.data 
                    + " from the list when null was expected.");
            }
        }
    }
    
    /**
     * Tests the doubly linked list.
     *
     * @param input    the scanner to use to recieve input
     */
    private static void testDoublyLinkedList(Scanner input) 
    {
        System.out.println("Starting assessment of doubly linked list...");        
                
        // List is empty, head should be null.
        DoublyLinkedList subject = new DoublyLinkedList(); // Initialise list.
        if (subject.head == null) {
            System.out.println("Doubly linked list initially has a null head, as expected.");
        } else {
            System.out.println("Empty doubly linked list does not have a null head. Please don't modify any"
                + " constructors.");
        }        
        
        // Get list contents from input.
        System.out.println("Please enter a comma-separated list of integers to populate the list:");
        int[] data = parseIntArray(input.nextLine());
        
        // Constructor should correctly add data.
        subject = new DoublyLinkedList(data); // Reset list.
        if (subject.head == null 
            || !compareDoublyLinkedList(subject, data) 
            || !ensureDoublyLinkedListIntegrity(subject)) { // Check for broken links.
            System.out.println("Doubly linked list constructor is not working properly. Please do not modify any"
                + " constructors.");
        } else {
            printDoublyLinkedList(subject); // Show list so student can see it.
        }
        
        // Pause.
        System.out.println("Press enter to continue...");
        input.nextLine();
        
        // Test getLast() method by itself.
        System.out.println("Testing getLast() method...");
        int actual_1 = subject.getLast();
        int expected_1 = (data.length >= 1) ? data[data.length - 1] : 999;
        if (actual_1 == expected_1) {
            System.out.println("Great, getLast() correctly returned the value " + actual_1 + " from the list.");
        } else {
            System.out.println("Oops, getLast() returned the value " + actual_1 + " from the list when the"
                + " value " + expected_1 + " was expected");
        }
        
        // Test addLast() method by itself.
        subject = new DoublyLinkedList(data); // Reset list.
        System.out.println("Testing addLast() method...");
        System.out.println("Please enter the new number to add:");
        int expected_2 = getInt(input);
        subject.addLast(expected_2);
        if (isLastInDoublyLinkedList(subject, expected_2)) {
            System.out.println("Great, addLast() correctly added the value " + expected_2 + " to the end of the list.");
        } else {
            System.out.println("Oops, addLast() didn't seem to add the value " + expected_2 + " at the end of the"
                + " list.");
            printDoublyLinkedList(subject); // Show list so student can fix error.
        }
        if (!ensureDoublyLinkedListIntegrity(subject)) { // Check for broken links.
            System.out.println("Oops, your doubly linked list is no longer linked correctly in both directions!");
        }
        
        // Test addAfterPos(int data, int index) by itself.
        subject = new DoublyLinkedList(data); // Reset list.
        System.out.println("Testing addAfterPos(int data, int index) method...");
        System.out.println("Please enter the new value to insert:");
        int dataToInsert = getInt(input);
        System.out.println("Please enter the index to insert the new value at:");
        int index = getInt(input);
        boolean success = subject.addAfterPos(dataToInsert, index);
        boolean successExpected = (index > 0) && (index <= data.length);
        if (successExpected) {
            if (success) {
                if (isAtPositionInDoublyLinkedList(subject, index, dataToInsert)) {
                    System.out.println("Great, addAfterPos(" + dataToInsert + ", " + index + ") added the right data at the right"
                    + " position.");
                } else {
                    System.out.println("Oops, addAfterPos(" + dataToInsert + ", " + index + ") doesn't seem to have added the data"
                    + " at the correct position.");
                    printDoublyLinkedList(subject);
                }
            } else {
                System.out.println("Oops, addAfterPos(" + dataToInsert + ", " + index + ") returned false even though index is"
                    + " in range.");
            }
        } else {
            if (success) {
                System.out.println("Oops, addAfterPos(" + dataToInsert + ", " + index + ") returned true even though index is"
                    + " out of range.");
            } else {
                System.out.println("Great, addAfterPos(" + dataToInsert + ", " + index + ") returned false because the index is"
                    + " out of range.");
            }
        }
        if (!ensureDoublyLinkedListIntegrity(subject)) { // Check for broken links.
            System.out.println("Oops, your doubly linked list is no longer linked correctly in both directions!");
        }
        
        // Pause.
        System.out.println("Press enter to continue...");
        input.nextLine();
        
        // Test toString_in_reverse() by itself.
        subject = new DoublyLinkedList(data); // Reset list.
        System.out.println("Testing toString_in_reverse() method...");
        String actual_3 = subject.toString_in_reverse();
        String expected_3 = reverseStringify(data);
        if (actual_3 == null) {
            System.out.println("Oops, toString_in_reverse() returned null! It should never do that. For an empty list,"
                + " return an empty string.");
        } else if (actual_3.equals(expected_3)) {
            System.out.println("Great, toString_in_reverse() works as expected.");
        } else {
            System.out.println("Oops, toString_in_reverse() is not working as expected.");
            System.out.println("Expected output: " + expected_3);
            System.out.println("Your output: " + actual_3);
        }
    }
    
    /**
     * Tests the circular linked list.
     *
     * @param input    the scanner to use to recieve input
     */
    private static void testCircularLinkedList(Scanner input) 
    {
        System.out.println("Starting assessment of circular linked list...");        
                
        // List is empty, sentinel node should be present.
        CircularLinkedList subject = new CircularLinkedList(); // Initialise list.
        if (subject.head != null) {
            System.out.println("Circular linked list initially has a sentinel node, as expected.");
        } else {
            System.out.println("Empty doubly linked list does not have a sentinel node. Please don't modify any"
                + " constructors.");
        }
        
        // Pause.
        System.out.println("Press enter to continue...");
        input.nextLine();
        
        // Test isEmpty() when list is empty.
        System.out.println("Testing isEmpty() method when list is empty...");
        if (!subject.isEmpty()) {
            System.out.println("Oops, method isEmpty() returned false when list is actually empty!");
        } else {
            System.out.println("Great, method isEmpty() returned true when list is empty.");
        }
        
        // Get list contents from input.
        System.out.println("Please enter a comma-separated list of integers to populate the list:");
        int[] data = parseIntArray(input.nextLine());
        
        // Constructor should correctly add data.
        subject = new CircularLinkedList(data); // Reset list.
        if (subject.head == null 
            || !compareCircularLinkedList(subject, data) 
            || !ensureCircularLinkedListIntegrity(subject)) { // Check for broken circle.
            System.out.println("Circular linked list constructor is not working properly. Please do not modify any"
                + " constructors.");
        } else {
            printCircularLinkedList(subject); // Show list so student can see it.
        }
        
        // Pause.
        System.out.println("Press enter to continue...");
        input.nextLine();
        
        // Test isEmpty() when list is not empty.
        System.out.println("Testing isEmpty() method when list not empty...");
        if (subject.isEmpty()) {
            System.out.println("Oops, method isEmpty() returned true when list is actually not empty!");
        } else {
            System.out.println("Great, method isEmpty() returned false when list is not empty.");
        }
        
        // Pause.
        System.out.println("Press enter to continue...");
        input.nextLine();
        
        // Test getSize() by itself.
        subject = new CircularLinkedList(data); // Reset list.
        System.out.println("Testing getSize() method...");
        int actual = subject.getSize();
        if (actual == data.length) {
            System.out.println("Great, method getSize() returned the correct value " + actual + ".");
        } else {
            System.out.println("Oops, method getSize() returned the incorrect value " + actual + " when it "
                + "should be " + data.length);
        }
        
        // Test deleteAtPos(int index) by itself.
        subject = new CircularLinkedList(data); // Reset list.
        System.out.println("Testing deleteAtPos(int index) method...");
        System.out.println("Please enter the index to delete the node at:");
        int pos = getInt(input);
        boolean expectedResult = (pos >= 0) && (pos < data.length);
        boolean result = subject.deleteAtPos(pos);
        if (expectedResult) {
            if (result) {
                int[] expectedArr = eliminateIndex(data, pos);
                if (compareCircularLinkedList(subject, expectedArr)) {
                    System.out.println("Great, the correct value was deleted from the list.");
                } else {
                    System.out.println("Oops, doesn't look like the correct value was deleted form the list!");
                    printCircularLinkedList(subject); // Show list so student can fix error.
                }
            } else {
                System.out.println("Oops, deleteAtPos(" + pos + ") returned false even when it should have worked!");
                printCircularLinkedList(subject); // Show list so student can fix error.
            }
        } else {
            if (result) {
                System.out.println("Oops, deleteAtPos(" + pos + ") returned true even though the index was out of"
                    + " bounds!");
            } else {
                System.out.println("Great, deleteAtPos(" + pos + ") returned false because the index was out of"
                    + " bounds!");
            }
        }
        if (!ensureCircularLinkedListIntegrity(subject)) { // Check for broken circle.
            System.out.println("Oops, your circular linked list is no longer circular!");
        }
        
        // Test searchIndex(int value) by itself.
        subject = new CircularLinkedList(data); // Reset list.
        System.out.println("Testing searchIndex(int value) method...");
        System.out.println("Please enter the value to search for:");
        int term = getInt(input);
        int expected = arrayIndexOf(data, term);
        expected += (expected == -1 ? 0 : 1);
        actual = subject.searchIndex(term);
        if (expected == actual) {
            System.out.println("Great, searchIndex(" + term + ") returned " + actual + "!");
        } else {
            System.out.println("Oops, searchIndex(" + term + ") returned " + actual + " and not " + expected + "!");
            printCircularLinkedList(subject);
        }
    }
    
    /**
     * The main method for the linked list app.
     *
     * @param args  the program's command-line arguments
     */
    public static void main(String[] args)
    {
        // Initialise scanner.
        Scanner input = new Scanner(System.in);
        
        // Test methods.
        testSinglyLinkedList(input);
        testDoublyLinkedList(input);
        testCircularLinkedList(input);
    }
}
