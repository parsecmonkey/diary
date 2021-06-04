/*
 * ウィンドウの設定
*/
package diary.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener {

    // ウィンドウの設定
    public Window(String title, int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 閉じるボタンの処理
        setTitle(title); // タイトルの設定
        setSize(width, height);// ウィンドウサイズ
        setLocationRelativeTo(null);// 画面中央に配置
        setResizable(false);// リサイズ禁止
        setVisible(true);// ウィンドウ表示
    }

    // ウィンドウのテキスト設定
    public void setTextWindow(Window window) {
        JPanel panel = new JPanel(); //パネルのインスタンスの生成
        JLabel label = new JLabel("LGTM!"); //ラベルのインスタンスの生成      

        // テキスト設定
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.BLUE);
        
        panel.add(label); //ラベルをパネルに配置
        window.add(panel, BorderLayout.CENTER); //パネルをウインドウの表示領域に配置
    }

    // ウィンドウのボタン設定
    public void setButtonWindow(Window window) {
        JPanel panel = new JPanel();

        // ボタンを追加
        JButton btn1 = new JButton("North");
        JButton btn2 = new JButton("Push");
        JButton btn3 = new JButton("West");
        JButton btn4 = new JButton("East");

        // ボタンクリック
        btn2.addActionListener(this);

        // パネルに追加
        panel.add(btn2);

        // ボタンを表示
        window.getContentPane().add(btn1, BorderLayout.NORTH);
        window.getContentPane().add(panel, BorderLayout.SOUTH);
        window.getContentPane().add(btn3, BorderLayout.WEST);
        window.getContentPane().add(btn4, BorderLayout.EAST);
    }

    // ボタンクリック時のアクション
    public void actionPerformed(ActionEvent e) {
        JLabel label = new JLabel("Push Button");
        JOptionPane.showMessageDialog(this, label);
    }
}
