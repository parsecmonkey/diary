// メイン実行ファイル
// データベーステスト用

package diary.src;

class Test {
    public static void main(String args[]) {
        Debugger.out("Start Test.", 0);
        final String exe_path = System.getProperty("user.dir");
        final String data_path = "/diary/data/"; // データディレクトリパス
        final String dbName = "test.db"; // データベースの名前
        final String dbPath = exe_path + data_path + dbName; // データベースのパス

        DiarySQLite sqlite = new DiarySQLite(dbPath);// データベースを作成(なければ)
        sqlite.setTable_name("TEST"); // DBのテーブルの名前を設定
        sqlite.drop_table(); // テーブルを削除
        sqlite.create_table(); // テーブルを作成する(なければ)

        sqlite.insert("2021-06-16", "タイトルっす", "本文でえすうよお", 0);// insert文を実行

        sqlite.select(1);// id=1の情報を取得

        sqlite.dbClose();// DBを閉じる

        Debugger.debug_out(sqlite.getDiaryData());// diaryData内の情報表示
        Debugger.out("End Test.", 0);
    }

}
