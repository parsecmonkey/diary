/*
 * ウィンドウの設定
*/
package diary.src;

import javax.swing.JFrame;

public class Window extends JFrame {
    private String title;
    private int width;
    private int height;

    public Window(String title, int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 閉じるボタンの処理
        setTitle(title); // タイトルの設定
        setSize(width, height);// ウィンドウサイズ
        setLocationRelativeTo(null);// 画面中央に配置
        setResizable(false);// リサイズ禁止
        setVisible(true);// ウィンドウ表示
    }
}
