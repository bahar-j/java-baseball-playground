package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1").contains("2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt Exception 테스트")
    void charAt() {
        char char1 = "abc".charAt(1);
        assertThat(char1).isEqualTo('b');
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(4))
                .withMessageMatching("String index out of range: \\d+");
        assertThatThrownBy(() -> "abc".charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

}
