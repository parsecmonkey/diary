package diary.src;

import java.sql.*;

public class SQLite {

    protected Connection conn = null;
    protected Statement stm = null;

    protected String dbPath;
    protected String table_name;

    SQLite(String dbPath) {
        this.dbPath = dbPath;

        try {
            // DBをOPENする
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);
            // conn.setAutoCommit(false); // 手動アップデート

            // 操作用インスタンスを取得する
            this.stm = this.conn.createStatement();
            this.stm.close();

            Debugger.out("DBを開きました dbPath:" + this.dbPath);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create_table() {
        try {
            // テーブルを生成する
            final String create_table_sql = "CREATE TABLE IF NOT EXISTS " + this.table_name
                    + "(id INTEGER PRIMARY KEY AUTOINCREMENT, year INTEGER, month INTEGER, day INTEGER, title TEXT, main_text TEXT, flag INTEGER)";
            this.stm.execute(create_table_sql);
            this.stm.close();

            Debugger.out(table_name + " TABLE を生成しました");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(int year, int month, int day, String title, String main_text, int flag) {
        try {
            this.conn.setAutoCommit(false);
            final String sql = "INSERT INTO " + this.table_name
                    + " (year, month, day, title, main_text, flag) values (?, ?, ?, ?, ?, ?)";
            final PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
            prepareStatement.setInt(1, year);
            prepareStatement.setInt(2, month);
            prepareStatement.setInt(3, day);
            prepareStatement.setString(4, title);
            prepareStatement.setString(5, main_text);
            prepareStatement.setInt(6, flag);
            prepareStatement.executeUpdate();
            this.conn.commit();
            this.conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void drop_table() {
        // テーブル削除
        try {
            final String drop_table = "DROP TABLE IF EXISTS " + this.table_name;
            this.stm.executeUpdate(drop_table);
            this.stm.close();
            Debugger.out(table_name + " TABLE を削除しました");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * DB CLOSE処理
     */
    public void dbClose() {

        try {
            if (stm != null && !stm.isClosed()) {
                // 操作用インスタンスをクローズする
                stm.close();
            }

            if (conn != null && !conn.isClosed()) {
                // DBをクローズする
                conn.close();
            }
            Debugger.out("DBを閉じました");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // getter and setter
    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

}
