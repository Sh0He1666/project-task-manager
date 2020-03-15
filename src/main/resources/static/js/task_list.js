
//idに紐づく要素をゲット
var showAll = document.getElementById('showAll');
var showNoTouch = document.getElementById('showNoTouch');
var showProceeding = document.getElementById('showProceeding');
var showCompleted = document.getElementById('showCompleted');

//イベントリスナーを仕掛ける
showAll.addEventListener('click', function () {
    showRows("showAll");
})
showNoTouch.addEventListener('click', function () {
    showRows("未着手");
})
showProceeding.addEventListener('click', function () {
    showRows("進行中");
})
showCompleted.addEventListener('click', function () {
    showRows("処理済み");
})

//ステータスによって表示を切り替える
function showRows(target) {
    //ターゲットを取得
    var tgt = target;
    //変数を決める
    var tables = document.getElementsByClassName("tbl");
    var tableCnt = tables.length;
    var FLG = document.getElementByName
    var ttr = "";
    var ttd = "";
    //デバッグ
    console.log("tables");

    //テーブル数の数だけ処理を繰り返す
    for (i = 0; i < tableCnt; i++) {
        var table = tables[i];
        var rowCnt = table.rows.length;
        for (j = 0; j < rowCnt; j++) {
            ttr = table.rows[j];
            ttd = ttr.cells[4];
            if (tgt === "showAll" || !(ttd.textContent != tgt && ttd.textContent != "進捗状況")) {
                ttr.style.display = "";
            } else {
                ttr.style.display = "none";
                
            }
        }
    }
}

//ページ読み込みあとに実行するメソッド
window.onload = function () {
	    //テーブルを取得
	    var tables = document.getElementsByClassName("tbl");
	    var projectTitles = document.getElementsByClassName("project-name");
	    //テーブル数
	    var tableCnt = tables.length;
	    //カウンタ
	    var counter=0;
	    
	    //作業中・停止中ボタンを取得する
	    var ssBtns = document.getElementsByClassName("btn-submit");
	    var btnCnt = ssBtns.length;
	    

	  　//テーブルカラムがある場合はタスク一覧作成ボタン非表示
	    for (i = 0; i < tableCnt; i++) {
	        var table = tables[i];
	        var rowCnt = table.rows.length;
	        //テーブルにレコードなかったら非表示にする
	        if (rowCnt === 1) {
	        	table.style.display = "none";
	        	projectTitles[i].style.display = "none";
	        }
	        counter += rowCnt;
	    }
	    
	    if (counter != tableCnt) {
	    	createTablelistChecker.style.display = "none";
	    }
	    
	    //作業中・停止中の色を変える
	    for (i = 0; i < btnCnt; i++) {
	    	var btn = ssBtns[i];
	    	console.log(btn.value);
	    	if (btn.value === "停止中") {
	    		btn.style.backgroundColor = "rgba(255, 0, 0, 0.788)";
	    	} else if (btn.value === "作業中") {
	    		btn.style.backgroundColor = "rgba(6, 211, 57, 0.808)";	    		
	    	} else {
	    		btn.style.backgroundColor = "grey";
	    	}
	    }
}









