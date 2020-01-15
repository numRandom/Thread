public class CreateThread2 {
    public static class MyThread extends Thread{
        private int n = 0;

        @Override
        public void run() {
            while(n < 10){
                System.out.println(n);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n++;
            }
        }
    }


    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new Thread(new MyRunnable());
        Thread thread3 = new Thread(new MyThread());
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {

        }
    }
}
