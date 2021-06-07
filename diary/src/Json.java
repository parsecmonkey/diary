package diary.src;

import com.google.gson.Gson;
// import com.google.gson.stream.JsonWriter;
// import com.google.gson.JsonPrimitive;
// import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.security.ProtectionDomain;

import diary.src.Json;

public class Json {
    protected Gson gson;
    protected String exe_path;// 実行ファイルパス
    protected String data_path; // データディレクトリのパス

    public Json() {
        this.gson = new Gson(); // Gsonのインスタンス
    }

    protected static Path getApplicationPath(Class<?> cls) throws URISyntaxException {
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


    public void set_file_path() {
    }

    public void exportJSON(Object object) {
    }

    public void importJSON(Object object) {
    }

    // getter and setter
    public void setExe_path(String exe_path) {
        // 実行ファイルのパス
        this.exe_path = exe_path;
    }

    public void setData_path(String data_path) {
        // dataディレクトリのパス
        this.data_path = data_path;
    }

}
