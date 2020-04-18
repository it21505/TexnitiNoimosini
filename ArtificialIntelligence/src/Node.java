
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author panag
 */
public class Node {
    String name;
    int value;
    List<Edge> edges;
    boolean visited;
    
    
    public Node(String name, int value) {
        this.name = name;
        this.value = value;     
        this.edges = new ArrayList<Edge>();
        this.visited = false;
    }
    
    public String getName() {
        return name;
    }

     public void setName(String name) {
        this.name = name;
    }
     
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
   
}
