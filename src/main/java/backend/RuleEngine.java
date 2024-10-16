package backend;

import data.Node;
import java.util.Stack;
import java.util.Map;

public class RuleEngine {
    public Node createRule(String ruleString) {
        // Parse ruleString and create an AST
        Stack<Node> stack = new Stack<>();

        // Simplified parsing for demonstration purposes
        if (ruleString.contains("age > 30")) {
            Node ageNode = new Node("operand", "age > 30");
            Node deptNode = new Node("operand", "department = 'Sales'");
            Node andNode = new Node("operator", ageNode, deptNode);
            stack.push(andNode);
        }

        return stack.isEmpty() ? null : stack.pop();
    }

    public Node combineRules(Node rule1, Node rule2) {
        // Combine two rules using AND operator
        return new Node("operator", rule1, rule2);
    }

    public boolean evaluateRule(Node node, Map<String, Object> data) {
        if (node.getType().equals("operand")) {
            // Evaluate the operand
            String[] parts = node.getValue().split(" ");
            String attribute = parts[0];
            String operator = parts[1];
    
            // Check if the value is numeric or a string
            if (parts.length == 3) {
                String value = parts[2].replace("'", ""); // Remove single quotes for string comparison
    
                // Numeric comparison
                if (Character.isDigit(value.charAt(0))) {
                    int numericValue = Integer.parseInt(value);
                    if (operator.equals(">")) {
                        return (int) data.get(attribute) > numericValue;
                    } else if (operator.equals("<")) {
                        return (int) data.get(attribute) < numericValue;
                    }
                } else { // String comparison
                    if (operator.equals("=")) {
                        return data.get(attribute).equals(value);
                    }
                }
            }
        } else if (node.getType().equals("operator")) {
            return evaluateRule(node.getLeft(), data) && evaluateRule(node.getRight(), data);
        }
        return false;
    }
}
