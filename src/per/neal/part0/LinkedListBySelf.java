package per.neal.part0;

/**
 * 双链表
 *
 * @author Neal
 */
public class LinkedListBySelf<T> {
    private class Node {
        private T data;
        private Node next;
        private Node prev;

        Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListBySelf() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(T element) {
        if (head == null) {
            head = new Node(element, null, null);
            tail = head;
        } else {
            // 新节点
            Node last = new Node(element, tail, null);
            // 尾部的下一个节点是新节点
            tail.next = last;
            // 将尾部指针到新节点
            tail = last;
        }
        size++;
    }

    public int length() {
        return size;
    }

    public T remove() {
        if (head == tail) {
            throw new IndexOutOfBoundsException("这是个空链表，无法删除");
        } else {
            return removeByIndex(size);
        }
    }

    public T removeByIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("越界了");
        } else {
            Node lastPrev = loopThis(index - 1);
            Node delNode = lastPrev.next;
            lastPrev.prev = delNode.prev;
            lastPrev.next = delNode.next;

            delNode.prev = null;
            delNode.next = null;
            size--;
            return delNode.data;
        }
    }

    private Node loopThis(int index) {
        if (head == tail || size == 0) {
            throw new IndexOutOfBoundsException("空链表");
        } else {
            Node current = tail;
            for (int i = size; i >= 0 && current.prev != null; current = current.prev, i--) {
                if (i == index) {
                    return current;
                }
            }
        }
        return null;
    }
}
