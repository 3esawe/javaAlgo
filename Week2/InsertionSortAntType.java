package Week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertionSortAntType  {
    public static void main(String[] args) {
        Players [] players = new Players[3];
        players[0] = new Players("Omar" , 280,123);
        players[1] = new Players("ALi" , 120,3);
        players[2] = new Players("Marwan" , 230,73);
        Insertion(players);
        for(Players p : players){
            System.out.println(p.getName());
        }

        List<Players> playersList = new ArrayList<>();
        playersList.add(new Players("Omar" , 280,123));
        playersList.add(new Players("ALi" , 130,3));
        playersList.add(new Players("Marwan" , 270,15));

        /*Usually, one would call the reduce method using Math.max(int, int) as follows:

reduce(new IntBinaryOperator() {
    int applyAsInt(int left, int right) {
        return Math.max(left, right);
    }
});

That requires a lot of syntax for just calling Math.max. That's where lambda expressions come into play. Since Java 8 it is allowed to do the same thing in a much shorter way:

reduce((int left, int right) -> Math.max(left, right));

How does this work? The java compiler "detects", that you want to implement a method that accepts two ints and returns one int. This is equivalent to the formal parameters of the one and only method of interface IntBinaryOperator (the parameter of method reduce you want to call). So the compiler does the rest for you - it just assumes you want to implement IntBinaryOperator.

But as Math.max(int, int) itself fulfills the formal requirements of IntBinaryOperator, it can be used directly. Because Java 7 does not have any syntax that allows a method itself to be passed as an argument (you can only pass method results, but never method references), the :: syntax was introduced in Java 8 to reference methods:

reduce(Math::max);

Note that this will be interpreted by the compiler, not by the JVM at runtime! Although it produces different bytecodes for all three code snippets, they are semantically equal, so the last two can be considered to be short (and probably more efficient) versions of the IntBinaryOperator implementation above!*/
        Collections.sort(playersList, Comparator.comparing(Players :: getGoals).reversed().thenComparing(Players::getName).thenComparing(Players :: getNumbers));

        for (Players players1 : playersList){
            System.out.println(players1.getGoals() +" " +" "+  players1.getName()  +" "+ players1.getNumbers());
        }

    }
    private static void Insertion(Players[] players){
        for (int i = 1 ; i < players.length; i++){
            int j = i;
            while (j > 0 && players[j-1].compareTo(players[j]) > 0){
                Players tmp = players[j-1];
                players[j-1]= players[j];
                players[j] = tmp;
                j--;
            }
        }

    }

}
