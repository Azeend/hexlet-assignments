package exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
public class AppTest {
    @Test
    void Test() {
        String[][] image = {{"1", "1", "1" }, {"2", "2", "2"}};
        String[][] expected = {
                {"1", "1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1", "1"},
                {"2", "2", "2", "2", "2", "2"},
                {"2", "2", "2", "2", "2", "2"}
        };
        assertThat(App.enlargeArrayImage(image)).isEqualTo(expected);
    }
}
// END