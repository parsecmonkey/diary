package diary.src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import diary.src.Json;
import diary.src.Setting;

class Main {
    public static void main(String args[]) {
        System.out.println("Start program.");

        // 設定の設定
        Setting setting = new Setting(); // 設定
        Json json = new Json(); // Json操作
        json.exportJSON();

        String settingString = json.toJson(setting); // 設定をJSONにする
        System.out.println(settingString);

        // ウィンドウ設定
        String window_title = setting.getWindow_title(); // タイトル
        int window_width = setting.getWindow_width(); // 高さ
        int window_height = setting.getWindow_height(); // 幅

        // Window window = new Window(window_title, window_width, window_height); //
        // ウィンドウを開く

    }


}
