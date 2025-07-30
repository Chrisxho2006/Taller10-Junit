/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorsmp;

import java.util.Stack;

/**
 *
 * @author Djurado
 */
public class Operations {

    private static String[] op = { "+", "-", "*", "/" };// Operation set

    public static String MakeFormula() {
        System.out.println("git modify");
        StringBuilder build = new StringBuilder();
        int count = (int) (Math.random() * 2) + 1; // generate random count
        int start = 0;
        int number1 = (int) (Math.random() * 99) + 1;
        build.append(number1);
        while (start <= count) {
            int operation = (int) (Math.random() * 3); // generate operator
            int number2 = (int) (Math.random() * 99) + 1;
            build.append(op[operation]).append(number2);
            start++;
        }
        return build.toString();
    }

    public static String Solve(String formula) {
        Stack<String> tempStack = new Stack<>();// Store number or operator
        Stack<Character> operatorStack = new Stack<Character>();// Store operator

        StringBuilder numberBuffer = new StringBuilder();
        for (char formulaChar : formula.toCharArray()) {
            if (Character.isDigit(formulaChar)) {
                numberBuffer.append(formulaChar);
            } else { // It's an operator
                tempStack.push(numberBuffer.toString());
                numberBuffer.setLength(0); // Clear the buffer

                while (!operatorStack.isEmpty()
                        && ((operatorStack.peek() == '*' || operatorStack.peek() == '/')
                                || (formulaChar == '+' || formulaChar == '-'))) {
                    tempStack.push(operatorStack.pop().toString());
                }
                operatorStack.push(formulaChar);
            }
        }
        tempStack.push(numberBuffer.toString()); // Push the last number

        while (!operatorStack.empty()) { // Append remaining operators
            tempStack.push(operatorStack.pop().toString());
        }

        Stack<String> calcStack = new Stack<>();

        for (int i = 0; i < tempStack.size(); i++) {
            String peekChar = tempStack.get(i);
            if (!peekChar.equals("+") && !peekChar.equals("-") && !peekChar.equals("/") && !peekChar.equals("*")) {
                calcStack.push(peekChar); // Push number to stack
            } else {
                int a1 = 0;
                int b1 = 0;
                if (!calcStack.empty()) {
                    b1 = Integer.parseInt(calcStack.pop());
                }
                if (!calcStack.empty()) {
                    a1 = Integer.parseInt(calcStack.pop());
                }
                switch (peekChar) {
                    case "+":
                        calcStack.push(String.valueOf(a1 + b1));
                        break;
                    case "-":
                        calcStack.push(String.valueOf(a1 - b1));
                        break;
                    case "*":
                        calcStack.push(String.valueOf(a1 * b1));
                        break;
                    default:
                        calcStack.push(String.valueOf(a1 / b1));
                        break;
                }
            }
        }
        return formula + "=" + calcStack.pop();
    }

}