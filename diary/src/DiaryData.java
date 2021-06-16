package diary.src;

public class DiaryData {
    public int id;
    public String date;
    public String title;
    public String main_text;
    public int flag;

    DiaryData() {
        // 初期状態 id=-1を設定
        this.id = -1;
    }

    public void set_all_data(int id, String date, String title, String main_text, int flag) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.main_text = main_text;
        this.flag = flag;
    }


}
