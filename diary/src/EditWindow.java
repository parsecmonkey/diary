package diary.src;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
// import java.awt.event.*;

public class EditWindow extends Window {
    // 現在画面の日付
    private String nowYear;
    private String nowMonth;
    private String nowDay;

    public final void setNowDate(String year, String month, String day) {
        this.nowYear = year;
        this.nowMonth = month;
        this.nowDay = day;
    }

    // ウィンドウの設定
    public EditWindow(String title, int width, int height) {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 閉じるボタンの処理
        this.setTitle(title); // タイトルの設定
        this.setSize(width, height);// ウィンドウサイズ
        this.setLocationRelativeTo(null);// 画面中央に配置
        this.setResizable(false);// リサイズ禁止
    }

    // ウィンドウのテキスト設定
    public void setTextWindow() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(String.format("%s年 %s月 %s日", this.nowYear, this.nowMonth, this.nowDay));

        panel.add(label);

        this.getContentPane().add(panel, BorderLayout.PAGE_START);
    }

    // ウィンドウにテキストエリアを設置
    public void setTextArea(String firstText, int columns) {
        JTextArea textarea = new JTextArea(firstText); // テキストエリアの初期値を設定
        textarea.setColumns(columns); // テキストエリアの列数を指定
        textarea.setPreferredSize(new Dimension(300, 400)); // サイズを指定
        textarea.setLineWrap(true); // 折り返し指定

        JPanel panel = new JPanel();
        panel.add(textarea);

        this.getContentPane().add(panel, BorderLayout.CENTER);
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

        this.getContentPane().add(p, BorderLayout.PAGE_END);
    }

    // ウィンドウを閉じる際の処理
    @Override
    public void dispose() {
        Debugger.out(this.getTitle() + " ウィンドウが閉じられました");
        super.dispose();
    }
}
