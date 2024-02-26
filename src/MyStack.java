import java.util.Stack;

public class MyStack {
    // a. Реализация обратной польской записи
    public String convertToPostfix(String input) {
        Stack<Character> operators = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        boolean digitFlag = false;

        for (char c : input.toCharArray()) {
            if (c == ' ') {
                continue; // пропускаем пробелы
            } else if (Character.isDigit(c)) {
                if (digitFlag) {
                    postfix.append(c);
                } else {
                    digitFlag = true;
                    postfix.append(" ").append(c);
                }
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    postfix.append(" ").append(operators.pop());
                }
                operators.pop();
                digitFlag = false;
            } else {
                while (!operators.isEmpty() && getPrecedence(c) <= getPrecedence(operators.peek())) {
                    postfix.append(" ").append(operators.pop());
                }
                operators.push(c);
                digitFlag = false;
            }
        }

        while (!operators.isEmpty()) {
            postfix.append(" ").append(operators.pop());
        }

        return postfix.toString();
    }

    public int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.equals("")) {
                continue;
            }
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public int getPrecedence(char operator) {
        switch(operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    // e. Балансировка скобок

    public boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == ']' || current == '}') {
                if (stack.isEmpty()) {
                    return false; // нет открывающей скобки
                }

                char top = stack.pop();
                if ((current == ')' && top != '(') ||
                        (current == ']' && top != '[') ||
                        (current == '}' && top != '{')) {
                    return false; // скобки не согласованы
                }
            }
        }

        return stack.isEmpty();
    }
}