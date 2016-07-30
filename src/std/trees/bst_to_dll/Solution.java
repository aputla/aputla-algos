package std.trees.bst_to_dll;


public class Solution {
    private static class Tree {
        Tree left;
        Tree right;
        Tree prev;
        Tree next;
        int value;

        Tree(int value) {
            this.value = value;
        }
    }

    private static class ListProcessor {
        Tree prev;
        Tree head;

        private void inorder(Tree tree) {
            if (tree == null) {
                return;
            }
            inorder(tree.left);
            head = (head == null) ? tree : head;
            tree.prev = prev;
            if (prev != null) {
                prev.next = tree;
            }
            prev = tree;
            inorder(tree.right);
        }

        public Tree convert(Tree tree) {
            inorder(tree);
            return head;
        }
    }

    private static Tree makeList(Tree tree) {
        return new ListProcessor().convert(tree);
    }

    public static void main(String[] args) {
        Tree one = new Tree(1);
        Tree three = new Tree(3);
        Tree two = new Tree(2); two.left = one; two.right = three;

        Tree five = new Tree(5);
        Tree seven = new Tree(7);
        Tree six = new Tree(6); six.left = five; six.right = seven;

        Tree four = new Tree(4); four.left = two; four.right = six;

        Tree tree = makeList(four);

        while (tree != null) {
            System.out.println(tree.value);
            tree = tree.next;
        }
    }
}
