public class CreateThreadTest2 {
    private interface F{
        int f(int i);
    }

    private static class Calculator{
        public long cal(int n,F f){
            long sum = 0;
            for(int i = 1;i <= n; i++){
                sum += f.f(i);
            }
            return sum;
        }
    }

    private static class F1 implements F{

        @Override
        public int f(int i) {
            return i;
        }
    }

    private static class P1 extends Thread{
        @Override
        public void run() {
            int count = 100_0000;
            Calculator calculator = new Calculator();
            long sum = calculator.cal(count,new F1());
            System.out.println(sum);
        }
    }

    private static class P2 extends Thread{
        int count = 10_0000;

        @Override
        public void run() {
            Calculator calculator = new Calculator();
            long sum = calculator.cal(count,new F2());
            System.out.println("P2 "+sum);
        }
    }

    private static class F2 implements F{

        @Override
        public int f(int i) {
            return i*i;
        }
    }

    public static void main(String[] args) {
        new P1().start();
        new P2().start();
    }
}
