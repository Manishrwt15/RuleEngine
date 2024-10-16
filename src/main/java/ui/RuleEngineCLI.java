package ui;

import api.RuleAPI;
import data.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RuleEngineCLI {
    public static void main(String[] args) {
        RuleAPI api = new RuleAPI();
        Scanner scanner = new Scanner(System.in);

        // Create individual rules
        System.out.println("Creating Rule 1: ((age > 30 AND department = 'Sales')...");
        Node rule1 = api.createRule("age > 30 AND department = 'Sales'");

        System.out.println("Creating Rule 2: (salary > 50000)...");
        Node rule2 = api.createRule("salary > 50000");

        System.out.println("Combining rules with AND operator...");
        Node combinedRule = api.combineRules(rule1, rule2);

        // Test evaluation
        Map<String, Object> data = new HashMap<>();
        data.put("age", 35);
        data.put("department", "Sales");
        data.put("salary", 60000);

        System.out.println("Evaluating eligibility...");
        boolean isEligible = api.evaluateRule(combinedRule, data);
        System.out.println("Eligibility result: " + isEligible);
    }
}
