package diary.src;

import java.sql.*;

public class DiarySQLite extends SQLite {
    private DiaryData diaryData;

    DiarySQLite(String dbPath) {
        super(dbPath);
        this.diaryData = new DiaryData();
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

    // getter and setter

    public DiaryData getDiaryData() {
        return this.diaryData;
    }

    public void setDiaryData(DiaryData diaryData) {
        this.diaryData = diaryData;
    }

}
