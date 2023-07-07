package testMyQueue;

public class Queue {
    public MyDoubleLinkedList<Integer> doubleList = new MyDoubleLinkedList<>();

    public void enqueue(int newElement) {   //adds element at the end
        doubleList.append(newElement);
    }

    public int size() {
        return doubleList.size();
    }

    public int dequeue() {          //returns first element of queue & deletes it
        if (size() >= 1) {
            return doubleList.remove(0);
        } else {
            throw new IllegalArgumentException("List is empty!");
        }
    }

    public int[] dequeue(int n) {      //deletes n-first elements & returns them
        if (size() >= n) {
            int[] trashBasket = new int[n];

            for (int i = 0; i < n; i++) {
                trashBasket[i] = doubleList.get(0);
                doubleList.remove(0);
            }
            return trashBasket;
        } else {
            throw new IllegalArgumentException("There are not enough elements in the list!");
        }
    }
    @Override
    public String toString() {
        return doubleList.toString();
    }


}
