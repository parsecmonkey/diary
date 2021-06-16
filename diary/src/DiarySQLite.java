package diary.src;

import java.sql.*;

public class DiarySQLite extends SQLite {
    private DiaryData diaryData;

    DiarySQLite(String dbPath) {
        super(dbPath);
        this.diaryData = new DiaryData();
    }

    private void setDiaryData(ResultSet resultSet) throws SQLException {
        this.diaryData.setId(resultSet.getInt("id"));
        this.diaryData.setYear(resultSet.getInt("year"));
        this.diaryData.setMonth(resultSet.getInt("month"));
        this.diaryData.setDay(resultSet.getInt("day"));
        this.diaryData.setTitle(resultSet.getString("title"));
        this.diaryData.setMain_text(resultSet.getString("main_text"));
        this.diaryData.setFlag(resultSet.getInt("flag"));
    }

    /*
     * select文 はじめ
     */
    public void select(int id) {
        // idでselect
        try {
            final String select_sql = "select * from " + this.table_name + " where id = ? ";
            final PreparedStatement prepareStatement = this.conn.prepareStatement(select_sql);
            prepareStatement.setInt(1, id); // selectを実行
            this.setDiaryData(prepareStatement.executeQuery());
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
            this.setDiaryData(prepareStatement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * select文 終わり
     */

    // getter and setter

    public DiaryData getDiaryData() {
        return diaryData;
    }

    public void setDiaryData(DiaryData diaryData) {
        this.diaryData = diaryData;
    }

}
