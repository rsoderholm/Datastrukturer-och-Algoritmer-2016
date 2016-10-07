import javax.swing.*;
import java.util.Scanner;

/**
 * The stack I implemented for this assignment.
 * Created by Robin on 2016-09-07.
 */
public class Stack {

    private ListNode firstNode;
    private int size = 0;

    /**
     * Pushes object to stack. New Object goes to the top of the stack.
     *
     * @param dataIn
     */
    public void push(Object dataIn) {
        firstNode = new ListNode(dataIn, firstNode);
        size++;

    }


    /**
     * Removes the object you last put in from the stack.
     *
     * @return
     */
    public Object pop() {

        if (size > 0) {
            ListNode node = firstNode;
            firstNode = firstNode.getNext();
            size--;
            return node.getData();
        } else
            return null;
    }


    /**
     * Let's you look at the last object put in without removing it from the stack.
     *
     * @return
     */
    public Object peek() {
        if (firstNode == null) {
            return null;
        } else {
            return firstNode.getData();
        }


    }

    /**
     * Returns the size of the stack.
     *
     * @return
     */
    public int size() {
        return size;
    }

    public void emptyStack() {
        size = 0;
    }

    /**
     * Returns true if the stack is empty. False if it contains data.
     *
     * @return
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }


}














