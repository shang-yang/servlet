	/**
	 *	method:
		 	请求方式，值为get或者post
		url:
			请求地址
		data:
			没有值需传入null
			有请求数据则传入字符串数据，格式为"a=1&b=2";
		deal200:
			接收一个带有一个形参的js函数对象，形参接收的实参是ajax引擎对象
		deal404:
			接收一个js函数对象
		deal500:
			接收一个js函数对象
	 *
	 */
	function myAjax(method,url,data,deal200,deal404,deal500,async) {
		// 创建Ajax引擎对象
		var ajax = getAjax();		
		// 复写onreadystatement函数
		ajax.onreadystatechange=function() {
			// 判断Ajax状态码
			if(ajax.readyState == 4) {
				// 判断响应状态码
				if(ajax.status == 200) {
					if(deal200) {
						deal200(ajax);
					}
				} else if (ajax.status == 404) {
					if(deal404) {
						deal404();
					}
				} else if (ajax.status == 500) {
					if(deal500) {
						deal500();
					}
				}
			} 
		}
		// 发送请求
		if("get" == method) {
			ajax.open("get",url+"?"+data,async);
			ajax.send(null);
		} else if("post" == method) {
			ajax.open("post",url,async);
			ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
			ajax.send(null);
		}
	}
	/*-----------------------------------------*/
	function getAjax() {
		var ajax;
		if(window.XMLHttpRequest) {
			ajax = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			ajax = new ActiveXObject("Msxml2.XMLHTTP")
		}
		return ajax;
	}