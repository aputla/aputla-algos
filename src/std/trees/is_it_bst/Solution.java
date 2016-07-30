package std.trees.is_it_bst;

public class Solution {
    private static class Tree {
        Tree left;
        Tree right;
        int value;

        Tree(int value) {
            this.value = value;
        }

        public static Tree[] create(int start, int end) {
            Tree[] result = new Tree[end - start + 2];
            for (int i = start; i <= end; i++) {
                result[i - start + 1] = new Tree(i);
            }
            return result;
        }

        public static boolean isBST(Tree tree) {
            return isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private static boolean isBST(Tree tree, int min, int max) {
            if (tree == null) {
                return true;
            }
            if (min <= tree.value && tree.value <= max) {
                return isBST(tree.left, min, tree.value) && isBST(tree.right, tree.value, max);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Tree[] list = Tree.create(1, 7);
        list[4].left = list[2]; list[4].right = list[6];
        list[2].left = list[1]; list[2].right = list[3];
        list[6].left = list[5]; list[6].right = list[7];
        System.out.println(Tree.isBST(list[4]));
    }
}
