
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Search {

    public static Stack<Node> path = new Stack<Node>();

    //Returns the node with the min
    public static Node getMinKey(Map<Node, Integer> map) {
        List<Node> nodes = new ArrayList<Node>();
        int min = Collections.min(map.values());
        Node minNode = null;
        // System.out.println(" cost : "+min);
        for (Node n : map.keySet()) {
            if (min == map.get(n)) {
                minNode = n;
                nodes.add(n);
                //return n;
            }
        }
        Comparator<Node> comp = new NameComparator();
        Collections.sort(nodes,comp);
        if(nodes.size()>1){
            return nodes.get(0);
        }
        return minNode;
    }
    
    public static class NameComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.name.compareTo(o2.name);
        }

    }

    public static class ValueComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return Integer.compare(o1.value, o2.value);
        }

    }

    //----------------Depth-First-Search---------------------
    public static void DFS(Node current, Node dest) {
        int nedges = current.edges.size();
        current.visited = true;

        path.add(current);
              
        System.out.println(current.name);
        if (current.name.equals(dest.name)) {
            System.out.println("Found!");
            for(Node n : path){
                System.out.println(n.name);
            }
            System.exit(0);
        }
        for (int i = 0; i < nedges; i++) {
            Node next = current.edges.get(i).next;
            if (!next.visited && next != null) {
                DFS(next, dest);
            }

        }
        path.pop();
    }

    //----------------Best-First-Search---------------------
    public static void BestFS(Node current, Node dest) {
        Queue<Node> queue = new PriorityQueue<Node>(new ValueComparator());   
        queue.add(current);    
        int temp;
        System.out.println("The algorithm route : ");
        while (!queue.isEmpty()) {
            Node node = queue.poll();          
            System.out.println(node.name);

            //--- Calculates the final path. --- 
            temp = 0;
            while (temp == 0 && path.size() > 1) {
                for (int i = 0; i < path.peek().edges.size(); i++) {                  
                    if (path.peek().edges.get(i).next == node) {
                        temp = 1;
                    }
                }
                if (temp == 0) {
                    path.pop();
                }
            }

            path.add(node);
            //----------------

            if (node.name.equals(dest.name)) {
                System.out.println("Found!");
                System.out.println("The final path : ");
                //Prints the final path from S to G
                Stack<Node> stack = new Stack<>(); 
                while(!path.isEmpty()){
                    stack.add(path.pop());                 
		}               
                while(!stack.isEmpty()){
                    System.out.println(stack.pop().name);
		}
                System.exit(0);
            }
            int nedges = node.edges.size();
            for (int i = 0; i < nedges; i++) {
                Node next = node.edges.get(i).next;
                if (!next.visited && next != null) {
                    next.visited = true;
                    queue.add(next);
                }

            }

        }
    }

    //---------------- A* Algorithm---------------------
    public static void AlphaStar(Node current, Node dest) {
        Map<Node, Integer> map = new HashMap<Node, Integer>();
        Map<String, Integer> costs = new HashMap<String, Integer>();
        map.put(current, current.value);
        int temp;
        System.out.println("The algorithm route : ");
        while (!map.isEmpty()) {
            Node node = getMinKey(map);
            map.remove(node);
            
             //-------------- Calculates the final path.
            temp = 0;
            while (temp == 0 && path.size() > 1) {
                for (int i = 0; i < path.peek().edges.size(); i++) {                  
                    if (path.peek().edges.get(i).next == node) {
                        temp = 1;
                    }
                }
                if (temp == 0) {
                    path.pop();
                }
            }

            path.add(node);
            //----------------
            
            System.out.println(node.name);
            if (node.name.equals(dest.name)) {
                System.out.println("Found!");
                System.out.println("The final path : ");
                //Prints the final path from S to G
                Stack<Node> stack = new Stack<>(); 
                while(!path.isEmpty()){
                    stack.add(path.pop());                 
		}               
                while(!stack.isEmpty()){
                    System.out.println(stack.pop().name);
		}
                System.exit(0);
            }

            int nedges = node.edges.size();
            for (int i = 0; i < nedges; i++) {
                Node next = node.edges.get(i).next;
                int h = next.value;
                int g = node.edges.get(i).cost;
                int f = h + g;
                if (costs.get(node.name) != null) {
                    costs.put(next.name, g + costs.get(node.name));
                } else {
                    costs.put(next.name, g);
                }
                // System.out.println("g : " + g + " h : " + h + " prev : " + costs.get(node.name));
                if (!next.visited && next != null) {
                    next.visited = true;
                    if (costs.get(node.name) != null) {
                        map.put(next, f + costs.get(node.name));
                    } else {
                        map.put(next, f);
                    }

                }

            }
            /*
              for(Node n : map.keySet()){
                  System.out.println(n.name + " " + map.get(n));
                }
             */
        }

    }
    
    //  -------------- Main/Driver ------------
    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.create();
        Node S = graph.nodes.get("S");
        Node G = graph.nodes.get("G");
        
        //Here we can run the algorithms , one at each time ..
        
        //DFS(S,G);      
        //BestFS(S, G);
         //AlphaStar(S,G);
    }

}
