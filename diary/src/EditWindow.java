package diary.src;

import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

public class EditWindow extends Window {

    // ウィンドウの設定
    public EditWindow(String title, int width, int height) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 閉じるボタンの処理
        setTitle(title); // タイトルの設定
        setSize(width, height);// ウィンドウサイズ
        setLocationRelativeTo(null);// 画面中央に配置
        setResizable(false);// リサイズ禁止
    }

    // ウィンドウを表示
    public void setVisible() {
        setVisible(true);// ウィンドウ表示
    }

    // ウィンドウのテキスト設定
    @Override
    public void setTextWindow() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("you clicked me");
        panel.add(label);
        add(panel);
    }

}
