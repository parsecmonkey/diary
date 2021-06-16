package diary.src;

import java.sql.*;

public class DiarySQLite extends SQLite {
    private DiaryData diaryData;

    DiarySQLite(String dbPath) {
        super(dbPath);
        this.diaryData = new DiaryData();
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
            ResultSet resultSet = prepareStatement.executeQuery();
            this.diaryData.set_all_data(resultSet.getInt("id"), resultSet.getString("date"),
                    resultSet.getString("title"), resultSet.getString("main_text"), resultSet.getInt("flag"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(String date) {
        // 日付でselect
        try {
            final String select_sql = "select * from " + this.table_name + " where date = ? ";
            final PreparedStatement prepareStatement = this.conn.prepareStatement(select_sql);
            prepareStatement.setString(1, date); // selectを実行
            ResultSet resultSet = prepareStatement.executeQuery();
            this.diaryData.set_all_data(resultSet.getInt("id"), resultSet.getString("date"),
                    resultSet.getString("title"), resultSet.getString("main_text"), resultSet.getInt("flag"));
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
