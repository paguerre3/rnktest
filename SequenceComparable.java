public interface SequenceComparable {
    int SPLIT_SIZE = 2;
    char START_PAR = '(';
    char END_PAR = ')';
    char START_BRA = '[';
    char END_BRA = ']';
    char START_CUR = '{';
    char END_CUR = '}';
    boolean isBalanced(final String src);
}
