import org.junit.BeforeClass;
import org.junit.Test;

public class SequenceValidatorSimplifiedV2Test extends SequenceValidatorTest{

    @BeforeClass
    public static void init() {
        sc = new SequenceValidatorSimplifiedV2();
    }

    @Test
    public void whenHavingCompleteSimpleCombinationsWithInnerInclusion_ThenResultIsValid() {
        assert !sc.isBalanced("([)]");
        assert sc.isBalanced("{[]}");
    }
}