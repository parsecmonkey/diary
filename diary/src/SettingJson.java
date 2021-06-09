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

        Debugger.out(setting_file_path, "inf");

        try {
            write_setting(new File(setting_file_path), setting);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void write_setting(File file, Setting setting) throws IOException {
        // 設定ファイル書き込み
        try (JsonWriter writer = new JsonWriter(new FileWriter(file))) {
            writer.setIndent("    "); // インデント

            writer.beginObject();
            writer.name("window");
            writer.beginArray();

            writer.beginObject();
            writer.name("title").value(setting.getWindow_title());
            writer.name("width").value(setting.getWindow_width());
            writer.name("height").value(setting.getWindow_height());
            writer.endObject();

            writer.endArray();
            writer.endObject();
        }
    }

    // Json読み込み
    public Setting importJSON() {
        Setting setting = new Setting();
        try {
            JsonElement jsontree = JsonParser.parseReader(new FileReader(this.setting_file_path));
            JsonObject je = jsontree.getAsJsonObject();
            JsonArray ja = je.getAsJsonArray("window");
            for (Object o : ja) {
                JsonObject parameter = (JsonObject) o;
                setting.setWindow_title(parameter.get("title").getAsString());
                setting.setWindow_width(parameter.get("width").getAsInt());
                setting.setWindow_height(parameter.get("height").getAsInt());
            }
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return setting;
    }

    // setter and getter
    public void setSetting_file_name(String setting_file_name) {
        // 設定ファイルの名前
        this.setting_file_name = setting_file_name;
    }

}
