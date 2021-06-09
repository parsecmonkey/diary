package diary.src;

import java.sql.*;

public class SQLite {

    Connection conn = null;
    Statement stm = null;

    private String dbPath;

    SQLite(String dbPath) {
        this.dbPath = dbPath;
    }

    public void setup() {

        // DBをOPENする
        try {
            // DBをOPENする
            conn = DriverManager.getConnection("jdbc:sqlite:" + this.dbPath);

            // 操作用インスタンスを取得する
            stm = conn.createStatement();
            stm.close();

            // テーブルがあれば削除する
            String sql = "DROP TABLE IF EXISTS TEST";
            stm.executeUpdate(sql);

            // テーブルを生成する
            sql = "CREATE TABLE IF NOT EXISTS TEST( " + "_id INTEGER PRIMARY KEY," + "_datetime TEXT,"
                    + "_image BLOB DEFAULT NULL ," + "_aspect REAL DEFAULT 1.0 CHECK( _aspect > 0 ) )";

            stm.executeUpdate(sql);
            stm.close();

            Debugger.out("TEST TABLE を生成しました");
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // DBをクローズする
            dbClose();
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public class setup {
    }
}
