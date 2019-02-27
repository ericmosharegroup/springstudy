//将form转为AJAX提交
function ajaxSubmit(form, callback) {
    var dataPara = transferFormToJson(form);

    console.log("dataPara:" + dataPara);

    $.ajax({
        url: form.action, //路径, 比如/user/create
        type: form.method,
        data: dataPara,
        success: function (data, status) {
            //成功
            console.info("call success:\n" + data.code);
            callback(data, status);
        },
        error: function (data, status) {
            //失败
            console.error("call fail:\n" + data.code);
            callback(data, status);
        }
    });
}

//将form中的值转换为键值对。
function transferFormToJson(form) {
    var arr = {}; //一个 map
    var a = $(form).serializeArray();
    $.each(a, function () {
        if (arr[this.name] !== undefined) {
            if (!arr[this.name].push) {
                arr[this.name] = [arr[this.name]];
            }
            arr[this.name].push(this.value || '');
        } else {
            arr[this.name] = this.value || '';
        }
    });

    return arr;
}

function sendAjax(url, data, callback) {
    $.ajax({
        url: url,
        type: "post",
        dataType: 'json',
        contentType: "application/json",
        data: data,
        success: function (data, status) {
            console.info("call success:" + data.code);
            callback(data, status);
        },
        error: function (data, status) {
            console.error("call failed:" + JSON.stringify(data));
            callback(data, status);
        }
    });
}

