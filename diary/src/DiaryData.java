import java.util.ArrayList;
import java.util.List;

public class DiaryData {
    private List<DiaryData> listDiaryData = new ArrayList<DiaryData>();
    private int id;
    private int year;
    private int month;
    private int day;
    private String title;
    private String main_text;
    private int flag;

    DiaryData() {
        this.listDiaryData.add(this);
    }

    public void add(DiaryData diaryData) {
        this.listDiaryData.add(diaryData);
    }

    public DiaryData get() {
        return this.listDiaryData.get(0);
    }

    public DiaryData pop() {
        if (this.next())
            return this.get();
        else
            return null;
    }

    public DiaryData select(int idx_num) {
        List<DiaryData> temp = this.listDiaryData;
        DiaryData foundData = null;
        int i;
        for (i = 0; i <= idx_num; i++)
            foundData = this.pop();
        this.listDiaryData = temp;
        return foundData;
    }

    public void clear() {
        this.listDiaryData.clear();
        this.listDiaryData.add(this); // 消去しても自分自身を入れておく
    }

    public boolean next() {
        try {
            this.listDiaryData.get(1); // 次がなければここでExceptionが発生
            this.listDiaryData.remove(0);
            return true;
        } catch (IndexOutOfBoundsException e) { // listDiaryDataがカラであればnullを返す
            return false;
        }
    }

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
