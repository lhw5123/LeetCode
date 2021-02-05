public class DeadLockDemo {
    private String A;
    private String B;

    public DeadLockDemo(String A, String B) {
        this.A = A;
        this.B = B;
    }

    public void Do() {
        synchronized(A) {
            // do something
            System.out.println(A);
            synchronized(B) {
                // do something
                System.out.println(B);
            }
        }
    }
}

public class Main {
    public static void main(String args) {
        String A = "A";
        String B = "B";
        DeadLockDemo demo1 = new DeadLockDemo(A, B);
        DeadLockDemo demo2 = new DeadLockDemo(B, A);
        demo1.Do();
        demo2.Do();
    }
}
