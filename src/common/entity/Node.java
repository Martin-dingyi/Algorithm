package common.entity;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;
 
    public Node() {}
 
    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();  // 通常这里需要初始化children列表，虽然原代码中没有，但根据常规做法应该添加
    }
 
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}