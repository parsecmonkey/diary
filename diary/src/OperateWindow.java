package diary.src;

public class OperateWindow {
    public OperateWindow(Setting setting) {
        // ウィンドウ設定
        String window_title = setting.getWindow_title(); // タイトル
        int window_width = setting.getWindow_width(); // 高さ
        int window_height = setting.getWindow_height(); // 幅
        Window window = new Window(window_title, window_width, window_height);

        window.setTextWindow(window); // ウィンドウにテキストを表示
        window.setButtonWindow(window); // ウィンドウにボタンを表示
        window.setImageIcon(window, "../img/kis_logo2.png"); // アイコンを設定
        window.setVisible(window); // 最後にウィンドウを表示
    }

}
