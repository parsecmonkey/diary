/*
 * ウィンドウの設定
*/
package diary.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class DiaryWindow extends Window {
    // 現在画面の日付
    protected String nowYear;
    protected String nowMonth;
    protected String nowDay;

    public final void setNowDate(String year, String month, String day) {
        this.nowYear = year;
        this.nowMonth = month;
        this.nowDay = day;
    }

    // ウィンドウの設定
    public DiaryWindow(String title, int width, int height) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 閉じるボタンの処理
        this.setTitle(title); // タイトルの設定
        this.setSize(width, height);// ウィンドウサイズ
        this.setLocationRelativeTo(null);// 画面中央に配置
        this.setResizable(false);// リサイズ禁止
    }

    // ウィンドウのテキスト設定
    public void setTextWindow() {
        JPanel panel = new JPanel(); // パネルのイン ス タンスの 生 成
        JLabel label = new JLabel(this.nowYear + "年 " + this.nowMonth + "月"); // ラベルのインスタンスの生成

        // テキスト設定
        label.setFont(new Font("MSGothic", Font.PLAIN, 30));
        label.setForeground(Color.BLUE);

        panel.add(label); // ラベルをパネルに配置
        this.add(panel, BorderLayout.NORTH); // パネルをウインドウの表示領域に配置
    }

    // ウィンドウのボタン設定
    public void setButtonWindow() {
        // JPanel panelAction = new JPanel();
        JPanel panel = new JPanel();

        // ボタンを追加
        // JButton btn1 = new JButton("Push");

        // ボタンクリック
        // btn1.addActionListener(new CreateEditWindow());

        // パネルに追加
        // panelAction.add(btn1);

        // その月の日数を取得
        // this.nowMonth = "2"; //debug
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(this.nowYear), Integer.parseInt(this.nowMonth) - 1, 1);
        int day_in_month = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int grid_row = 7;
        int grid_col = 5;
        GridLayout gridDate = new GridLayout(0, grid_row, 20, 20); // 行 列 横 縦
        panel.setLayout(gridDate);
        for (int i = 0; i < grid_row * grid_col; i++) {
            if (i < day_in_month) {
                JButton dateButton = new JButton("" + (i + 1));
                dateButton.addActionListener(new CreateEditWindow(this.nowYear, this.nowMonth, String.valueOf(i + 1)));
                panel.add(dateButton);
            } else { // 最大日付外 -> 枠だけ表示
                JButton dateButton = new JButton();
                dateButton.setEnabled(false);
                panel.add(dateButton);
            }
        }

        // ボタンを表示
        this.getContentPane().add(panel, BorderLayout.CENTER);
        // this.getContentPane().add(panelAction, BorderLayout.SOUTH);
    }

    // 日付ボタンクリック時のアクション
    static class CreateEditWindow implements ActionListener {

        private String nowYear;
        private String nowMonth;
        private String nowDay;

        public CreateEditWindow(String year, String month, String day) {
            this.nowYear = year;
            this.nowMonth = month;
            this.nowDay = day;
        }

        // 新しい画面の作成
        public void actionPerformed(ActionEvent e) {
            Debugger.out("CreateEditWindow");

            // ウィンドウ設定
            String window_title = String.format("%s年%s月%s日の日記", this.nowYear, this.nowMonth, this.nowDay); // タイトル
            int window_width = 400; // 高さ
            int window_height = 400; // 幅
            EditWindow editWindow = new EditWindow(window_title, window_width, window_height);

            // 日付
            editWindow.setNowDate(this.nowYear, this.nowMonth, this.nowDay);

            // アイコン
            editWindow.setImageIcon(Setting.icon_path);

            editWindow.setTextWindow(); // ウィンドウにテキストを表示
            editWindow.setTitle(window_title); // タイトルを設定
            editWindow.setTextArea("", 15); // ウィンドウにテキストエリアを設置
            editWindow.setBoxColor(); // ウィンドウに枠線カラー指定チェックボックスを設置

            editWindow.setVisible(); // 最後にウィンドウを表示

        }
    }
}
