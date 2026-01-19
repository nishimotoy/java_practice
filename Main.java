public class Main {
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = a;
        b[0] = 100;
        System.out.println(a[0]);


    }
}


/*
出力は 100
int[] b = a; 　　a の参照値を b にコピーしている、実態はひとつ

毎回 javac -encoding UTF-8 Main.java
*/
