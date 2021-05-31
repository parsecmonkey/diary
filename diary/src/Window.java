package diary.src;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window(String title, int width, int height) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 閉じるボタンの処理
        setSize(width, height);// ウィンドウサイズ
        setLocationRelativeTo(null);// 画面中央に配置
        setResizable(false);// リサイズ禁止
        setVisible(true);// ウィンドウ表示
    }
}
