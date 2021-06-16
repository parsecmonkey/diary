// メイン実行ファイル
// データベーステスト用

package diary.src;

class TestDB {
    public static void main(String args[]) {
        Debugger.out("Start Test.", 0);

        OperateDB operateDB = new OperateDB();// DB操作インスタンス
        operateDB.reset(); // DBの情報をすべて消去する
        operateDB.add("2021-06-16", "タイトルっす", "本文でえすうよお", 0); // DBに情報を追加

        // 日記データの構造取得
        DiaryData diaryData = new DiaryData();

        /*
         * 日記情報を取得する． DiaryData型で返ってくる
         * 
         * 現状はidとdateの2種類のみ
         */
        diaryData = operateDB.get(1); // id=1の情報を取得
        Debugger.debug_out(diaryData);

        diaryData = operateDB.get("2021-06-16"); // 日付情報で取得
        // diaryData = operateDB.get("2021", "06", "16"); // 引数指定はyyyy,mm,ddでもOK
        Debugger.debug_out(diaryData);

        // DBを使用しなくなったらDBを閉じる(忘れないように)
        operateDB.closeDB();

        Debugger.out("End Test.", 0);
    }

}
