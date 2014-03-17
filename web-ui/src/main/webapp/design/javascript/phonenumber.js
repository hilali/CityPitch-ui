/* This script is based on the javascript code of Roman Feldblum (web.developer@programmer.net) */
/* Original script : http:// javascript.internet.com/forms/format-phone-number.html */
/* Original script is revised by Eralper Yilmaz (http:// www.eralper.com) */
/* Revised script : http:// www.kodyaz.com */

var zChar = new Array(' ', '(', ')', '-', '.');
var maxphonelength = 12;
var phonevalue1;
var phonevalue2;
var cursorposition;

function ParseForNumber1(object) {

	phonevalue1 = ParseChar(object.value, zChar);
}

function ParseForNumber2(object) {

	phonevalue2 = ParseChar(object.value, zChar);
}

function backspacerUP(object, e) {

	var keycode;
	
	if (e == null) {
		e = window.event;
	}
	
	if (e.which) {
		keycode = e.which;
	} else {
		keycode = e.keyCode;
	}
	
	ParseForNumber1(object);
	
	if (keycode == 32 || keycode >= 48) {
		ValidatePhone(object);
	}
}

function backspacerDOWN(object, e) {

	ParseForNumber2(object);
}

function ValidatePhone(object) {

	var p = phonevalue1;
	
	p = p.replace(/[^\d]*/gi, "");
	
	if (p.length < 3) {
		object.value = p;
	} else if (p.length == 3) {
		pp = p;
		d5 = p.indexOf('-');
		if (d5 == -1) {
			pp = pp + "-";
		}
		object.value = pp;
	} else if (p.length > 3 && p.length < 6) {
		l30 = p.length;
		p30 = p.substring(0, 3);
		p30 = p30 + "-";
		
		p31 = p.substring(3, l30);
		pp = p30 + p31;
		
		object.value = pp;
		
	} else if (p.length >= 6) {
		l30 = p.length;
		p30 = p.substring(0, 3);
		p30 = p30 + "-";
		
		p31 = p.substring(3, l30);
		pp = p30 + p31;
		
		l40 = pp.length;
		p40 = pp.substring(0, 7);
		p40 = p40 + "-";
		
		p41 = pp.substring(7, l40);
		ppp = p40 + p41;
		
		object.value = ppp.substring(0, maxphonelength);
	}
	
}

function ParseChar(sStr, sChar) {

	if (sChar.length == null) {
		zChar = new Array(sChar);
	} else
		zChar = sChar;
	
	for ( var i = 0; i < zChar.length; i++) {
		sNewStr = "";
		
		var iStart = 0;
		var iEnd = sStr.indexOf(sChar[i]);
		
		while (iEnd != -1) {
			sNewStr += sStr.substring(iStart, iEnd);
			iStart = iEnd + 1;
			iEnd = sStr.indexOf(sChar[i], iStart);
		}
		sNewStr += sStr.substring(sStr.lastIndexOf(sChar[i]) + 1, sStr.length);
		
		sStr = sNewStr;
	}
	
	return sNewStr;
}