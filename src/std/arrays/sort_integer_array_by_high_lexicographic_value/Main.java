package std.arrays.sort_integer_array_by_high_lexicographic_value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
     
public class Main { 
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(4, 94, 9, 14, 1));
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer one, Integer two) {
                Integer a = Integer.parseInt(one.toString() + two.toString());
                Integer b = Integer.parseInt(two.toString() + one.toString());
                return b.compareTo(a);
            }
        });
        System.out.println(list);
    }
}   
