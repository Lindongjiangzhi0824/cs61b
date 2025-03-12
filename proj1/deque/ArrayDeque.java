package deque;

import java.util.Iterator;

public class ArrayDeque<ElemType> implements Deque<ElemType> {
    private ElemType[] elements;
    private int front;
    private int size;
    public int MINI_DEQUE_CAPACITY = 8;

    public ArrayDeque(){
        elements = (ElemType[]) new Object[MINI_DEQUE_CAPACITY];
        front = 0;
        size = 0;
    }

    @Override
    public void resize(int newCapacity){
        ElemType[] newArray = (ElemType[]) new Object[newCapacity];
        for(int i = 0 ; i < size; i++){
            newArray[i] = elements[(front + i) % elements.length];
        }
        elements = newArray;
        //
        front = 0;
    }

    @Override
    public void addFirst(ElemType e){
        if(size == elements.length){
            resize(elements.length * 2);
        }
        front = (front - 1 + elements.length) % elements.length;
        elements[front] = e;
        size++;
    }
    @Override
    public void addLast(ElemType e){
        if(size == elements.length){
            resize(elements.length * 2);
        }
        int rear = (front + size) % elements.length;
        elements[rear] = e;
        size++;
    }
    @Override
    public ElemType removeFirst(){
        if(size == 0){return null;}
        ElemType e = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        if(elements.length >= 16 && size < elements.length * 0.25){
            resize(elements.length * 2);
        }
        return e;
    }
    @Override
    public ElemType removeLast(){
        if(size == 0){return null;}
        int rear = (front + size - 1) % elements.length;
        ElemType e = elements[rear];
        elements[rear] = null;
        size--;
        if(elements.length >= 16 && size < elements.length * 0.25){
            resize(elements.length * 2);
        }
        return e;
    }
    @Override
    public ElemType get(int index){
        if(index < 0 || index >= size){return null;}
        return elements[(front + index) % elements.length];
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public void printDeque(){
        if(this.size == 0){
            System.out.println("ArrayDequeue is empty.");
        }
        for(int i = front ; i < size ; i++){
            if(i < elements.length){
                if(i == front){
                    System.out.println(elements[i]);
                }
                System.out.print(" " + elements[i]);
            }else{
                System.out.println(" " +elements[(front + i) % elements.length]);
            }
        }
        System.out.println("\nTraverse is over.");
    }

    @Override
    public boolean equals(ArrayDeque<ElemType> o){
        if(!(o instanceof ArrayDeque) || ((Deque<?>) o).size() != this.size){return false;}
        if(o == this){return true;}
        for(int i = 0 ; i < this.size() ; i++){
            Object item = ((Deque<?>) o).get(i);
            if(!(this.get(i).equals(item))){return false;}
        }
        return true;
    }

    public Iterator<ElemType> iterator(){
        return new Iterable();
    }

    private class Iterable implements Iterator<ElemType>{
        private int pos;

        Iterable(){
            this.pos = 0;
        }
        @Override
        public boolean hasNext() {
            return this.pos < size;
        }

        @Override
        public ElemType next() {
            ElemType ret = get(pos);
            this.pos++;
            return ret;
        }
    }
}
