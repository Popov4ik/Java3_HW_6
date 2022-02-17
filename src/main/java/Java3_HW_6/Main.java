package Java3_HW_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    TestMethod TestMethod;

    @BeforeEach
    public void init() {
        TestMethod = new TestMethod();
    }

    public static Stream<Arguments> TestWithoutFour() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
        out.add(Arguments.arguments(new int[]{9, 2, 6, 8, 3}, new int[]{5, 1, 4, 9, 2, 6, 8, 3}));
        out.add(Arguments.arguments(new int[]{6, 1, 8, 0, 5}, new int[]{4, 6, 1, 8, 0, 5}));
        out.add(Arguments.arguments(new int[]{}, new int[]{5, 1, 4}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("TestWithoutFour")
    public void TestWithoutFour(int[] arr1, int[] arr2) {
        Assertions.assertArrayEquals(arr1, TestMethod.toDeleteFour(arr2));
    }

    @Test
    public void TestWithoutFourException() {
        Assertions.assertThrows(RuntimeException.class, () -> TestMethod.toDeleteFour(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10}));
    }

    public static List<int[]> TestOneAndFourFail() {
        List<int[]> out = new ArrayList<>();
        out.add(new int[]{1, 1, 1, 1, 1, 1});
        out.add(new int[]{4, 4, 4, 4});
        out.add(new int[]{1, 4, 4, 1, 1, 4, 3});
        out.add(new int[]{41, 11, 14, 44});
        return out;
    }

    @ParameterizedTest
    @MethodSource("TestOneAndFourFail")
    public void TestOneAndFourFail(int[] arr) {
        Assertions.assertFalse(TestMethod.TestOneAndFour(arr));
    }

    public static List<int[]> TestOneAndFourSucceed() {
        List<int[]> out = new ArrayList<>();
        out.add(new int[]{1, 1, 1, 4, 4, 1, 4, 4});
        out.add(new int[]{4, 4, 4, 4, 1});
        out.add(new int[]{1, 1, 1, 4, 4});
        return out;
    }

    @ParameterizedTest
    @MethodSource("TestOneAndFourSucceed")
    public void TestOneAndFourSucceed(int[] arr) {
        Assertions.assertTrue(TestMethod.TestOneAndFour(arr));
    }
}
