package Week3;

import Week2.Players;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;

public class main {
    public static void main(String[] args) {
        Players[] players = new Players[3];
        players[0] = new Players("Omar" , 280,123);
        players[1] = new Players("ALi" , 120,3);
        players[2] = new Players("Marwan" , 230,73);
//        Merge.sort(players);
//
        Merge_sort.merge_sort(players);
        for (Players players1 : players){
            System.out.println(players1.getGoals() +" " +" "+  players1.getName()  +" "+ players1.getNumbers());
        }
        ////////////////////////////////////////////////////////////////
        Quicksort.sort(players);
        for (Players players1 : players){
            System.out.println(players1.getGoals() +" " +" "+  players1.getName()  +" "+ players1.getNumbers());
        }
    }

}
