package api;

import backend.RuleEngine;
import data.Node;
import java.util.Map;

public class RuleAPI {
    private final RuleEngine engine = new RuleEngine();

    public Node createRule(String ruleString) {
        return engine.createRule(ruleString);
    }

    public Node combineRules(Node rule1, Node rule2) {
        return engine.combineRules(rule1, rule2);
    }

    public boolean evaluateRule(Node node, Map<String, Object> data) {
        return engine.evaluateRule(node, data);
    }
}
