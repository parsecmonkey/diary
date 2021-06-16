package diary.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonArray;

public final class SettingJson extends Json {

    private String setting_file_name; // setting.jsonの名前
    protected String setting_file_path; // 最終的なファイルパス

    public SettingJson() {
        super();
    }

    @Override
    public void set_file_path() {
        this.setting_file_path = exe_path + data_path + setting_file_name;
    }

    // ファイルへの書き出し
    public void exportJSON(Setting setting) {

        Debugger.out(setting_file_path, 0);

        try {
            write_setting(new File(setting_file_path), setting);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 設定ファイル書き込み
    private void write_setting(File file, Setting setting) throws IOException {

        try (JsonWriter writer = new JsonWriter(new FileWriter(file))) {
            writer.setIndent("    "); // インデント

            writer.beginObject();
            writer.name("window");
            writer.beginArray();

            writer.beginObject();
            writer.name("title").value(Setting.window_title);
            writer.name("width").value(Setting.window_width);
            writer.name("height").value(Setting.window_height);
            writer.endObject();

            writer.endArray();
            writer.endObject();
        }
    }

    // Json読み込み Settingクラスへ設定を入れ込む
    public void importJSON() {
        try {
            JsonElement jsontree = JsonParser.parseReader(new FileReader(this.setting_file_path));
            JsonObject je = jsontree.getAsJsonObject();
            JsonArray ja = je.getAsJsonArray("window");
            for (Object o : ja) {
                JsonObject parameter = (JsonObject) o;
                Setting.window_title = parameter.get("title").getAsString();
                Setting.window_width = parameter.get("width").getAsInt();
                Setting.window_height = parameter.get("height").getAsInt();
            }
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // setter and getter
    public void setSetting_file_name(String setting_file_name) {
        // 設定ファイルの名前
        this.setting_file_name = setting_file_name;
    }

}
