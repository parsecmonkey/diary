/*
 * ウィンドウの設定
*/
package diary.src;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(String title, int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 閉じるボタンの処理
        setTitle(title); // タイトルの設定
        setSize(width, height);// ウィンドウサイズ
        setLocationRelativeTo(null);// 画面中央に配置
        setResizable(false);// リサイズ禁止
        setVisible(true);// ウィンドウ表示
    }

    public void setTextWindow(Window window) {
        //ウインドウの表示領域の取得
        Container container = window.getContentPane();
        
        //パネルのインスタンスの生成
        JPanel panel = new JPanel();
        
        //ラベルのインスタンスの生成
        //テキストのフォントと色の設定
        JLabel label = new JLabel("LGTM!");        
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.BLUE);
        
        //ラベルをパネルに配置
        panel.add(label);
        
        //パネルをウインドウの表示領域に配置
        container.add(panel, BorderLayout.CENTER);
        
        //ウインドウを表示
        window.setVisible(true);   
    }
}
