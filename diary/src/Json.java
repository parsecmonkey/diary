package diary.src;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonPrimitive;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import diary.src.Json;

public class Json {
    private Gson gson;

    public Json() {
        this.gson = new Gson(); // Gsonのインスタンス
    }

    public void exportJSON() {

        String exe_path = System.getProperty("user.dir");
        String data_path = "/diary/data/";
        // final String SETTING_FILE_NAME = "setting.json";
        final String SETTING_FILE_NAME = "test.json";

        // Path path;
        try {
            // ファイルへの書き出し
            final String setting_file_path = exe_path + data_path + SETTING_FILE_NAME;
            System.out.println(setting_file_path);
            JsonWriter writer = new JsonWriter(new BufferedWriter(new FileWriter(setting_file_path)));

            this.gson.toJson(new JsonPrimitive("hello"), writer); // *
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static Path getApplicationPath(Class<?> cls) throws URISyntaxException {
        // jarの実行ファイル場所取得
        ProtectionDomain pd = cls.getProtectionDomain();
        CodeSource cs = pd.getCodeSource();
        URL location = cs.getLocation();
        URI uri = location.toURI();
        Path path = Paths.get(uri);
        return path;
    }

    public String toJson(Setting setting) {
        // debug_print(this.gson.toJson(setting), true);
        return this.gson.toJson(setting);
    }

    private static void debug_print(String text, boolean debug) {
        if (debug) {
            System.out.println(text);
        }
    }

}
