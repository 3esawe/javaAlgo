package Week2;

import java.util.Comparator;

public class Players implements Comparable<Players> {
    private String name;
    private int goals;
    private int numbers;

    public Players(String name, int goals, int numbers) {
        this.name = name;
        this.goals = goals;
        this.numbers = numbers;
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public int getNumbers() {
        return numbers;
    }

    @Override
    public int compareTo(Players o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return "Players{" +
                "name='" + name + '\'' +
                ", goals=" + goals +
                ", numbers=" + numbers +
                '}';
    }

    private static class Sortbyname implements Comparator<Players> {

        @Override
        public int compare(Players o1, Players o2) {
            return o1.compareTo(o2);
        }
    }
    private static class Sortbygoals implements Comparator<Players> {


        @Override
        public int compare(Players o1, Players o2) {
            return o1.getGoals() - o2.getGoals();
        }
    }

}
