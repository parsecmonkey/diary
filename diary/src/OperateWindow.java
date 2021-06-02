package diary.src;

public class OperateWindow {
    public OperateWindow(Setting setting) {
        // ウィンドウ設定
        String window_title = setting.getWindow_title(); // タイトル
        int window_width = setting.getWindow_width(); // 高さ
        int window_height = setting.getWindow_height(); // 幅
        Window window = new Window(window_title, window_width, window_height);
        window.setTextWindow(window); // ウィンドウにテキストを表示
    }

}
