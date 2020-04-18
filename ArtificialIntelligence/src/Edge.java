/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author panag
 */
public class Edge {
    Node prev;
    Node next;
    int cost;

    public Edge(Node prev, Node next, int cost) {
        this.prev = prev;
        this.next = next;
        this.cost = cost;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public int getCost() {
        return cost;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    
}
