package Graph_Search;
import java.util.*;

public class Graph {
    private Set<Node> DFSexplored = new HashSet<>();
    private Set<Node> CCexplored = new HashSet<>();
    private Stack<Node> TopoStack = new Stack<>();
    private Map<Node, ArrayList<Node>> edges;

    public Graph() {
        this.edges = new HashMap<>();
    }

    public void addNode(String node){
        Node n = new Node(node);
        if (edges.containsKey(n)){
            System.out.println("Duplicate value");
        }
        else{
            edges.put(n,new ArrayList<Node>());
        }
    }
    
    
    private Node getNode(String name) throws NullPointerException{
        for (Node n:
            edges.keySet() ) {
            if (n.getName().equals(name)){
                return n;
            }
        }
        return null;
    }

    public void addEdge(String src, String dest){
        addEdge(new Edge(src,dest));
    }
    private void addEdge(Edge e){
        Node src = getNode(e.getSrc());
        Node dest = getNode(e.getDest());
        if (!edges.containsKey(src) && !edges.containsKey(dest)){
            System.out.println("Not not found");
        }
        else{
            edges.get(src).add(dest);
        }
    }

    private ArrayList<Node> childrenof(Node node){
        return edges.get(node);
    }
    
    
    public void Topo(){
        for (int i = 0; i < TopoStack.size(); i++){
            System.out.println(TopoStack.get(i).getName());
        }
    }

    public void ConnectedComponents(){
        ArrayList<Node> unexplored = new ArrayList<>(edges.keySet());
        for (Node c : unexplored){
            int i = childrenof(c).size();
            for (int j = 0; j < i; j++){

                if (unexplored.contains(c) && !CCexplored.contains(childrenof(c).get(j))){
                    BFS(c.getName());
                    CCexplored.add(childrenof(c).get(j));

                }
            }

        }
    }

    public void DFS(String start){
        Node src = getNode(start);
        System.out.println(src.getName());
        DFSexplored.add(src);
        for(Node c : childrenof(src)){
            if (!DFSexplored.contains(c)){
                DFS(c.getName());
//                explored.add(c);
            }
        }
        TopoStack.push(src);


    }


    public void BFS(String start){
        Node src = getNode(start);
//        Node dest = getNode(end);
        ArrayList<Node> explored = new ArrayList<>();
        explored.add(src);
        CCexplored.add(src);

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Integer> shortes = new HashMap<>();
        queue.add(src);
        shortes.put(src,0);
        while (!queue.isEmpty()){
            Node v = queue.poll();
            System.out.println(v.getName()+" ");
            explored.add(v);

            for (Node c : childrenof(v)){
                if (!explored.contains(c)){
                    explored.add(c);
                    queue.add(c);
                    shortes.put(c, shortes.get(v) +1);
                }

            }
        }
//        for (Map.Entry<Node,Integer> c :
//             shortes.entrySet()) {
//            System.out.println(c.getKey().getName());
//        }



    }

    public void topologicalsort(String start){
        Node src = getNode(start);
        TopoStack = new Stack<>();
        for(Node c : childrenof(src)){
            if(!DFSexplored.contains(c)){
                DFS(c.getName());
            }
        }
    }
    public class Node {
        private String name;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    public static class Edge {
        private String src;
        private String dest;

        public Edge(String src, String dest) {
            this.src = src;
            this.dest = dest;
        }

        public String getSrc() {
            return src;
        }

        public String getDest() {
            return dest;
        }
    }
}
