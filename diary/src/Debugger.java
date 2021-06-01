
package diary.src;

public class Debugger {
    // デバッグ
    //
    // ・ラベルの種類
    // inf: INF

    // protected boolean debug = false;
    protected boolean debug = true;

    public Debugger() {

    }

    // ラベル指定なし → INFとして出力
    public Debugger(String text) {
        if (this.debug) {
            System.out.println("INF: " + text);
        }
    }

    public Debugger(String text, String label) {
        if (this.debug) {
            if (label.equals("inf"))
                System.out.println("INF: " + text);
        }
    }

    public Debugger(String text, String label, boolean debug) {
        if (this.debug || debug) {
            if (label.equals("inf"))
                System.out.println("INF: " + text);
        }
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
