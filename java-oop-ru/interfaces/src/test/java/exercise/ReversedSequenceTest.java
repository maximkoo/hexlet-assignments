package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {
    @Test
    void test1() { //toString
        CharSequence text = new ReversedSequence("abcdef");
        String result = text.toString();
        String expected = "fedcba";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void test2() { //charAt
        CharSequence text = new ReversedSequence("abcdef");
        char result = text.charAt(1);
        char expected = 'e';
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void test3() { //length
        CharSequence text = new ReversedSequence("abcdef");
        int result = text.length();
        int expected = 6;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void test4() { //subsequence
        CharSequence text = new ReversedSequence("abcdef");
        CharSequence result = text.subSequence(1, 4);
        CharSequence expected = "edc";
        assertThat(result).isEqualTo(expected);
    }
}
