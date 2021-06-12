package diary.src;

// import javax.swing.*;
import java.awt.*;

public class OperateWindow {

    // メイン画面
    public void CreateWindow() {
        // ウィンドウ設定
        String window_title = Setting.window_title; // タイトル
        int window_width = Setting.window_width; // 高さ
        int window_height = Setting.window_height; // 幅
        Window window = new Window(window_title, window_width, window_height);

        window.setImageIcon("./diary/img/kis_logo2.png"); // アイコンを設定
        window.setBackground(Color.RED); // 背景設定 ×
        window.setTextWindow(); // ウィンドウにテキストを表示
        window.setButtonWindow(); // ウィンドウにボタンを表示

        window.setVisible(); // 最後にウィンドウを表示
    }

    // 編集画面
    public void CreateEditWindow() {
        // ウィンドウ設定
        String window_title = Setting.window_title; // タイトル
        int window_width = 400; // 高さ
        int window_height = 400; // 幅
        EditWindow window = new EditWindow(window_title, window_width, window_height);

        window.setTextWindow(); // ウィンドウにテキストを表示
        window.setTextArea("kis", 15); // ウィンドウにテキストエリアを設置

        window.setVisible(); // 最後にウィンドウを表示
    }

}
