package diary.src;

import javax.swing.*;
import java.awt.*;
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

    // ウィンドウのテキスト設定
    @Override
    public void setTextWindow() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("you clicked me");
        panel.add(label);
        add(panel);

        getContentPane().add(panel, BorderLayout.PAGE_START);
    }

    // ウィンドウにテキストエリアを設置
    public void setTextArea(String firstText, int columns) {
        JTextArea textarea = new JTextArea(firstText); // テキストエリアの初期値を設定
        textarea.setColumns(columns); // テキストエリアの列数を指定
        textarea.setPreferredSize(new Dimension(200, 50)); // サイズを指定
        textarea.setLineWrap(true); // 折り返し指定

        JPanel p = new JPanel();
        p.add(textarea);

        getContentPane().add(p, BorderLayout.CENTER);
    }

}
