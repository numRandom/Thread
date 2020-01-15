public class CreateThreadTest {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        Thread thread1 = new MyThread1();
        Thread thread2 = new MyThread2();
        Thread thread3 = new MyThread3();

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        long end = System.currentTimeMillis();
        System.out.println((end - begin) * 1.0 / 1000);
    }

    public static class MyThread1 extends Thread{
        long sum = 0;
        @Override
        public void run() {
            for(int i = 1;i <= 100_0000;i++){
                sum += i;
            }
            System.out.println("1~1000000 的和为 "+sum);
        }
    }

    private static class MyThread2 extends Thread {
        long sum = 0;

        @Override
        public void run() {
            for(int i = 1;i <= 100_0001;i+=2){
                sum += i;
            }
            System.out.println("1~1000001 的奇数和为 "+sum);
        }
    }


    private static class MyThread3 extends Thread {
        long sum = 0;

        @Override
        public void run() {
            for(int i = 1;i<10_0000;i++){
                int tmp = i*i;
                sum += tmp;
            }
            System.out.println(sum);
        }
    }
}
