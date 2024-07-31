package exercise;

// BEGIN

import java.lang.CharSequence;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReversedSequence implements CharSequence {
    private String str;

    public ReversedSequence(String str) {
        String[] arr = str.split("");
        this.str = Arrays.stream(arr).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }

    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int index) {
        char[] charArray = this.str.toCharArray();
        return charArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return str.substring(start, end);
    }

    @Override
    public String toString() {
        return this.str;
    }
}
// END
