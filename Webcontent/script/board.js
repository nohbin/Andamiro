function dietCheck() {
	if (document.frm.diet_kind.value.length == 0) {
		alert("식단 종류를 입력하세요.");
		return false;
	}
	if (document.frm.diet_menu.value.length == 0) {
		alert("식단 메뉴를 입력하세요.");
		return false;
	}
	if (document.frm.diet_picture.value == 0) {
		alert("식단 이미지를 첨부하세요.");
		return false;
	}
	alert("식단이 수정되었습니다.");
	return true;
}

function dietWriteCheck(){
	if (document.frm.diet_kind.value.length == 0) {
		alert("식단 종류를 입력하세요.");
		return false;
	}
	if (document.frm.diet_picture.value == 0) {
		alert("식단 이미지를 첨부하세요.");
		return false;
	}
	if (document.frm.diet_menu.value.length == 0) {
		alert("식단 메뉴를 입력하세요.");
		return false;
	}
	alert("식단이 등록되었습니다.");
	return true;
}

function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}
function passCheck() {
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}