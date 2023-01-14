package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int nElements = 2;
        var actual = App.take(list, nElements);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        assertThat(actual).isEqualTo(expected);
        // END
    }
}
