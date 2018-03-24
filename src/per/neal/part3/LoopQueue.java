package per.neal.part3;

/**
 * 循环队列(添加时，需要注意：添加元素的长度为指定size-1)
 * 会浪费一个空间
 *
 * @author Neal
 */
public class LoopQueue<T> {
    private class Node {
        private T[] data;
        private int front;
        private int rear;

        @SuppressWarnings("unchecked")
        Node(int size) {
            data = (T[]) new Object[size];
            this.front = this.rear = 0;
        }
    }

    private Node node;

    public LoopQueue(int size) {
        node = new Node(size);
    }

    public int queueLength() {
        return (node.rear - node.front + node.data.length) % node.data.length;
    }

    public void enQueue(T element) {
        if ((node.rear + 1) % node.data.length == node.front) {
            throw new IndexOutOfBoundsException("队列已经满了");
        } else {
            node.data[node.rear] = element;
            node.rear = (node.rear + 1) % node.data.length;
        }
    }

    public T deQueue() {
        if (node.front == node.rear) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        T data = node.data[node.front];
        node.front = (node.front + 1) % node.data.length;
        return data;
    }
}
