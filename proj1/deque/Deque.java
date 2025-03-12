package deque;

public interface Deque<T> {
    void resize(int newCapacity);

    public void addFirst(T item);
    public void addLast(T item);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);


    boolean equals(ArrayDeque<T> o);
}
