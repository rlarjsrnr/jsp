<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
<link href="../css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="../js/script.js"></script>

</head>
<body>
	<form action="regProc.jsp" method="post" name="regForm">

		<table border="1">

			<tr>
				<td colspan="2" align="center">회원가입 정보입력</td>
			</tr>

			<tr>
				<td align="right">아이디:</td>
				<td><input type="text" name="id">&nbsp; <input
					type="button" value="중복확인" 
					onClick="idCheck(this.form.id.value)"></td>
			</tr>



			<tr>
				<td align="right">비밀번호:</td>
				<td><input type="password" name="pass"></td>
			</tr>



			<tr>
				<td align="right">비밀번호 확인:</td>
				<td><input type="password" name="repass"></td>
			</tr>


			<tr>
				<td align="right">이름:</td>
				<td><input type="text" name="name"></td>
			</tr>



			<tr>
				<td align="right">전화번호:</td>
				<td><select name="phone1">
						<option value="02">02</option>
						<option value="032">032</option>
						<option value="033">033</option>
						<option value="042">042</option>
						<option value="010">010</option>
				</select>- 
				<input type="text" name="phone2" size="5"> 
				<input type="text" name="phone3" size="5">
				</td>
			</tr>
			
			
			
			<tr>
				<td align="right">이메일:</td>
				<td>
				<input type="text" name="email">
				</td>
			</tr>
			
			
			<tr>
				<td align="right">우편번호:</td>
				<td>
				<input type="text" name="zipcode">&nbsp; 
				<input type="button" value="찾기" onClick="zipCheck()">
				</td>
			</tr>
			
			
			<tr>
				<td align="right">주소1:</td>
				<td>
					<input type="text" name="address1" size="50">
				</td>
			</tr>
			 
			
			<tr>
				<td align="right">주소2:</td>
				<td>
					<input type="text" name="address2" size="30">
				</td>
			</tr>
			
			
			
			<tr>
				<td colspan="2" align="center">
				
					<input type="button" value="회원가입" onClick="inputCheck()">&nbsp;&nbsp;
					<input type="reset" value="다시입력">
				</td>
			</tr>
	
			
		</table>
	</form>
</body>
</html>