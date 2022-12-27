import org.apache.commons.collections4.ListUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * This was my intention during the challenge.
 */
public class SequenceValidator implements SequenceComparable {

    @Override
    public boolean isBalanced(final String src) {
        CompletableFuture<Boolean> fp
                = CompletableFuture.supplyAsync(() -> isBalanced(START_PAR, END_PAR, src));
        CompletableFuture<Boolean> fb
                = CompletableFuture.supplyAsync(() -> isBalanced(START_BRA, END_BRA, src));
        CompletableFuture<Boolean> fc
                = CompletableFuture.supplyAsync(() -> isBalanced(START_CUR, END_CUR, src));
        CompletableFuture<Void> combined
                = CompletableFuture.allOf(fp, fb, fc);
        return getSilently(fp) && getSilently(fb) && getSilently(fc);
    }

    private boolean getSilently(CompletableFuture<Boolean> cf) {
        try {
            // synchronized wait:
            return cf.get(7, TimeUnit.SECONDS);
        } catch (Exception e) {
            // don't do anything
        }
        return false;
    }

    protected boolean isBalanced(final char start, final char end, final String src) {
        if (src != null && src.length() > 0) {
            List<Character> chars = src.chars()
                    .mapToObj(e -> (char)e)
                    .collect(Collectors.toList());
            List<List<Character>> subLists = ListUtils.partition(chars, SPLIT_SIZE);
            for (List<Character> subList : subLists) {
                if (subList.size() != SPLIT_SIZE && !isBalancedRaw(start, end, subList)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isBalancedRaw(final char start, final char end, final List<Character> subList) {
        return subList.get(0) == start && subList.get(1) == end;
    }

    public static void main(String[] args) {
        System.out.println("starting point class");
    }
}
