$(function() {
	var sessionId = $('#sessionId').val();
	if (sessionId==""||sessionId==null) {
		$('#logoutPart').hide();
	} else {
		$('#loginPart').hide();
	}
});

$("#deleteBtn").click(function(){
	location.href="Delete.do?bId="+$("#bId").val();
})
$("#replyBtn").click(function(){
	location.href="ReplyView.do?bId="+$("#bId").val();
})
$("#listBtn").click(function(){
	location.href="BList.do";
})
$("#list2Btn").click(function(){
	location.href="BList.do";
})
$("#cancel1Btn").click(function(){
	location.href="login";
})
$("#loginBtn").click(function(){
	location.href="login";
})
$("#logoutBtn").click(function(){
	location.href="Logout.do";
})
$("#writeBtn").click(function(){
	location.href="writeView";
})
$("#joinUsBtn").click(function(){
	location.href="join";
})
$("#infoModifyBtn").click(function(){
	location.href="modify";
})
$("#cancel2Btn").click(function(){
	location.href="main";
})
$("#searchBtn").click(function(){
	location.href="search";
})
$("#reCommentBtn").click(function(){
	location.href="ReComment.do?cId="+$("#cId").val();
})
$("#prevPageBtn").click(function(){
	location.href="BList.do?currentPage="+$("#prevPageBtn").val();
})
$("#firstPageBtn").click(function(){
	location.href="BList.do?currentPage="+$("#firstPageBtn").val();
})
$("#currentPageBtn").click(function(){
	location.href="BList.do?currentPage="+$("#currentPageBtn").val();
})
$("#totalPageBtn").click(function(){
	location.href="BList.do?currentPage="+$("#totalPageBtn").val();
})
$("#nextPageBtn").click(function(){
	location.href="BList.do?currentPage="+$("#nextPageBtn").val();
})


$(document).ready(function(){
	$("#registerCheck").click(function(){
		if(document.regForm.id.value.length == 0) {
			alert("아이디는 필수 사항입니다.");
			regForm.id.focus();
			return;
		}
		if(document.regForm.id.value.length < 4) {
			alert("아이디는 4글자 이상이어야 합니다.");
			regForm.id.focus();
			return;
		}
		if(document.regForm.pw.value.length == 0) {
			alert("비밀번호는 필수 사항입니다.");
			regForm.pw.focus();
			return;
		}
		if(document.regForm.pw.value != document.regForm.pwCheck.value) {
			alert("비밀번호가 일치하지 않습니다.");
			regForm.pw.focus();
			return;
		}
		if(document.regForm.name.value.length == 0) {
			alert("이름은 필수 사항입니다.");
			regForm.name.focus();
			return;
		}
		document.regForm.submit();
	});
});

$(document).ready(function(){
	$("#registerCheck2").click(function(){
	if(document.regForm.pw.value == "") {
		alert("패스워드를 입력하세요.");
		document.reg_frm.pw.focus();
		return;
	}
	if(document.regForm.pw.value != document.regForm.pwCheck.value) {
		alert("패스워드가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}
	if(document.regForm.name.value.length == 0) {
		alert("이름은 필수 사항입니다.");
		regForm.name.focus();
		return;
	}
	document.regForm.submit();
	});
});
