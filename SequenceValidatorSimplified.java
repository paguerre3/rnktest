import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simplified version using regex.
 * Performance considerations should be taken into account.
 */
public class SequenceValidatorSimplified implements SequenceComparable {
    // ^ start line
    // . any char
    // * 0 or more sequences
    // + one or more
    // $ end line
    // ?: none capturing group
    private static final String REGEX = "^(?:\\(\\)|\\[\\]|\\{\\})+$";
    private static Pattern pattern = Pattern.compile(REGEX);

    @Override
    public boolean isBalanced(final String src) {
        return pattern.matcher(src).find();
    }
}
