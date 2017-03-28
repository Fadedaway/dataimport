/**
 * Created by Administrator on 2017/3/28.
 */
function isExcel03(fileExt) {
    var fileExts = [ '.xls' ];
    if (fileExts.indexOf(fileExt.toLowerCase()) < 0 || !fileExt) {
        return false;
    } else {
        return true;
    }
}

$(function(){
    $("#excelScan").click(function(){
        $("#excelFile").click();
    });
    var obj =$("#excelFile");
    $("#excelFile").change({"obj":obj},function(event){
        var fileName = $('#excelFile').val();
        if (!fileName || fileName.indexOf('.') < 0) {
            alert("文件格式不正确");
            return;
        }else if (!isExcel03(fileName.substring(fileName.lastIndexOf('.')))) {
            alert("文件格式不正确");
            return;
        }else{
            $("#excelShow").val(event.data.obj.val());
        }
    });
});

/**
 * 上传文件
 */
function  submitExcel(){

    var excelShow = $("#excelShow");

    if(!!excelShow.val()&& excelShow.val()!=""){
        var _url = root+"/import/importExcelToDB";
        var form = $("#excelForm");
        var ajax_option = {
            url : _url,
            dataType:"json",
            success : function(res){
                if(res.success){
                    alert('导入成功!');
                    //setTimeout('toView()', 3000);
                }else{
                    alert('导入异常！');
                }
            },
            error : function(res){
                alert('导入失败!');
            }
        };
        form.ajaxSubmit(ajax_option);
    }else{
        alert("上传路径不能为空！");
    }
}