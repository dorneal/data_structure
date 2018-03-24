package per.neal.part2;


/**
 * 链栈
 *
 * @author Neal
 */
public class LinkedStack<T> {
    private class Node {
        private T data;
        private Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 头指针，跟计数器
     */
    private Node head;
    private int size;

    public LinkedStack() {
        this.head = null;
        this.size = 0;
    }

    public void push(T element) {
        head = new Node(element, head);
        size++;
    }

    public int length() {
        return size;
    }

    public T remove() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("空栈无法执行删除操作");
        } else {
            Node nodePre = head;
            head = head.next;
            nodePre.next = null;
            size--;
            return nodePre.data;
        }
    }
}
