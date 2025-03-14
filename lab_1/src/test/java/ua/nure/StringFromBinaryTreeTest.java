package ua.nure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class StringFromBinaryTreeTest {
  @Test
  void buildTreeMapSuccessTest() {
    Integer[] input1 = {1, 2, 3, null, null, null, 4};
    Integer[] input2 = {1, 2, 3, null, null, 4};
    Integer[] input3 = {1, 2, 3, null, 4};
    Integer[] input4 = {6, 7, 8, null, 9, null, 10};
    Integer[] input5 = {2, 1, 17, 9, 3, 8};

    Map<Integer, List<Integer>> expected1 = new LinkedHashMap<>();
    Map<Integer, List<Integer>> expected2 = new LinkedHashMap<>();
    Map<Integer, List<Integer>> expected3 = new LinkedHashMap<>();
    Map<Integer, List<Integer>> expected4 = new LinkedHashMap<>();
    Map<Integer, List<Integer>> expected5 = new LinkedHashMap<>();

    expected1.put(1, new ArrayList<>(Arrays.asList(2, 3)));
    expected1.put(3, new ArrayList<>(Arrays.asList(null, 4)));

    expected2.put(1, new ArrayList<>(Arrays.asList(2, 3)));
    expected2.put(3, new ArrayList<>(Arrays.asList(4)));

    expected3.put(1, new ArrayList<>(Arrays.asList(2, 3)));
    expected3.put(2, new ArrayList<>(Arrays.asList(null, 4)));

    expected4.put(6, new ArrayList<>(Arrays.asList(7, 8)));
    expected4.put(7, new ArrayList<>(Arrays.asList(null, 9)));
    expected4.put(8, new ArrayList<>(Arrays.asList(null, 10)));

    expected5.put(2, new ArrayList<>(Arrays.asList(1, 17)));
    expected5.put(1, new ArrayList<>(Arrays.asList(9, 3)));
    expected5.put(17, new ArrayList<>(Arrays.asList(8)));

    StringFromBinaryTree obj = new StringFromBinaryTree();
    Map<Integer, List<Integer>> res1 = obj.buildTreeMap(input1);
    Map<Integer, List<Integer>> res2 = obj.buildTreeMap(input2);
    Map<Integer, List<Integer>> res3 = obj.buildTreeMap(input3);
    Map<Integer, List<Integer>> res4 = obj.buildTreeMap(input4);
    Map<Integer, List<Integer>> res5 = obj.buildTreeMap(input5);


    assertEquals(expected1, res1);
    assertEquals(expected2, res2);
    assertEquals(expected3, res3);
    assertEquals(expected4, res4);
    assertEquals(expected5, res5);
  }

  @Test
  void makeStringSuccessTest() {
    Map<Integer, List<Integer>> input1 = new LinkedHashMap<>();
    Map<Integer, List<Integer>> input2 = new LinkedHashMap<>();
    Map<Integer, List<Integer>> input3 = new LinkedHashMap<>();

    input1.put(1, new ArrayList<>(Arrays.asList(2, 3)));
    input1.put(3, new ArrayList<>(Arrays.asList(null, 4)));

    input2.put(1, new ArrayList<>(Arrays.asList(2, 3)));
    input2.put(3, new ArrayList<>(Arrays.asList(4)));

    input3.put(2, new ArrayList<>(Arrays.asList(1, 17)));
    input3.put(1, new ArrayList<>(Arrays.asList(9, 3)));
    input3.put(17, new ArrayList<>(Arrays.asList(8)));

    String expected1 = "1(2)(3()(4))";
    String expected2 = "1(2)(3(4))";
    String expected3 = "2(1(9)(3))(17(8))";

    StringFromBinaryTree obj = new StringFromBinaryTree();
    String res1 = obj.makeString(input1);
    String res2 = obj.makeString(input2);
    String res3 = obj.makeString(input3);

    assertEquals(expected1, res1);
    assertEquals(expected2, res2);
    assertEquals(expected3, res3);

  }
}
