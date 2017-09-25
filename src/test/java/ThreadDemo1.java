

public class ThreadDemo1{
    private static Object obj = new Object();

    private static boolean isFinish=false;

    public static void main(String[] args) {
         Thread child = new Thread(){
            public void run(){

                System.out.println("进入子线程");
                for(int i=1;i<=10;i++){
                    System.out.println(
                            "子线程"+i
                    );
                }
                synchronized (obj) {
                    obj.notify();
                }


                System.out.println("子线程完毕!");
            }
        };

        Thread show = new Thread(){
            public void run(){
                try {
                    synchronized (obj) {
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                }
                for(int i=1;i<=100;i++){
                    System.out.println(
                            "主线程"+i
                    );
                }


            }
        };
        child.start();
        show.start();
    }
}



