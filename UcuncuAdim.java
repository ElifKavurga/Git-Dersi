import java.util.*;
import java.util.concurrent.Semaphore;

public class UcuncuAdim {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        Semaphore semaphore = new Semaphore(1);

        int[] dizi=new int[100];
        int thradAdet;

        for(int i=0;i<100;i++){
            dizi[i]=random.nextInt(1000);
        }

        System.out.println("Baslangictaki diziniz");
        System.out.println(Arrays.toString(dizi));

        System.out.println("Dizini kac parçaya bolmek istersiniz");
        thradAdet=input.nextInt();

        MyThread[] threads=new MyThread[thradAdet];


    }

}

class MyThread implements Runnable {

    int[] dizi;
    int baslangic,son,threadAdet;

    MyThread(int[] dizi, int baslangic, int son, int threadAdet) {
        this.dizi = dizi;
        this.baslangic = baslangic;
        this.son = son;
        this.threadAdet = threadAdet;
    }

    @Override
    public void run() {
        int[] threadNo=new int[threadAdet];

        if(Thread.currentThread().getName().equals("Thread-1")){
            baslangic=0;
            son=100/threadAdet-1;
            Scanner input = new Scanner(System.in);
            Parca[] parcalar=new Parca[dizi.length];

            for(int i=0;i<threadAdet;i++){
                System.out.println(i+1+". parcayi hangi thread siralasin istersiniz");
                threadNo[i]=input.nextInt();
                parcalar[i]=new Parca(dizi,baslangic,son,threadNo[i]);
                baslangic=son+1;
                son=son+100/threadAdet;

                for(int j=i-1; j>=0;j--){
                    if(threadNo[j]==threadNo[i]){
                        System.out.println("Ayni thread birden fazla siralama yapamaz");
                        return;
                    }
                }
            }
        }
        Arrays.sort(dizi,baslangic,son+1);
        System.out.println(Thread.currentThread().getName()+"Siraladı");
        for (int i = baslangic; i < son; i++) {
            System.out.print(dizi[i] + " ");
        }
    }
}

class Parca{

    int baslangic,son,threadNumarasi;

    Parca(int[] dizi, int baslangic, int son, int threadNumarasi) {
        this.baslangic = baslangic;
        this.son = son;
        this.threadNumarasi = threadNumarasi;
    }

}

