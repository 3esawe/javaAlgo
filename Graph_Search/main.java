package Graph_Search;

public class main {
    public static void main(String[] args) {
        Graph myGapg = new Graph();
        myGapg.addNode("omar");
        myGapg.addNode("ali");
        myGapg.addNode("rashed");
        myGapg.addNode("essa");
        myGapg.addNode("ahmed");
        myGapg.addNode("hassan");
        myGapg.addEdge("omar", "ali");
        myGapg.addEdge("omar", "rashed");
//        myGapg.addEdge("ali", "rashed");
        myGapg.addEdge("rashed", "ahmed");
        myGapg.addEdge("ali", "ahmed");
        myGapg.addEdge("ahmed", "essa");
        myGapg.addEdge("ali", "essa");
//        myGapg.addEdge("hassan", "ali");
//        myGapg.addEdge("ahmed", "ali");
//        myGapg.topologicalsort("omar");
//        myGapg.Topo();
//        System.out.println("***");
//        myGapg.BFS("ali");
//        myGapg.BFS("ali");
//        myGapg.ConnectedComponents();
    }
}
