package std.linkedlists.mth_element;

class List {
    List next;
    int value;
    
    List(int value) {
        this.value = value;
    }
    
    List(int value, List next) {
        this.value = value;
        this.next = next;
    }
}

public class Solution {
    private static List get(List list, int m) {
        List result = list;
        for (int i = 0; i < m; i++) {
            if (list == null) {
                return null;
            }
            list = list.next;
        }
        while (list != null) {
            result = result.next;
            list = list.next;
        }
        return result;
    }

    public static void main(String[] args) {
        List list;
        list = new List(5);
        list = new List(4, list);
        list = new List(3, list);
        list = new List(2, list);
        list = new List(1, list);

        System.out.println(get(list, 3).value);
    }
}

