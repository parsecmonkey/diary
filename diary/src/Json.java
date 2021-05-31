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

        // Path path;
        try {
            // 実行ファイルパスの取得
            Path path = getApplicationPath(Main.class);
            System.out.println("path=" + path + "\\diary\\data\\output.json");

            // ファイルへの書き出し
            JsonWriter writer = new JsonWriter(
                    new BufferedWriter(new FileWriter(path.toString() + "\\diary\\data\\output.json")));
            this.gson.toJson(new JsonPrimitive("hello"), writer);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static Path getApplicationPath(Class<?> cls) throws URISyntaxException {
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
