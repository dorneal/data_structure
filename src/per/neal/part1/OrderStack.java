package per.neal.part1;

/**
 * 线性栈（基于顺序存储结构）
 *
 * @author Neal
 */
public class OrderStack<T> {
    private Node node;

    public OrderStack(int size) {
        this.node = new Node(size);
    }

    private class Node {
        T[] data;
        /**
         * 栈顶指针
         */
        int top;

        @SuppressWarnings("unchecked")
        Node(int size) {
            this.data = (T[]) new Object[size];
            this.top = -1;
        }
    }

    public void push(T element) {
        if (node.top == node.data.length - 1) {
            throw new IndexOutOfBoundsException("栈满了");
        }
        node.data[++node.top] = element;
    }

    public T pop() {
        if (node.top == -1) {
            throw new IndexOutOfBoundsException("栈是空的");
        }
        return node.data[node.top--];
    }

    public int length() {
        return node.top;
    }
}
