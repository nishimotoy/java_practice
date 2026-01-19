public class Main {

    public static void main(String[] args) {

        System.out.println("=== 実験1：int ===");

        int a = 10;
        System.out.println("main: a = " + a);

        changeInt(a);

        System.out.println("main after changeInt: a = " + a);

        System.out.println();
        System.out.println("=== 実験2：int[] ===");

        int[] arr = {10, 20, 30};
        System.out.println("main: arr[0] = " + arr[0]);

        changeArray(arr);

        System.out.println("main after changeArray: arr[0] = " + arr[0]);
    }

    // 実験1
    static void changeInt(int x) {
        System.out.println("changeInt: x (before) = " + x);
        x = 100;
        System.out.println("changeInt: x (after) = " + x);
    }

    // 実験2
    static void changeArray(int[] y) {
        System.out.println("changeArray: y[0] (before) = " + y[0]);
        y[0] = 100;
        System.out.println("changeArray: y[0] (after) = " + y[0]);
    }
}

/*

int[] b = a; 　　a の参照値を b にコピーしている、実態はひとつ
int double boolean char byte short long floatは値（プリミティブ）、
int[]（配列）、String（文字列）、クラスはオブジェクト
型によって決まっている

毎回 javac -encoding UTF-8 Main.java
*/
