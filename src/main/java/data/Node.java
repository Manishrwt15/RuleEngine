package data;

public class Node {
    private String type;    // "operator" or "operand"
    private Node left;
    private Node right;
    private String value;   // for operands, e.g., condition like "age > 30"

    // Constructor for operator nodes
    public Node(String type, Node left, Node right) {
        if (type == null || left == null || right == null) {
            throw new IllegalArgumentException("Type, left, and right cannot be null");
        }
        this.type = type;
        this.left = left;
        this.right = right;
        this.value = null; // For operator nodes, value is not used
    }

    // Constructor for operand nodes
    public Node(String type, String value) {
        if (type == null || value == null) {
            throw new IllegalArgumentException("Type and value cannot be null");
        }
        this.type = type;
        this.value = value;
        this.left = null;  // No children for operand nodes
        this.right = null;
    }

    // Getters
    public String getType() {
        return type;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String getValue() {
        return value;
    }

    // Setters
    public void setLeft(Node left) {
        if (left == null) {
            throw new IllegalArgumentException("Left node cannot be null");
        }
        this.left = left;
    }

    public void setRight(Node right) {
        if (right == null) {
            throw new IllegalArgumentException("Right node cannot be null");
        }
        this.right = right;
    }
}
