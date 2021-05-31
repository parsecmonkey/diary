package diary.src;

public class Setting {
    private String window_title;
    private int window_width;
    private int window_height;

    public Setting() {
        this.window_title = "日記";
        this.window_width = 800;
        this.window_height = 480;
    }

    // getter and setter
    public String getWindow_title() {
        return window_title;
    }

    public int getWindow_width() {
        return window_width;
    }

    public int getWindow_height() {
        return window_height;
    }

    public void setWindow_title(String window_title) {
        this.window_title = window_title;
    }

    public void setWindow_width(int window_width) {
        this.window_width = window_width;
    }

    public void setWindow_height(int window_height) {
        this.window_height = window_height;
    }
}
