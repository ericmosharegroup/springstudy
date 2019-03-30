String.prototype.format = function () {
    if (arguments.length == 0) return this;
    var param = arguments[0];
    var s = this;
    if (typeof(param) == 'object') {
        for (var key in param)
            s = s.replace(new RegExp("\\{" + key + "\\}", "g"), param[key]);
        return s;
    } else {
        for (var i = 0; i < arguments.length; i++)
            s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
        return s;
    }
}


function change(fen) {
    var yuan = fen / 100.0;
    //保留2位小数点
    return yuan.toFixed(2);
}

/**
 * 比如 输入userId, 获得10086
 * 输入redirect, 获得/frontend/fundDebitDetail.html
 * @param str
 * @param key
 * @returns {string|*}
 */
function getFormValue(str, key) {
    //url=?userId=10086&id=4&accountName=%E7%8E%B0%E9%87%91%E9%92%B1%E5%8C%85&redirect=/frontend/fundDebitDetail.html

    if (isEmpty(str)) {
        return null;
    }
    var num = str.indexOf("?");
    str = str.substr(num + 1); //取得所有参数   stringvar.substr(start [, length ]

    var arr = str.split("&"); //各个参数放到数组里

    console.log(arr);

    for (var i = 0; i < arr.length; i++) {
        num = arr[i].indexOf("=");
        if (num > 0) {
            name = arr[i].substring(0, num);
            value = arr[i].substr(num + 1);

            if (name == key) {
                return value;
            }
        }
    }

}

function isEmpty(str) {

    if (str == null || str == '') {
        return true;
    }
}


function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    return year + seperator1 + month + seperator1 + strDate;
}