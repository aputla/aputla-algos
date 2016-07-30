package std.stacks_and_queues.implement_stack_using_linked_list;

class List<Value> {
    List<Value> next;
    Value value;

    List(Value value) {
        this.value = value;
    }

    List(Value value, List<Value> next) {
        this.value = value;
        this.next = next;
    }

    public static <Value> List<Value> create(Value value) {
        return new List<Value>(value);
    }

    public static <Value> List<Value> create(Value value, List<Value> next) {
        return new List<Value>(value, next);
    }
}

class Stack<Value> {
    List<Value> head;

    void push(Value value) {
        head = (head == null) ? List.create(value) : List.create(value, head);
    }

    Value pop() {
        Value result = head.value;
        head = head.next;
        return result;
    }

    boolean isEmpty() {
        return head == null;
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
