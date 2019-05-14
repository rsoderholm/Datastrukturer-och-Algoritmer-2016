
public class BinaryTree {
    /**
     * @author RobinSoderholm
     */

    /**
     * This class is to be regarded as the blueprint for the BST. It contains all methods needed for
     * the operations asked for in the assignment. See method comments for more information.
     */
    protected TreeNode root;
    protected int size;

    /**
     * Constructor for the tree. Size is 0.
     */
    public BinaryTree() {
        size = 0;
    }

    /**
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Prints tree
     */
    public void printTree() {
        root.printTree();
    }

    /**
     * Adds the value to the tree.
     *
     * @param data
     */
    public void add(int data) {
        try {
            root = insert(root, new TreeNode(data));
            size++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add method uses this to recursively add nodes to the tree
     *
     * @param
     * @param
     * @return new root
     * @throws Exception
     */
    private TreeNode insert(TreeNode current, TreeNode newNode) throws Exception {
        if (current == null) {
            return newNode;
        } else if (current.getData() == newNode.getData()) {
            throw new Exception(newNode.getData() + " Value already in tree");
        } else if (current.getData() > newNode.getData()) {
            current.setLeft(insert(current.getLeft(), newNode));
        } else if (current.getData() < newNode.getData()) {
            current.setRight(insert(current.getRight(), newNode));
        }
        return current;
    }


    /**
     * finds the node with the specified value.
     *
     * @param current
     * @param data
     * @return the node which contains value
     */
    public TreeNode find(TreeNode current, int data) {
        if (current == null) {
            return null;
        } else if (current.getData() == data) {
            return current;
        } else if (current.getData() > data) {
            return find(current.getLeft(), data);
        } else if (current.getData() < data) {
            return find(current.getRight(), data);
        }
        return null;

    }

    /**
     * Prints the tree in order, from root.
     *
     * @param current
     */
    public void inOrder(TreeNode current) {
        if (current == null) {
            inOrder(root);
        } else {
            if (current.getLeft() != null) {
                inOrder(current.getLeft());
            }
            System.out.println(current.getData());
            if (current.getRight() != null) {
                inOrder(current.getRight());
            }
        }
    }

    /**
     * Finds parent node for child. Starts with current.
     *
     * @param current
     * @param child
     * @return returns parent or null if the node doesn't have a parent or if it can't be found in the tree
     */
    protected TreeNode findParent(TreeNode current, TreeNode child) {
//		System.out.println("current:   "  + current.getData() + "     child:  " + child.getData());
        if (child == null) {
            return null;
        } else if (current.getData() > child.getData()) {
            if (current.getLeft() == child) {
                return current;
            } else {
                return findParent(current.getLeft(), child);
            }
        } else if (current.getData() < child.getData()) {
            if (current.getRight() == child) {
                return current;
            } else {
                return findParent(current.getRight(), child);
            }
        }
        return null;
    }

    /**
     * Removes value if it can be found in the tree.
     *
     * @param data
     */
    public void delete(int data) {

        TreeNode temp = remove(root, data);
        if (temp != null) {
            root = temp;
            size--;
        }
    }


    /**
     * Removes data from tree
     *
     * @param current
     * @param dataToRemove
     * @return The root for the new tree or subtree.
     */
    private TreeNode remove(TreeNode current, int dataToRemove) {
        TreeNode nodeToRemoveDataFrom = find(current, dataToRemove);
        System.out.println(nodeToRemoveDataFrom.getData());
        if (nodeToRemoveDataFrom != null) {
            TreeNode successor = findSuccessor(nodeToRemoveDataFrom);
            TreeNode successorParent = findParent(current, successor);
            if (successorParent == nodeToRemoveDataFrom) {
                if (nodeToRemoveDataFrom.getData() < successor.getData()) {
                    nodeToRemoveDataFrom.setRight(successor.getRight());
                    if (nodeToRemoveDataFrom.getLeft() == null) {
                        nodeToRemoveDataFrom.setLeft(successor.getLeft());
                    }
                } else {
                    nodeToRemoveDataFrom.setRight(successor.getRight());
                    nodeToRemoveDataFrom.setLeft(successor.getLeft());
                }
            } else if (successorParent.getLeft() != null) {
                successorParent.setLeft(successor.getRight());
            } else if (successor == nodeToRemoveDataFrom) {
                if (successorParent.getData() > successor.getData()) {
                    successorParent.setLeft(null);
                } else {
                    successorParent.setRight(null);
                }
            }
            nodeToRemoveDataFrom.setData(successor.getData());
        }
        return current;
    }

    /**
     * Returns successor of current
     *
     * @param current
     * @return The successor of the current node
     */
    protected TreeNode findSuccessor(TreeNode current) {
        TreeNode successor;
        if (current == null) {
            successor = null;
        } else if (current.getRight() != null) {
            if (current.getLeft() == null) {
                successor = current.getRight();
            } else {
                successor = getMinimum(current.getRight());
            }
        } else if (current.getLeft() != null) {
            successor = current.getLeft();
        } else {
            successor = current;
        }
        return successor;
    }

    /**
     * Returns minimum value e.g. the leftmost child.
     *
     * @param current
     * @return The minimum value of the tree with current as root.
     */
    private TreeNode getMinimum(TreeNode current) {
        if (current.getLeft() != null) {
            return getMinimum(current.getLeft());
        } else {
            return current;
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(4);
        bt.add(3);
        bt.add(7);
        bt.add(2);
        bt.add(14);
        bt.add(14);
        bt.add(1);
        bt.add(16);
        bt.add(0);
        bt.printTree();
        bt.delete(16);
        bt.delete(1);
        bt.printTree();
        bt.inOrder(null);
        bt.delete(4);
        bt.printTree();
    }
}

