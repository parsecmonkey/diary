package diary.src;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

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

}
