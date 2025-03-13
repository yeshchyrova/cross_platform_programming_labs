package ua.nure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringFromBinaryTree {

  public static void main(String[] args) {
    // [1,2,3,4]
    LinkedHashMap<Integer, List<Integer>> d = new LinkedHashMap<>();
    d.put(1, new ArrayList<>(Arrays.asList(2,3)));
    d.put(2, new ArrayList<>(Arrays.asList(4)));
    makeString(d);
  }

  public static void makeString(Map<Integer, List<Integer>> d) {
    StringBuilder s = new StringBuilder(d.keySet().iterator().next().toString());
    for (Integer key : d.keySet()) {
      int idx = s.indexOf(key.toString());
      if(d.get(key).isEmpty()) break;
      StringBuilder tmpStr = new StringBuilder();
      for (Integer e : d.get(key)) {
        if(e==null) tmpStr.append("()");
        else tmpStr.append("(").append(e).append(")");
      }
      s.insert(idx+1, tmpStr);
    }

    System.out.println("Result: " + s);
  }

  public static Map<Integer, List<Integer>> buildTreeMap(Integer[] root) {
    LinkedHashMap<Integer, List<Integer>> d = new LinkedHashMap<>();

    for (int i = 0; i < root.length; i++) {
      Integer parent = root[i];
      if (parent == null) continue;

      List<Integer> children = new ArrayList<>();
      int leftIndex = 2 * i + 1;
      int rightIndex = 2 * i + 2;

      children.add(leftIndex < root.length ? root[leftIndex] : null);
      children.add(rightIndex < root.length ? root[rightIndex] : null);

      // Удаляем null справа, если оба null, оставляем один
      if (children.get(1) == null) children.remove(1);

      d.put(parent, children);
    }

    return d;
  }
  public static Map<Integer, List<Integer>> setList(int[] root) {
    LinkedHashMap<Integer, List<Integer>> d = new LinkedHashMap<>();
    for (int i = 0; i < root.length; i++) {
      List<Integer> children = Arrays.asList(root[(i+1)*2], root[(i+1)*2+1]);
      d.put(root[i], children);
    }
    return d;
  }
}
