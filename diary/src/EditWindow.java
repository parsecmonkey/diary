package diary.src;

import javax.swing.*;
import javax.swing.border.LineBorder;
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

        getContentPane().add(panel, BorderLayout.PAGE_START);
    }

    // ウィンドウにテキストエリアを設置
    public void setTextArea(String firstText, int columns) {
        JTextArea textarea = new JTextArea(firstText); // テキストエリアの初期値を設定
        textarea.setColumns(columns); // テキストエリアの列数を指定
        textarea.setPreferredSize(new Dimension(200, 50)); // サイズを指定
        textarea.setLineWrap(true); // 折り返し指定

        JPanel panel = new JPanel();
        panel.add(textarea);

        getContentPane().add(panel, BorderLayout.CENTER);
    }

    // ウィンドウに枠線カラー指定チェックボックスを設置
    public void setBoxColor() {
        JCheckBox check1 = new JCheckBox();
        JCheckBox check2 = new JCheckBox();
        check1.setBorderPainted(true);
        check1.setBorder(new LineBorder(Color.RED, 2, false)); // 枠線の色を指定

        JPanel p = new JPanel();
        p.add(check1);
        p.add(check2);

        getContentPane().add(p, BorderLayout.PAGE_END);
    }
}
