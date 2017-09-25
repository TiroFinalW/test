/**
 * Created by wang on 2017/4/13.
 */
public class ThreadDemo {
    public static void main(String[] args){
        int i=0;
        int j=0;
        boolean flag1=false;
        boolean flag2=true;
        Thread thread1 = new Thread(){
           public void run(){
               for(int i=0;i<10;i++){
                   System.out.println("子线程输出"+i);
                   if(i==9){

                   }
               }
            }
        };

        Thread thread2 = new Thread(){
            public void run(){
                for(int i=0;i<100;i++){
                    System.out.println("主线程输出"+i);
                }
            }
        };
        for(int m=0;i<2;i++){
            thread1.start();
            thread2.start();
        }
    }
}
