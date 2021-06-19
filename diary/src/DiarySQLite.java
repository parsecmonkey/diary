package diary.src;

import java.sql.*;

public class DiarySQLite {
    private DiaryData diaryData;

    protected Connection conn = null;
    protected Statement stm = null;

    protected String dbPath;
    protected String table_name;

    DiarySQLite(String dbPath) {

        this.dbPath = dbPath;
        this.diaryData = new DiaryData();

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

    private DiaryData setDiaryData(ResultSet resultSet) throws SQLException {
        DiaryData temp = new DiaryData();
        temp.setId(resultSet.getInt("id"));
        temp.setYear(resultSet.getInt("year"));
        temp.setMonth(resultSet.getInt("month"));
        temp.setDay(resultSet.getInt("day"));
        temp.setTitle(resultSet.getString("title"));
        temp.setMain_text(resultSet.getString("main_text"));
        temp.setFlag(resultSet.getInt("flag"));

        return temp;
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

    // -*-*-*-*-*-*-*-*-*-*-*-*-*-
    // select
    // -*-*-*-*-*-*-*-*-*-*-*-*-*-
    public void select(int id) {
        // idでselect
        try {
            final String select_sql = "select * from " + this.table_name + " where id = ? ";
            final PreparedStatement prepareStatement = this.conn.prepareStatement(select_sql);
            prepareStatement.setInt(1, id); // selectを実行
            ResultSet resultSet = prepareStatement.executeQuery();
            this.diaryData = this.setDiaryData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(int year, int month, int day) {
        // 日付でselect
        try {
            final String select_sql = "select * from " + this.table_name + " where year = ? and month = ? and day= ?";
            final PreparedStatement prepareStatement = this.conn.prepareStatement(select_sql);
            prepareStatement.setInt(1, year); // selectを実行
            prepareStatement.setInt(2, month); // selectを実行
            prepareStatement.setInt(3, day); // selectを実行
            ResultSet resultSet = prepareStatement.executeQuery();
            this.diaryData = this.setDiaryData(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select_all() {
        try {
            final String select_sql = "select * from " + this.table_name;
            final PreparedStatement prepareStatement = this.conn.prepareStatement(select_sql);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                DiaryData temp = this.setDiaryData(resultSet);
                this.diaryData.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select_month(int month) {
        // 日付でselect
        try {
            final String select_sql = "select * from " + this.table_name + " where month = ?";
            final PreparedStatement prepareStatement = this.conn.prepareStatement(select_sql);
            prepareStatement.setInt(1, month);
            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                DiaryData temp = this.setDiaryData(resultSet);
                this.diaryData.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * select文 終わり
     */

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

    // -*-*-*-*-*-*-*-*-*-*-*-*-*-
    // update
    // -*-*-*-*-*-*-*-*-*-*-*-*-*-
    public void update_title(int year, int month, int day, String title) {
        // 日付でselect
        try {
            final String select_sql = "update " + this.table_name
                    + " set title = ? where year = ? and month = ? and day = ?";
            final PreparedStatement prepareStatement = this.conn.prepareStatement(select_sql);
            prepareStatement.setString(1, title);
            prepareStatement.setInt(2, year);
            prepareStatement.setInt(3, month);
            prepareStatement.setInt(4, day);
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update_main(int year, int month, int day, String main) {
        // 日付でselect
        try {
            final String select_sql = "update " + this.table_name
                    + " set main_text = ? where year = ? and month = ? and day = ?";
            final PreparedStatement prepareStatement = this.conn.prepareStatement(select_sql);
            prepareStatement.setString(1, main);
            prepareStatement.setInt(2, year);
            prepareStatement.setInt(3, month);
            prepareStatement.setInt(4, day);
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update_flag(int year, int month, int day, int flag) {
        // 日付でselect
        try {
            final String select_sql = "update " + this.table_name
                    + " set flag = ? where year = ? and month = ? and day = ?";
            final PreparedStatement prepareStatement = this.conn.prepareStatement(select_sql);
            prepareStatement.setInt(1, flag);
            prepareStatement.setInt(2, year);
            prepareStatement.setInt(3, month);
            prepareStatement.setInt(4, day);
            prepareStatement.executeUpdate();

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

    public DiaryData getDiaryData() {
        return this.diaryData;
    }

    public void setDiaryData(DiaryData diaryData) {
        this.diaryData = diaryData;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

}
