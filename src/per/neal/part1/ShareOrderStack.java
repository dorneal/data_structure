package per.neal.part1;

/**
 * 两栈共享空间
 *
 * @author Neal
 */
public class ShareOrderStack<T> {
    private Node node;

    public ShareOrderStack(int size) {
        node = new Node(size);
    }

    private class Node {
        /**
         * 数据区
         */
        private T[] data;
        /**
         * 栈1 栈顶指针
         */
        private int top1;
        /**
         * 栈2 栈顶指针
         */
        private int top2;

        @SuppressWarnings("unchecked")
        Node(int size) {
            this.data = (T[]) new Object[size];
            this.top1 = -1;
            this.top2 = size;
        }
    }

    public void push(T element, int choose) throws Exception {
        if (node.top1 + 1 == node.top2) {
            throw new IndexOutOfBoundsException("栈已经满了");
        }
        if (choose < 0 || choose > 2) {
            throw new Exception("没有这个选择");
        }
        if (choose == 1) {
            node.data[++node.top1] = element;
        } else if (choose == 2) {
            node.data[--node.top1] = element;
        }
    }

    public T pop(int choose) throws Exception {
        if (choose < 0 || choose > 2) {
            throw new Exception("没有这个选择");
        }
        if (choose == 1) {
            if (node.top1 == -1) {
                throw new IndexOutOfBoundsException("栈1是空的");
            }
            return node.data[node.top1--];
        } else if (choose == 2) {
            if (node.top2 == node.data.length) {
                throw new IndexOutOfBoundsException("栈2是空的");
            }
            return node.data[node.top2--];
        }
        return null;
    }
}
