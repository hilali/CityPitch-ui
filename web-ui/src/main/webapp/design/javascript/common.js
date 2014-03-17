//container width, used on redraw tables
var containerWidth = $('#container').width();

// menu style
ddsmoothmenu.init({
mainmenuid : "ddsmoothmenu", // menu DIV id
orientation : 'h', // Horizontal or vertical menu: Set to "h" or "v"
classname : 'ddsmoothmenu', // class added to menu's outer DIV
// custom theme: ["#1c5a80", "#18374a"],
contentsource : "markup" // "mark up" or ["container_id",
							// "path_to_menu_file"]
});

// button style
$(document).ready(function() {

	$("#toDayDate").val(formatDate(new Date(), "yyyy-MM-dd"));
	
	$("input:submit, input:reset, input:button, button").button();
	
	if (jQuery.validator) {
		jQuery.validator.addMethod("greaterThan", function(value, element, params) {

			return compareValues(value, element, params);
		}, 'Must be greater than {0}.');
		jQuery.validator.addMethod("lessThan", function(value, element, params) {

			return !compareValues(value, element, params);
		}, 'Must be less than {0}.');
	}
	
	manageEditableCombos();
	
	$("input[name='address.streetName'], input[name='streetName']").autocomplete({
		source: ctx + "/ref/streetname"
	});
});

function doLogoutEndOfShift(){
	if (confirm("All assigned leads will be released do you wish to continue?"))
		window.location = ctx + "/logout-end-of-shift";
}

/* date function */
var MONTH_NAMES = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December', 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec');
var DAY_NAMES = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat');
function LZ(x) {

	return (x < 0 || x > 9 ? "" : "0") + x;
}

function ftcClear() {

	$("input[type='text'], select").val('');
	$("input[type='checkbox']").removeAttr('checked');
	$("label.error").hide();
}

function ftcReset() {

	$("label.error").hide();
	
	return true;
}

function formatMilliseconds(val, format) {

	return formatDate(new Date(val), format);
}

function formatDate(date, format) {

	format = format + "";
	var result = "";
	var i_format = 0;
	var c = "";
	var token = "";
	var y = date.getFullYear() + "";
	var M = date.getMonth() + 1;
	var d = date.getDate();
	var E = date.getDay();
	var H = date.getHours();
	var m = date.getMinutes();
	var s = date.getSeconds();
	var yyyy, yy, MMM, MM, dd, hh, h, mm, ss, ampm, HH, H, KK, K, kk, k;
	// Convert real date parts into formatted versions
	var value = new Object();
	if (y.length < 4) {
		y = "" + (y - 0 + 2000);
	}
	value["y"] = "" + y;
	value["yyyy"] = y;
	value["yy"] = y.substring(2, 4);
	value["M"] = M;
	value["MM"] = LZ(M);
	value["MMM"] = MONTH_NAMES[M - 1];
	value["NNN"] = MONTH_NAMES[M + 11];
	value["d"] = d;
	value["dd"] = LZ(d);
	value["E"] = DAY_NAMES[E + 7];
	value["EE"] = DAY_NAMES[E];
	value["H"] = H;
	value["HH"] = LZ(H);
	if (H == 0) {
		value["h"] = 12;
	} else if (H > 12) {
		value["h"] = H - 12;
	} else {
		value["h"] = H;
	}
	value["hh"] = LZ(value["h"]);
	if (H > 11) {
		value["K"] = H - 12;
	} else {
		value["K"] = H;
	}
	value["k"] = H + 1;
	value["KK"] = LZ(value["K"]);
	value["kk"] = LZ(value["k"]);
	if (H > 11) {
		value["a"] = "PM";
	} else {
		value["a"] = "AM";
	}
	value["m"] = m;
	value["mm"] = LZ(m);
	value["s"] = s;
	value["ss"] = LZ(s);
	while (i_format < format.length) {
		c = format.charAt(i_format);
		token = "";
		while ((format.charAt(i_format) == c) && (i_format < format.length)) {
			token += format.charAt(i_format++);
		}
		if (value[token] != null) {
			result = result + value[token];
		} else {
			result = result + token;
		}
	}
	return result;
}

/*
 * Common validations functions
 */

function compareValues(value, element, params) {

	if (!/Invalid|NaN/.test(new Date(value))) {
		return new Date(value) > new Date($("#" + params).val());
	}
	
	return isNaN(value) && isNaN($("#" + params).val()) || (Number(value) > Number($("#" + params).val()));
}
/** ********************************************************************************************************** */
var EXPAND_IMG = new Array('details_close.png', 'details_open.png');
var EXPAND_TITLE = new Array('Click to Switch to criteria mode.', 'Click to Switch to drop down mode.');

function manageEditableCombo(fieldSelId) {

	var fieldSelId2 = fieldSelId + "2";
	var expandId = "expandId" + fieldSelId;
	var fieldSelFlagId = fieldSelId + "IdFlag";
	
	$("#" + fieldSelId2 + "").toggle(false);
	
	$("#" + expandId).click(function() {

		if ($("#" + fieldSelFlagId).val() == '1') {
			$("#" + expandId).attr("src", FOLDER_COMMON_IMG + EXPAND_IMG[1]);
			$("#" + expandId).attr("title", EXPAND_TITLE[1]);
			$("#" + fieldSelFlagId).val('0');
		} else {
			$("#" + expandId).attr("src", FOLDER_COMMON_IMG + EXPAND_IMG[0]);
			$("#" + expandId).attr("title", EXPAND_TITLE[0]);
			$("#" + fieldSelFlagId).val('1');
		}
		
		var fieldSel = $("#" + fieldSelId + "").select();
		$("#" + fieldSelId + "").attr("disabled", "disabled");
		$("#" + fieldSelId + "").toggle(false);
		
		$("#" + fieldSelId2 + "").attr("name", "fieldSelId3");
		$("#" + fieldSelId2 + "").attr("id", "fieldSelId3");
		
		$("#" + fieldSelId + "").attr("name", "" + fieldSelId2 + "");
		$("#" + fieldSelId + "").attr("id", "" + fieldSelId2 + "");
		
		$("#fieldSelId3").attr("name", "" + fieldSelId + "");
		$("#fieldSelId3").attr("id", "" + fieldSelId + "");
		
		$("#" + fieldSelId + "").toggle(true);
		$("#" + fieldSelId + "").removeAttr("disabled");
	});
}
function manageEditableCombos() {

	$("select[class='editable']")
			.each(function() {

				var fieldSelId = $(this).attr("id");
				
				var imgElement = "<img id='expandId" + fieldSelId + "' title='" + EXPAND_TITLE[0] + "' src='" + FOLDER_COMMON_IMG + EXPAND_IMG[0] + "'>&nbsp;";
				var inputElement = "<input type='text' id='" + fieldSelId + "2' name='" + fieldSelId + "2'/>";
				var hiddenElement = "<input type='hidden' id='" + fieldSelId + "IdFlag' name='" + fieldSelId + "IdFlag' value='1'/>";
				
				$(this).before(hiddenElement + imgElement + inputElement);
				
				manageEditableCombo(fieldSelId);
			});
	
}
