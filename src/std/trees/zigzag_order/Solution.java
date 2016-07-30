package std.trees.zigzag_order;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static class Tree {
        Tree left;
        Tree right;
        int value;
        
        public Tree(int value, Tree left, Tree right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
        
        public Tree(int value) {
            this.value = value;
        }
    }

    private static void printZigZag(Tree root) {
        LinkedList<Tree> S1 = new LinkedList<>();
        LinkedList<Tree> S2 = new LinkedList<>();
        
        S1.push(root);

        List<Integer> list = new LinkedList<>();
        while (true) {
            list.clear();
            while (!S1.isEmpty()) {
                Tree tree = S1.remove();
                list.add(tree.value);
                for (Tree child : new Tree[] {tree.left, tree.right}) {
                    if (child != null) {
                        S2.push(child);    
                    }
                }
            }
            System.out.println(list);

            list.clear();
            while (!S2.isEmpty()) {
                Tree tree = S2.remove();
                list.add(tree.value);
                for (Tree child : new Tree[] {tree.right, tree.left}) {
                    if (child != null) {
                        S1.push(child);
                    }
                }
            }
            System.out.println(list);

            if (S1.isEmpty() && S2.isEmpty()) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        Tree tree = new Tree(1, new Tree(2), new Tree(3, new Tree(4), new Tree(5)));
        printZigZag(tree);
    }

}
