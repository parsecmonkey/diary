// メイン実行ファイル

class Main {
    public static void main(String args[]) {
        Debugger.out("Start program.", 0);

        // 設定の設定

        final String exe_path = System.getProperty("user.dir");
        final String data_path = "/diary/data/"; // データディレクトリパス
        final String setting_file_name = "setting.json"; // ファイルの名前設定
        Setting.exe_path = exe_path;
        Setting.data_path = data_path;
        Setting.icon_path = "./diary/img/kis_logo2.png"; // iconのパス

        SettingJson json = new SettingJson(); // Json操作
        json.setExe_path(exe_path); // 実行ファイルパス設定
        json.setData_path(data_path); // データディレクトリパス設定
        json.setSetting_file_name(setting_file_name); // 設定ファイルの名前設定
        json.set_file_path();// 実行ファイルパス設定

        json.importJSON(); // 設定を読み込む
        // json.exportJSON(setting); // 設定を出力する

        // ウィンドウを操作する
        OperateWindow operateWindow = new OperateWindow();
        operateWindow.CreateDiaryWindow();
    }

}
