package std.arrays.overlapping_events;

import java.util.Arrays;

class Event implements Comparable<Event> {
    Integer start;
    Integer end;

    Event(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public boolean hasConflict(Event event) {
        if (start <= event.start && event.start <= end) {
            return true;
        }
        if (event.start <= start && start <= event.end) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", start, end);
    }

    @Override
    public int compareTo(Event other) {
        return start.compareTo(other.start) == 0 ? end.compareTo(other.end) : start.compareTo(other.start);
    }
}

class Main {
    private static void solve(Event[] list) {
        if (list.length <= 1) {
            return;
        }

        Arrays.sort(list);

        if (list[0].hasConflict(list[1])) {
            System.out.println(list[0] + ":true");
        }
        for (int i = 1; i < list.length; i++) {
            if (list[i].hasConflict(list[i - 1])) {
                System.out.println(list[i] + ":true");
            } else {
                System.out.println(list[i] + ":false");
            }
        }
    }

    public static void main(String[] args) {
        Event[] list = {new Event(1, 10), new Event(5, 12), new Event(11, 14), new Event(20, 23)};
        solve(list);
    }
}
