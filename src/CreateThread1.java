public class CreateThread1 {
    public static void main(String[] args) {

//        Thread thread1 = new MyThread();
//        Thread thread2 = new MyThread();

//        Thread thread1 = new Thread(new MyThread());
//        Thread thread2 = new Thread(new MyThread());

        Runnable runnable = new Thread();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);



        thread1.start();
        thread2.start();
    }

    private static class MyThread extends Thread {
        private int n = 0;

        @Override
        public void run() {
            while(n < 10){
                System.out.println(n);
                try {
                    Thread.sleep(500);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                n++;
            }
        }
    }
}
