import per.neal.part3.LinkedQueue;

/**
 * 测试类
 *
 * @author Neal
 */
public class Test {
    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        for (int i = 0; i < 5; i++) {
            linkedQueue.enQueue(i);
        }
        System.out.println(linkedQueue.length());
    }
}
