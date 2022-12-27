import java.util.Stack;

public class SequenceValidatorSimplifiedV2 implements SequenceComparable {

    @Override
    public boolean isBalanced(String s) {
        // Stack to store left symbols
        Stack<Character> leftSymbols = new Stack<>();
        // Loop for each character of the string
        for (char c : s.toCharArray()) {
            // If left symbol is encountered
            if (c == START_PAR || c == START_BRA || c == START_CUR) {
                leftSymbols.push(c);
            }
            // If right symbol is encountered
            else if (c == END_PAR && !leftSymbols.isEmpty() && leftSymbols.peek() == START_PAR) {
                leftSymbols.pop();
            } else if (c == END_BRA && !leftSymbols.isEmpty() && leftSymbols.peek() == START_BRA) {
                leftSymbols.pop();
            } else if (c == END_CUR && !leftSymbols.isEmpty() && leftSymbols.peek() == START_CUR) {
                leftSymbols.pop();
            }
            // If none of the valid symbols is encountered
            else {
                return false;
            }
        }
        return leftSymbols.isEmpty();
    }
}
