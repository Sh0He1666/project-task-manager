

//動作確認

function myAlert() {
	alert("aaaaa");
}

var form = document.forms.delform;
 
form.alert_delete.addEventListener("click", function() {
  
    alert("aaaaaa");
  
}, false);


var alt_delete = document.getElementById("alert_delete");

alt_delete.addEventListener("click", function () {
    swal({
        title: "本当に削除しますか？",
        text: "一度削除したデータは元に戻すことができません。",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                swal("削除しました！", {
                    icon: "success",
                });
            }
        });
}, false);