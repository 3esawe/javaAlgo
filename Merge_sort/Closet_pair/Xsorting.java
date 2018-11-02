package Merge_sort.Closet_pair;

import java.util.Comparator;

public class Xsorting implements Comparator<Points> {
    @Override
    public int compare(Points o1, Points o2) {
        return Double.compare(o1.getX(), o2.getX());
    }
}
