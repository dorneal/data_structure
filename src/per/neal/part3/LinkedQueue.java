package per.neal.part3;

/**
 * 链表队列
 *
 * @author Neal
 */
public class LinkedQueue<T> {
    private class Node {
        private T data;
        private Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private Node node;

    public LinkedQueue() {
        this.front = this.rear = null;
    }

    public void enQueue(T element) {
        if (rear == null && front == null) {
            front = rear = new Node(element);
        } else {
            // 构建一个节点
            // 节点下一个指向为空
            // 将尾部节点的下一个指向指向这个节点
            rear.next = new Node(element);
            // 再讲尾部节点移动到这个节点
            rear = rear.next;
        }
    }

    public T deQueue() {
        // 如果尾部节点跟头部节点一样，则代表是个空队列
        if (front == rear) {
            throw new IndexOutOfBoundsException("这是个空队列");
        } else {
            // 获取头节点的下个节点
            T element = front.data;
            // 将头的下一个指向，改成当前要删除的节点的下一个指向
            front = front.next;
            if (rear == node) {
                // 则说明删除到底了，成了空队列
                rear = front;
            }
            return element;
        }
    }

    public int length() {
        int count = 0;
        while (front != null) {
            count++;
            front = front.next;
        }
        return count;
    }
}
