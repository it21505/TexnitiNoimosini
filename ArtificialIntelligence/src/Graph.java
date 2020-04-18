
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author panag
 */
public class Graph {
    
      Map<String,Node> nodes;
  
    public void create(){
        
        Node S = new Node("S",4);
        Node A = new Node("A",2);
        Node K = new Node("K",5);
        Node F = new Node("F",4);
        Node B = new Node("B",3);
        Node L = new Node("L",6);
        Node H = new Node("H",3);
        Node C = new Node("C",4);
        Node I = new Node("I",2);
        Node D = new Node("D",5);
        Node J = new Node("J",1);
        Node E = new Node("E",6);
        Node G = new Node("G",0);
        
        
        Edge e1 = new Edge(S,A,2);
        Edge e2 = new Edge(S,K,2);
        Edge e3 = new Edge(S,F,1);
        Edge e4 = new Edge(A,B,2);
        Edge e5 = new Edge(K,L,1);
        Edge e6 = new Edge(F,H,1);
        Edge e7 = new Edge(B,G,3);
        Edge e8 = new Edge(B,C,2);
        Edge e9 = new Edge(C,D,2);
        Edge e10 = new Edge(D,E,1);
        Edge e11= new Edge(H,I,1);
        Edge e12 = new Edge(I,J,1);
        Edge e13 = new Edge(D,G,5);
        Edge e14 = new Edge(J,G,1);
        /*
        S.edges.add(e1);
        S.edges.add(e2);
        S.edges.add(e3);
        A.edges.add(e4);
        K.edges.add(e5);
        F.edges.add(e6);
        B.edges.add(e7);
        B.edges.add(e8);
        C.edges.add(e9);
        D.edges.add(e10);
        D.edges.add(e13);
        H.edges.add(e11);
        I.edges.add(e12);
        J.edges.add(e14);
           */
        J.edges.add(e14);
         I.edges.add(e12);
         H.edges.add(e11);
         D.edges.add(e13);
         D.edges.add(e10);
         C.edges.add(e9);
         B.edges.add(e8);
         B.edges.add(e7);
         F.edges.add(e6);
         K.edges.add(e5);
         A.edges.add(e4);       
         S.edges.add(e3);
         S.edges.add(e2);
         S.edges.add(e1);
                
        this.nodes = new HashMap<String,Node>();
        nodes.put("S", S);
        nodes.put("A", A);
        nodes.put("K", K);
        nodes.put("F", F);
        nodes.put("B", B);
        nodes.put("L", L);
        nodes.put("H", H);
        nodes.put("C", C);
        nodes.put("I", I);
        nodes.put("D", D);
        nodes.put("J", J);
        nodes.put("E", E);
        nodes.put("G", G);
               
    }
}
