// import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class OperateWindow {

    // 今日の日付を取得

    // メイン画面
    public void CreateDiaryWindow() {
        // ウィンドウ設定
        final String window_title = Setting.window_title; // タイトル
        final int window_width = Setting.window_width; // 高さ
        final int window_height = Setting.window_height; // 幅
        final DiaryWindow diary_window = new DiaryWindow(window_title, window_width, window_height);

        // 初期日付設定
        diary_window.setNowDate(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)),
                String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1),
                String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));

        diary_window.setImageIcon(Setting.icon_path); // アイコンを設定
        diary_window.setBackground(Color.RED); // 背景設定 ×
        diary_window.setTextWindow(); // ウィンドウにテキストを表示
        diary_window.setButtonWindow(); // ウィンドウにボタンを表示

        diary_window.setVisible(); // 最後にウィンドウを表示
    }

}
