package testMyQueue;

public class MyDoubleLinkedList<Integer> {

    public Node<Integer> head;
    public Node<Integer> tail;

    public void append(Integer value) {
        Node<Integer> node = new Node<>();        //node that we add
        node.value = value;

        if (head == null) {        //if linked list is empty we say that the element we add is the head
            head = node;
        } else {
            node.before = tail;
            tail.next = node;
        }
        tail = node;
    }

    public void add(int index, Integer value) {
        if (indexOutOfBound(index)) {
            return;
        }
        Node<Integer> node = new Node<>();
        node.value = value;
        Node<Integer> tmp;
        if (index == 0) {        //if we want to add element at first position we say that the element we add is the head
            node.next = head;
            head = node;
        } else {
            if (index > size() / 2) {    //if index is closer to tail then we start from the tail
                tmp = fromTail(index);
            } else {
                tmp = fromHead(index);
            }
            if (tmp != null) {
                node.next = tmp.next;
                tmp.next = node;
            }
        }
    }

    public int size() {
        int counter = 0;

        if (head != null) {             //if list is not empty
            Node<Integer> iterator = head;
            counter++;
            while (iterator.next != null) {    //as long as 'iterator' doesn't point to null (isn't last element) we go on
                counter++;
                iterator = iterator.next;        //at the end iterator is the last element
            }
        }
        return counter;
    }

    public Integer get(int index) {
        if (!indexOutOfBound(index)) {
            Node<Integer> tmp;
            if(index==0) {
                return head.value;
            }
            if (index > size() / 2) {
                tmp = fromTail(index);
            } else {
                tmp = fromHead(index);
            }
            if(index==size()-1) {
                return tail.value;
            }
            if (tmp != null) {
                return tmp.next.value;
            }
        }
        return null;
    }

    public Integer remove(int index) {
        if (indexOutOfBound(index)) {
            return null;
        }
        Node<Integer> node;
        Node<Integer> tmp;

        if (index == 0) {   //if we want to delete first element, we say that the first element is the second element
            node = head;
            head = head.next;
            return node.value;
        }
        if (index > size() / 2) {    //if index is closer to tail then we start from the tail
            tmp = fromTail(index);
        } else {
            tmp = fromHead(index);
        }
        if (index == size() - 1) {      //if I want to delete the last element
            node = tmp.next;
            tmp.next = null;
            tail = tmp;
        } else {
            node = tmp.next;
            tmp.next = tmp.next.next;
            node.next.before = tmp;
        }
        return node.value;
    }

    private Node<Integer> fromTail(int index) {
        Node<Integer> tmp;
        tmp = tail;
        for (int i = size() - 1; i >= index; i--) {
            if (tmp != null) {
                tmp = tmp.before;
            }
        }
        return tmp;
    }

    private Node<Integer> fromHead(int index) {
        Node<Integer> tmp;
        tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public boolean indexOutOfBound(int index) {
        if (index < 0 || index >= size()) {         //if index is out of bound from list
            System.out.println("Invalid input!");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Node<Integer> iterator = head;
        StringBuilder result = new StringBuilder();

        while (iterator != null) {          //string builder adds strings until we reach end of linked list
            result.append(iterator);
            iterator = iterator.next;
        }
        return result.toString();
    }

    public String toStringReverse() {
        Node<Integer> iterator = tail;
        StringBuilder result = new StringBuilder();

        while (iterator != null) {          //string builder adds strings until we reach end of linked list
            result.append(iterator);
            iterator = iterator.before;
        }
        return result.toString();
    }
}


