/**
 * The ListNode class is a representation of the nodes in our stack.
 * Created by Robin on 2016-09-07.
 */
public class ListNode {

    private ListNode next;
    private Object data;


    /**
     * Initializes a new instance of the ListNode class.
     *
     * @param DataValue > The data
     * @param nextNode  > The node
     */
    public ListNode(Object DataValue, ListNode nextNode) {
        data = DataValue;
        next = nextNode;

    }


    /**
     * Returns the data currently in the node.
     *
     * @return
     */
    public Object getData() {
        return data;

    }

    /**
     * Returns the next node in stack.
     * @return
     */
    public ListNode getNext() {
        return next;
    }


}
