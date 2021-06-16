/*
 * ウィンドウの設定
*/
package diary.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {

    public Window() {
    }

    // ウィンドウの設定
    public Window(String title, int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 閉じるボタンの処理
        setTitle(title); // タイトルの設定
        setSize(width, height);// ウィンドウサイズ
        setLocationRelativeTo(null);// 画面中央に配置
        setResizable(false);// リサイズ禁止
    }

    // ウィンドウを表示
    public void setVisible() {
        setVisible(true);// ウィンドウ表示
    }

    // アイコンを設定
    public void setImageIcon(String image) {
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());
    }

    // 背景色を設定 ×
    public void setBackground(Color color) {
        getContentPane().setBackground(color);
    }

    // ウィンドウのテキスト設定
    public void setTextWindow() {
        JPanel panel = new JPanel(); //パネルのインスタンスの生成
        JLabel label = new JLabel("2021/06"); //ラベルのインスタンスの生成      

        // テキスト設定
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.BLUE);
        
        panel.add(label); //ラベルをパネルに配置
        add(panel, BorderLayout.NORTH); //パネルをウインドウの表示領域に配置
    }

    // ウィンドウのボタン設定
    public void setButtonWindow() {
        JPanel panelAction = new JPanel();
        JPanel panel = new JPanel();

        // ボタンを追加
        JButton btn1 = new JButton("Push");

        // ボタンクリック
        btn1.addActionListener(new Action1());

        // パネルに追加
        panelAction.add(btn1);

        // 日付ボタン設置
        GridLayout g1 = new GridLayout(0, 7, 20, 20); // 行 列 横 縦
        panel.setLayout(g1);
		for (int i = 0; i < 31; i++) {
            JButton btn = new JButton("" + (i+1));
            panel.add(btn);
		}

        // ボタンを表示
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(panelAction, BorderLayout.SOUTH);
    }

    // ボタンクリック時のアクション
    static class Action1 implements ActionListener {
        // 新しい画面の作成
        public void actionPerformed(ActionEvent e) {
            OperateWindow operateWindow = new OperateWindow();
            operateWindow.CreateEditWindow();
        }
    }
}
