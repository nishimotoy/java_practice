public class Main {
    public static void main(String[] args) {

        int score = 75;

        if (score >= 80) {
            System.out.println("合格（優）");
        } else if (score >= 60) {
            System.out.println("合格");
        } else {
            System.out.println("不合格");
        }

    }
}

/*
■ Java 日本語が通らないとき
原因:
  javac の既定文字コードが Windows-31J

対処:
  javac -encoding UTF-8 Main.java

よく使う:
  javac -encoding UTF-8 Main.java && java Main
*/
