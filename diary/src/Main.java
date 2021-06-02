// メイン実行ファイル

package diary.src;

class Main {
    public static void main(String args[]) {
        new Debugger("Start program.", "inf");

        // 設定の設定
        Setting setting = new Setting(); // 設定
        SettingJson json = new SettingJson(); // Json操作

        final String exe_path = System.getProperty("user.dir");
        final String data_path = "/diary/data/"; // データディレクトリパス
        final String setting_file_name = "setting.json"; // ファイルの名前設定
        json.setExe_path(exe_path); // 実行ファイルパス設定
        json.setData_path(data_path); // データディレクトリパス設定
        json.setSetting_file_name(setting_file_name); // 設定ファイルの名前設定
        json.set_file_path();// 実行ファイルパス設定

        setting = json.importJSON(); // 設定を読み込む
        // json.exportJSON(setting); // 設定を出力する

        // ウィンドウ設定
        String window_title = setting.getWindow_title(); // タイトル
        int window_width = setting.getWindow_width(); // 高さ
        int window_height = setting.getWindow_height(); // 幅

        // ウィンドウを開く
        Window window = new Window(window_title, window_width, window_height);
        window.setTextWindow(window); // ウィンドウにテキストを表示
    }

}
