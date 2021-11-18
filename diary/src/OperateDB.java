public class OperateDB {
    private DiarySQLite sqlite;
    private String dbPath;
    private final String table_name = "Diary";

    public OperateDB() {
        final String exe_path = Setting.exe_path;// 実行パス
        final String data_path = Setting.data_path; // データディレクトリパス
        final String dbName = "diary.db"; // データベースの名前
        final String dbPath = exe_path + data_path + dbName; // データベースのパス

        this.dbPath = dbPath; // DBのパス設定

        this.createDB(); // DBとテーブルを作成する

    }

    private void createDB() {
        // DB作成とテーブル作成
        this.sqlite = new DiarySQLite(this.dbPath);// データベースを作成(なければ)

        this.sqlite.setTable_name(this.table_name); // DBのテーブルの名前を設定

        this.sqlite.create_table(); // テーブルを作成する(なければ)
    }

    public void reset() {
        this.sqlite.drop_table(); // テーブルを削除
        this.sqlite.create_table();
    }

    public void add(int year, int month, int day, String title, String diary_main_text, int flag) {
        this.sqlite.insert(year, month, day, title, diary_main_text, flag);// insert文を実行
    }

    // -*-*-*-*-*-*-*-*-*-*-*-*-*-
    // get
    // -*-*-*-*-*-*-*-*-*-*-*-*-*-
    public DiaryData get(int id) {
        this.sqlite.select(id);// id=1の情報を取得
        return this.sqlite.getDiaryData();
    }

    public DiaryData get(int year, int month, int day) {
        this.sqlite.select(year, month, day);// 日付情報で取得
        return this.sqlite.getDiaryData();
    }

    public DiaryData get_month(int month) {
        // 月のみで指定
        this.sqlite.select_month(month);// 日付情報で取得
        return this.sqlite.getDiaryData();
    }

    public DiaryData get_all() {
        // すべて取得
        this.sqlite.select_all();// すべて取得
        return this.sqlite.getDiaryData();
    }
    // get終わり

    // -*-*-*-*-*-*-*-*-*-*-*-*-*-
    // change
    // -*-*-*-*-*-*-*-*-*-*-*-*-*-
    public void change_title(DiaryData diaryData, String title) {
        // title変更
        this.sqlite.update_title(diaryData.getYear(), diaryData.getMonth(), diaryData.getDay(), title);// update文を実行
        Debugger.out("UPDATE year, month, day, title: " + String.valueOf(diaryData.getYear()) + ", "
                + String.valueOf(diaryData.getMonth()) + ", " + String.valueOf(diaryData.getDay()) + ", " + title, 0);
    }

    public void change_main(DiaryData diaryData, String main) {
        // main変更
        this.sqlite.update_main(diaryData.getYear(), diaryData.getMonth(), diaryData.getDay(), main);// update文を実行
        Debugger.out("UPDATE year, month, day, main_text: " + String.valueOf(diaryData.getYear()) + ", "
                + String.valueOf(diaryData.getMonth()) + ", " + String.valueOf(diaryData.getDay()) + ", " + main, 0);
    }

    public void change_flag(DiaryData diaryData, int flag) {
        // main変更
        this.sqlite.update_flag(diaryData.getYear(), diaryData.getMonth(), diaryData.getDay(), flag);// update文を実行
        Debugger.out("UPDATE year, month, day, flag: " + String.valueOf(diaryData.getYear()) + ", "
                + String.valueOf(diaryData.getMonth()) + ", " + String.valueOf(diaryData.getDay()) + ", "
                + String.valueOf(flag), 0);
    }
    // change 終わり

    public void closeDB() {
        this.sqlite.dbClose();// DBを閉じる
    }

    // setter and getter

    public String getDbPath() {
        return dbPath;
    }

    // public void setDbPath(String dbPath) {
    // this.dbPath = dbPath;
    // }
}
