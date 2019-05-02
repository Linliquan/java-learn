//JS Document 不能为空
function isBlank(str) {
	var re = /^\s*$/;
	return re.test(str);
}
//输入汉字
function isChinese(str) {
	var re = /^[\u4E00-\u9FA5]+$/;
	return re.test(str);
}
//输入英文
function isEnglish(str) {
	var re = /^[A-Za-z]+$/;
	return re.test(str);
}
//输入整数
function isInt(str) {
	var re = /^\d+/;
	return re.test(str);
}
//输入数字
function isNum(str) {
	var re = /^\d+(?:\.\d+)?/;
	return re.test(str);
}
//输入email
function isEmail(str) {
	var re = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	return re.test(str);
}
//输入电话
function isPhoneNum(str) {
	var re = /^(?:(?:\(0\d{2,3}\)[- ]?\d{7,8})|(?:(?:0\d{2,3}[- ]?)?\d{7,8})|(?:1\d{10}))$/;
	return re.test(str);
}
//输入18位身份证号
function isIdcardNum(str) {
	var re = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
	return re.test(str);
}
//输入IPv4地址
function isIPv4(str) {
	var re = /^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)$/;
	return re.test(str);
}
//输入HTTP URL
function isUrl(str) {
	var re = /^(https?:\/\/)?[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&amp;:/~\+#]*[\w\-\@?^=%&amp;/~\+#])?$/;
	return re.test(str);
}
//输入日期
function isDate(str) {
	var re = /^[1-2]\d{3}(-|\/)((0?[1-9]|1[0-2])(-|\/)(0?[1-9]|[1-2]\d))|((0?[13-9]|1[0-2])(-|\/)30)|((0?[13578]|1[02])(-|\/)31)$/;
	return re.test(str);
}
