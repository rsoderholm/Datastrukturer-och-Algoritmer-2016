
public class TreeNode {
    /**
     * @author RobinSoderholm
     */
    private int data;
    private TreeNode left;
    private TreeNode right;

    /**
     * Constructor
     *
     * @param data
     */
    public TreeNode(int data) {
        this.data = data;

    }



    public void setData(int data) {
        this.data = data;
    }

    /**
     * sets leftchild to specified node
     *
     * @param newLeft
     */
    public void setLeft(TreeNode newLeft) {
        this.left = newLeft;
    }

    /**
     * Sets rightchild to specified node.
     *
     * @param newRight
     */
    public void setRight(TreeNode newRight) {
        this.right = newRight;
    }

    /**
     * @return returns node data
     */
    public int getData() {
        return data;
    }

    /**
     * @return Returns left child
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * @return Returns right child
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Prints tree
     */
    public void printTree() {
        if (this.right != null) {
            right.printTree(true, "");
        }
        printNodeValue();
        if (this.left != null) {
            left.printTree(false, "");
        }
    }

    /**
     * Prints tree
     */
    private void printTree(boolean isRight, String indent) {
        if (right != null) {
            right.printTree(true, indent + (isRight ? "      " : " |    "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("-----");
        printNodeValue();
        if (left != null) {
            left.printTree(false, indent + (isRight ? " |    " : "      "));
        }
    }

    /**
     * Prints value of node
     */
    private void printNodeValue() {
        System.out.print(data);
        System.out.print("\n");
    }

}