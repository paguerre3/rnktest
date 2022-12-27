import org.junit.BeforeClass;
import org.junit.Test;

public class SequenceValidatorTest {

    private static SequenceComparable sc = null;

    @BeforeClass
    public static void init() {
        sc = new SequenceValidator();
    }

    @Test
    public void whenHavingCompleteParenthesis_ThenResultIsValid() {
        assert sc.isBalanced("()");
    }

    @Test
    public void whenHavingIncompleteParenthesis_ThenResultIsInvalid() {
        assert !sc.isBalanced("(");
    }

    @Test
    public void whenHavingIncompleteBracketsWithProperCombinations_ThenResultIsInvalid() {
        assert !sc.isBalanced("()[{}");
    }

    @Test
    public void whenHavingCompleteSimpleCombinations_ThenResultIsValid() {
        assert sc.isBalanced("()[]{}");
        assert sc.isBalanced("()[]{}()[]");
    }
}
