package testMyQueue;

public class Node<Integer> {
    Integer value;
    Node<Integer> next;
    Node<Integer> before;


    @Override
    public String toString() {
        return value + " ";
    }
}