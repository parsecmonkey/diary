import java.util.ArrayList;
import java.util.List;

public class Setting {
    // メインのウィンドウ
    public static String window_title;
    public static int window_width;
    public static int window_height;
    public static String icon_path;// ファビコンパス

    // サブのウィンドウ
    public static String window_child_title;
    public static int window_child_width;
    public static int window_child_height;

    public static String exe_path;// 実行パス
    public static String data_path; // データディレクトリパス

    // 現在開いている日記編集ウィンドウのリスト
    public static List<String> open_edit_window_titles = new ArrayList<String>() {
        {
            add("");
        }
    };

    // public Setting() {
    // Setting.window_title = "日記";
    // Setting.window_width = 800;
    // Setting.window_height = 480;
    // }
}
