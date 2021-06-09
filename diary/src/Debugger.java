
package diary.src;

public final class Debugger {
    // デバッグ
    //
    // ・ラベルの種類
    // inf: INF

    // 標準出力
    public static void out(String text) {
        System.out.println("INF: " + text);
    }

    public static void out(String text, String label) {
        if (label.equals("inf") || label.equals("INF"))
            System.out.println("INF: " + text);
        else
            System.out.println(label + ": " + text);
    }
}
