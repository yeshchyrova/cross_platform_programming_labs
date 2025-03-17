package ua.nure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class StringFromBinaryTreeTest {

  static Stream<Arguments> buildTreeMapTestCases() {
    return Stream.of(
            Arguments.of(new Integer[]{1, 2, 3, null, null, null, 4},
                         new LinkedHashMap<Integer, List<Integer>>() {{
                           put(1, Arrays.asList(2, 3));
                           put(3, Arrays.asList(null, 4));
                         }}
                        ),
            Arguments.of(new Integer[]{1, 2, 3, null, null, 4},
                         new LinkedHashMap<Integer, List<Integer>>() {{
                           put(1, Arrays.asList(2, 3));
                           put(3, List.of(4));
                         }}
                        ),
            Arguments.of(new Integer[]{1, 2, 3, null, 4},
                         new LinkedHashMap<Integer, List<Integer>>() {{
                           put(1, Arrays.asList(2, 3));
                           put(2, Arrays.asList(null, 4));
                         }}),
            Arguments.of(new Integer[]{6, 7, 8, null, 9, null, 10},
                         new LinkedHashMap<Integer, List<Integer>>() {{
                           put(6, Arrays.asList(7, 8));
                           put(7, Arrays.asList(null, 9));
                           put(8, Arrays.asList(null, 10));
                         }}),
            Arguments.of(new Integer[]{2, 1, 17, 9, 3, 8},
                         new LinkedHashMap<Integer, List<Integer>>() {{
                           put(2, Arrays.asList(1, 17));
                           put(1, Arrays.asList(9, 3));
                           put(17, List.of(8));
                         }})
                    );
  }


  @ParameterizedTest(name = "Test {index}: buildTreeMap({0})")
  @MethodSource("buildTreeMapTestCases")
  void buildTreeMap(Integer[] input, Map<Integer, List<Integer>> expected) {
    StringFromBinaryTree obj = new StringFromBinaryTree();
    Map<Integer, List<Integer>> res = obj.buildTreeMap(input);

    assertEquals(expected, res);
  }


  static Stream<Arguments> makeStringTestCases() {
    return Stream.of(
            Arguments.of(new LinkedHashMap<Integer, List<Integer>>() {{
              put(1, Arrays.asList(2, 3));
              put(3, Arrays.asList(null, 4));
            }}, "1(2)(3()(4))"),
            Arguments.of(new LinkedHashMap<Integer, List<Integer>>() {{
              put(1, Arrays.asList(2, 3));
              put(3, List.of(4));
            }}, "1(2)(3(4))"),
            Arguments.of(new LinkedHashMap<Integer, List<Integer>>() {{
              put(2, Arrays.asList(1, 17));
              put(1, Arrays.asList(9,3));
              put(17, List.of(8));
            }}, "2(1(9)(3))(17(8))")

                    );
  }

  @ParameterizedTest(name = "Test {index}: makeString({0})")
  @MethodSource("makeStringTestCases")
  void makeString(LinkedHashMap<Integer, List<Integer>> input, String expected) {
    StringFromBinaryTree obj = new StringFromBinaryTree();
    String res = obj.makeString(input);

    assertEquals(expected, res);
  }
}
