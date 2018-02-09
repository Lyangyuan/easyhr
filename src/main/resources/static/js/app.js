//检测输入框的内容
function checkInput(formId) {
    var inputs = $("#"+formId).serializeArray();
    for(var i in inputs){
        var value = inputs[i].value;
        if(value.trim().length === 0){
            return inputs[i].name;
        }
    }
    return "OK";
}

$(".form-control").blur(function () {
    if(this.value.trim().length === 0){
        $(this).next("span").css("color","red");
    } else {
        $(this).next("span").css("color","#bbbbbb");
    }
});