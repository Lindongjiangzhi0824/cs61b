package deque;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class Node<T>{
    T data;
    Node<T> prev;
    Node<T> next;

    Node(T data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class LinkedListDeque<ElemType> {
    public Node<ElemType> head;
    public Node<ElemType> tail;
    public int size;

    public LinkedListDeque(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public void addFirst(ElemType data){
        Node<ElemType> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(ElemType data){
        Node<ElemType> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    public ElemType removeFirst(){
        if(head == null){return null;}

        ElemType elem = head.data;
        if (head==tail){
            elem = head.data;
            head = tail = null;
        }else{
            head = head.next;
            head.prev = null;
        }
        size--;
        return elem;
    }
    public ElemType removeLast(){
        // 移除最后一个 Node
        if(head == null){return null;}

        ElemType elem = tail.data;
        if(head == tail){
            head = tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return elem;
    }
    // index 从 0 开始
    public ElemType get(int index){
        if(head == null){return null;}
        if(index == 0 && head != null){return head.data;}
        Node<ElemType> current = head;
        for(int i = 1 ; i < index ; i++){
            current = current.next;
        }
        return current.data;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int size(){return size;}

    public void printDeque(){
        if(this.head == null){
            System.out.println("Dequeue is empty.");
        }else{
            Node<ElemType> current = head;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
        System.out.println("\nTraverse is over.");
    }

    /**
     * 递归辅助方法：从当前节点出发，找到第 index 个元素
     * @param current 当前遍历到的节点
     * @param remaining 剩余步数
     * @return
     */
    private ElemType getRecursiveHelper(Node<ElemType> current, int remaining){
        if(remaining == 0){
            return current.data;
        }
        return getRecursiveHelper(current.next, remaining - 1);
    }
    public ElemType getRecursive(int index){
        if(index < 0 || index >= size){return null;}
        return getRecursiveHelper(head, index);
    }

//    @Override
//    public Iterator<ElemType> iterator(){
//        return new ListIterator<ElemType>() {
//            private Node<ElemType> currentNode = head;
//            private Node<ElemType> lastReturned = null;
//            @Override
//            public boolean hasNext() {
//                return currentNode != null;
//            }
//
//            @Override
//            public ElemType next() {
//                if(!hasNext()){throw new NoSuchElementException();}
//                lastReturned = currentNode;
//                ElemType values = currentNode.data;
//                currentNode = currentNode.next;
//                return values;
//            }
//        };
//    }
    public boolean equal(Object o){
        LinkedListDeque<ElemType> deque = (LinkedListDeque<ElemType>) o;
        if(this.size != deque.size()){return false;}
        if(this.head == null && deque.head == null){return true;}
        // 遍历两个deque看值一不一致
        Node<ElemType> cur1 = head;
        Node<ElemType> cur2 = deque.head;
        for(int i = 0; i < this.size; i++){
            if(cur1.data != cur2.data){return false;}
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(10);
        deque.addLast(4);
        deque.removeLast();

//        System.out.println(deque.size());
        deque.printDeque();

    }
}
