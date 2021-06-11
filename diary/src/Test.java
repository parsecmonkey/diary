// メイン実行ファイル

package diary.src;

class Test {
    public static void main(String args[]) {
        Debugger.out("Start Test.", "inf");
        final String exe_path = System.getProperty("user.dir");
        final String data_path = "/diary/data/"; // データディレクトリパス
        final String dbName = "test.db";
        final String dbPath = exe_path + data_path + dbName; // データベースのパス

        SQLite sqlite = new SQLite(dbPath);
        sqlite.setup();

        Debugger.out("End Test.", "inf");
    }

}
