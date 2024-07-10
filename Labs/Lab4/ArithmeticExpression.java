package Labs.Lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ArithmeticExpression {


    public static void doOperation(Stack<Integer> numbers,
                                   Stack<Character> operands) {
        int num1 = numbers.pop();
        int num2 = numbers.pop();
        char operation = operands.pop();
        if (operation == '+')
            numbers.push(num1 + num2);
        else
            numbers.push(num2 - num1);
        operands.pop();
    }

    public static int presmetaj(char c[], int l, int r) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operands = new Stack<>();

        for (char value : c) {
            if (Character.isDigit(value)) {
                numbers.push(Character.getNumericValue(value));
            } else if (value == '(') {
                operands.push(value);
            } else if (value == ')') {
                doOperation(numbers, operands);
            } else if (value == '+' || value == '-') {
                operands.push(value);
            }
        }
        return numbers.pop();
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length - 1);
        System.out.println(rez);

        br.close();

    }

}
