package per.neal.part0;


/**
 * 单链表
 *
 * @author Neal
 */
public class LinkedListCus<T> {
    private class Node {
        /**
         * 数据域
         */
        private T item;
        /**
         * 指针域
         */
        private Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * 链表头引用
     */
    private Node head;
    /**
     * 链表尾引用
     */
    private Node tail;
    /**
     * 链表长度
     */
    private int size;

    public LinkedListCus() {
        this.head = null;
        this.tail = null;
    }

    public LinkedListCus(T data) {
        // 指定一个头节点的数据域为data，不指向其他节点
        this.head = new Node(data, null);
        tail = head;
        size++;
    }

    public int length() {
        return size;
    }

    public T getElement(int index) {
        return findNodeByIndex(index).item;
    }

    private Node findNodeByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表越界");
        }
        Node current = head;
        for (int i = 0; i < size && current.next != null;
             i++, current = current.next) {
            if (i == index) {
                return current;
            }
        }
        return null;
    }

    public int getIndexByElement(T elements) {
        // 从第一个节点开始遍历
        Node current = head;
        for (int i = 0; i < size && current.next != null;
             i++, current = current.next) {
            if (current.item.equals(elements)) {
                return i;
            }
        }
        return -1;
    }

    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("线性表越界");
        }
        if (head == null) {
            add(element);
        } else {
            if (index == 0) {
                addAtHead(element);
            } else {
                // 找到要插入位置的前一个节点
                Node prev = findNodeByIndex(index - 1);
                // 插入后prev的next指向新节点，
                // 新节点的next指向原来prev的下一节点
                prev.next = new Node(element, prev.next);
            }
        }
        size++;
    }

    /**
     * 每次在尾部添加新节点
     *
     * @param element element
     */
    public void add(T element) {
        if (head == null) {
            head = new Node(element, null);
            tail = head;
        } else {
            Node node = new Node(element, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * 在头部插入节点
     *
     * @param element element
     */
    public void addAtHead(T element) {
        // 在头部插入新节点，就是让新节点的next指向原来的head，
        // 让新节点作为链表的头结点
        head = new Node(element, head);
        // 如果插入之前是空链表
        if (tail == null) {
            tail = head;
        }
    }

    public T delete(int index) {
        Node deleteNode;
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("线性表越界");
        }
        if (index == 0) {
            deleteNode = head;
            head = head.next;
        } else {
            // 获取要删除的节点的前一个节点
            Node prev = findNodeByIndex(index - 1);
            // 要删除的节点就是prev的next指向的节点
            deleteNode = prev.next;
            // 删除以后prev的next指向被删除之前所指向的next
            prev.next = deleteNode.next;
            deleteNode.next = null;
        }
        size--;
        return deleteNode.item;
    }

    /**
     * 删除 链表的最后一个元素
     *
     * @return T
     */
    public T removeLast() {
        return delete(size - 1);
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 重写单链表的toString
     *
     * @return 链表元素列表
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            for (Node current = head; current != null; current = current.next) {
                sb.append(current.item.toString()).append(",");
            }
            int len = sb.length();
            return sb.delete(len - 1, len).append("]").toString();
        }
    }
}
