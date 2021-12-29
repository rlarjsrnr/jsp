function writeSave(){
	
	if(document.writeForm.writer.value==""){
		alert("작성자입력")
		document.writeForm.writer.focus();
		return false;
	}
	
	if(document.writeForm.email.value==""){
		alert("이메일입력")
		document.writeForm.email.focus();
		return false;
	}
	
	if(document.writeForm.subject.value==""){
		alert("제목입력")
		document.writeForm.subject.focus();
		return false;
	}
	
	if(document.writeForm.content.value==""){
		alert("내용입력")
		document.writeForm.content.focus();
		return false;
	}
	
	if(document.writeForm.pass.value==""){
		alert("비밀번호입력")
		document.writeForm.pass.focus();
		return false;
	}

}


function deleteSave(){
	
	if(document.delForm.pass.value==""){
alert("비밀번호 입력하기");
document.delForm.pass.focus();
return false;
		
	}
	
}



