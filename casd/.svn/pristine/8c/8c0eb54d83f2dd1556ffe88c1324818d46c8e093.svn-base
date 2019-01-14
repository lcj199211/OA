/** * 时间对象的格式化; */
Date.prototype.format = function(format) {
	/** eg:format="yyyy-MM-dd hh:mm:ss"; */
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
	// millisecond
	}
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}

function datetime_formatter(value) {
	if (value == undefined)
		return "";
	try {
		date = eval(value.replace(/\/Date\((-?\d+)\)\//gi, "new Date($1)"));
	} catch (e) {
		date = new Date(value);
	}
	return date.format("yyyy-MM-dd hh:mm:ss");
}

function date_formatter(value) {
	if (value == undefined)
		return "";
	try {
		date = eval(value.replace(/\/Date\((-?\d+)\)\//gi, "new Date($1)"));
	} catch (e) {
		date = new Date(value);
	}
	return date.format("yyyy-MM-dd");
}

$.extend($.fn.validatebox.defaults.rules, {
	CHS : {
		validator : function(value, param) {
			return /^[\u0391-\uFFE5]+$/.test(value);
		},
		message : '请输入汉字'
	},
	ZIP : {
		validator : function(value, param) {
			return /^[1-9]\d{5}$/.test(value);
		},
		message : '邮政编码不存在'
	},
	QQ : {
		validator : function(value, param) {
			return /^[1-9]\d{4,10}$/.test(value);
		},
		message : 'QQ号码不正确'
	},
	mobile : {
		validator : function(value, param) {
			return /^((\(\d{2,3}\))|(\d{3}\-))?1[3458]\d{9}$/.test(value);
		},
		message : '手机号码不正确'
	},
	loginName : {
		validator : function(value, param) {
			return /^[a-zA-Z\u0391-\uFFE5][0-9a-zA-Z\u0391-\uFFE5_]{3,15}$/.test(value);
		},
		message : '登录名称只允许汉字、英文字母、数字及下划线，以汉字或者英文字母开头，4至16位。'
	},
	safepass : {
		validator : function(value, param) {
			/* 密码由字母和数字组成，至少6位 */
			return !(/^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/.test(value));
		},
		message : '密码由字母和数字组成，至少6位'
	},
	equalTo : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '两次输入的字符不一至'
	},
	// length: {
	// validator: function (value, param) {
	// var min = param[0];
	// var max = param[1];
	// return ((value.length <= max) && (value.length >= min));
	// },
	// message: '字符长度超出范围'
	// },
	number : {
		validator : function(value, param) {
			return /^\d+$/.test(value);
		},
		message : '请输入数字'
	}
});

function parseQuery(query) {
	var param = {};
	var array = query.split("&");
	for (var i = 0; i < array.length; i++) {
		var temp = $.trim(array[i]);
		if (temp == "")
			return param;
		var key = temp;
		var value = "";

		if (temp.indexOf("=") != -1) {
			key = temp.substring(0, temp.indexOf("="));
			value = temp.substring(temp.indexOf("=") + 1);
		}
		param[key] = param[key] ? param[key] + "," + value : value;
	}
	return param;
}

String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {
	if (!RegExp.prototype.isPrototypeOf(reallyDo)) {
		return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi" : "g")), replaceWith);
	} else {
		return this.replace(reallyDo, replaceWith);
	}
}
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
}
String.prototype.ltrim = function() {
	return this.replace(/(^\s*)/g, "");
}
String.prototype.rtrim = function() {
	return this.replace(/(\s*$)/g, "");
}

//easyui combobox下拉框模糊搜索
function serabox(q, row){  
    var opts = $(this).combobox('options');  
    return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
}
