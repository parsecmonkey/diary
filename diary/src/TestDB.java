// メイン実行ファイル
// データベーステスト用

package diary.src;

class TestDB {
    public static void main(String args[]) {
        Debugger.out("Start Test.", 0);

        // dataパス設定
        final String exe_path = System.getProperty("user.dir");
        final String data_path = "/diary/data/"; // データディレクトリパス
        Setting.exe_path = exe_path;
        Setting.data_path = data_path;

        // DB操作
        OperateDB operateDB = new OperateDB();// DB操作インスタンス
        operateDB.reset(); // DBの情報をすべて消去する

        // 年，月，日，タイトル，日記本文，フラグ
        operateDB.add(2021, 6, 16, "タイトルっす", "本文でえすうよお", 0); // DBに情報を追加
        operateDB.add(2021, 6, 19, "タイトル2", "2", 1); // DBに情報を追加
        operateDB.add(2021, 7, 19, "タイトル3", "3", 0); // DBに情報を追加
        operateDB.add(2022, 1, 1, "2022", "1-1", 2); // DBに情報を追加

        // 日記データの構造取得
        DiaryData diaryData = new DiaryData();

        /*
         * 日記情報を取得する． DiaryData型で返ってくる
         *
         * 現状はidと日付指定，月指定ができる
         */
        diaryData = operateDB.get(1); // id=1の情報を取得
        Debugger.debug_out(diaryData.get());

        diaryData = operateDB.get(2021, 6, 19); // 引数指定はyyyy,mm,dd
        Debugger.debug_out(diaryData.get());

        diaryData = operateDB.get_month(6); // 6月の情報をすべて取得
        Debugger.debug_out(diaryData.pop()); // 0番目の情報を取得するのにはpopメソッドを使用(0番目は破壊される)(返り値はDiaryData型)
        // Debugger.debug_out(diaryData.pop());// もう無い場合はnullが返る

        diaryData.clear(); // DiaryData内の情報をすべて削除できる

        diaryData.add(operateDB.get(2021, 6, 19)); // 情報を追加できる
        diaryData.add(operateDB.get(2021, 7, 19)); // 情報を追加できる
        diaryData.add(operateDB.get(2021, 7, 19)); // 情報を追加できる

        Debugger.out("\n\n== output get all ==\n");
        while (diaryData.next()) { // nextで次の要素へ
            // diaryDataに所持している情報がなくなるまで
            Debugger.debug_out(diaryData.get());
        }

        diaryData.clear(); // 削除
        diaryData = operateDB.get_all(); // get_allメソッドでDB内の情報をすべて取得できる

        Debugger.out("\n\n== output select ==\n");
        while (diaryData.next()) {
            Debugger.debug_out(diaryData.get());
        }

        // DBを使用しなくなったらDBを閉じる(忘れないように)
        operateDB.closeDB();

        Debugger.out("End Test.", 0);
    }

}
