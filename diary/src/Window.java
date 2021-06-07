/*
 * ウィンドウの設定
*/
package diary.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {

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

    // アイコンを設定 ×
    public void setImageIcon(String image) {
        ImageIcon icon = new ImageIcon(image);
        setIconImage(icon.getImage());
    }

    // 背景色を設定 ×
    public void setBackground() {
        getContentPane().setBackground( Color.RED );
    }

    // ウィンドウのテキスト設定
    public void setTextWindow() {
        JPanel panel = new JPanel(); //パネルのインスタンスの生成
        JLabel label = new JLabel("LGTM!"); //ラベルのインスタンスの生成      

        // テキスト設定
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.BLUE);
        
        panel.add(label); //ラベルをパネルに配置
        add(panel, BorderLayout.CENTER); //パネルをウインドウの表示領域に配置
    }

    // ウィンドウのボタン設定
    public void setButtonWindow() {
        JPanel panel = new JPanel();

        // ボタンを追加
        JButton btn1 = new JButton("North");
        JButton btn2 = new JButton("Push");
        JButton btn3 = new JButton("West");
        JButton btn4 = new JButton("East");

        // ボタンクリック
        btn2.addActionListener(new Action1());

        // パネルに追加
        panel.add(btn2);

        // ボタンを表示
        getContentPane().add(btn1, BorderLayout.NORTH);
        getContentPane().add(panel, BorderLayout.SOUTH);
        getContentPane().add(btn3, BorderLayout.WEST);
        getContentPane().add(btn4, BorderLayout.EAST);
    }

    // ボタンクリック時のアクション
    static class Action1 implements ActionListener {
        // 新しい画面の作成
        public void actionPerformed(ActionEvent e) {
            Window window2 = new Window("a", 400, 400);
            window2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JLabel label = new JLabel("you clicked me");
            JPanel panel = new JPanel();
            window2.add(panel);
            panel.add(label);

            window2.setVisible();
        }
    }
}
