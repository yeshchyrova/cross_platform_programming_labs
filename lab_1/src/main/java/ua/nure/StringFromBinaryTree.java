package ua.nure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StringFromBinaryTree {

  public static void main(String[] args) {
    //{2,1,17,9,3,8}; {1,2,3,null,null,4};

    Integer[] root = {1, 2, 3, null, null, null, 4};
    StringFromBinaryTree obj = new StringFromBinaryTree();
    Map<Integer, List<Integer>> tree = obj.buildTreeMap(root);
    String s = obj.makeString(tree);
    System.out.println("Result string: " + s);

  }

  public String makeString(Map<Integer, List<Integer>> d) {
    StringBuilder s = new StringBuilder(d.keySet().iterator().next().toString());
    for (Integer key : d.keySet()) {
      int idx = s.indexOf(key.toString());
      if (d.get(key).isEmpty()) break;
      StringBuilder tmpStr = new StringBuilder();
      for (Integer e : d.get(key)) {
        if (e == null) tmpStr.append("()");
        else tmpStr.append("(").append(e).append(")");
      }
      int offset = String.valueOf(idx).length();
      s.insert(idx + offset, tmpStr);
    }
    return s.toString();
  }

  public Map<Integer, List<Integer>> buildTreeMap(Integer[] root) {
    LinkedHashMap<Integer, List<Integer>> d = new LinkedHashMap<>();

    for (int i = 0; i < root.length; i++) {
      Integer parent = root[i];
      if (parent == null) continue;

      List<Integer> children = new ArrayList<>();
      int leftIndex = 2 * i + 1;
      int rightIndex = 2 * i + 2;

      children.add(leftIndex < root.length ? root[leftIndex] : null);
      if (rightIndex < root.length && root[rightIndex] != null) children.add(root[rightIndex]);

      if (!(children.size() == 1 && children.get(0) == null))
        d.put(parent, children);
    }
    return d;
  }

}
