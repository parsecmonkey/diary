package diary.src;

public class DiaryData {
    private int id;
    private int year;
    private int month;
    private int day;
    private String title;
    private String main_text;
    private int flag;

    DiaryData() {
        // 初期状態 id=-1を設定
        this.id = -1;
    }

    // public void set_all_data(int id, int year, int month, int day, String date,
    // String title, String main_text,
    // int flag) {
    // this.id = id;
    // this.year = year;
    // this.month = month;
    // this.day = day;
    // this.title = title;
    // this.main_text = main_text;
    // this.flag = flag;
    // }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMain_text() {
        return main_text;
    }

    public void setMain_text(String main_text) {
        this.main_text = main_text;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

}
