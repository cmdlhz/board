<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGN UP</title>
</head>
<body>
<form method="POST" action="/users/signup" onsubmit="return checkForm()">
	<table border="1">
		<tr>
			<td align="center"><b>First Name</b></td>
			<!-- name => key로 받아감 -->
			<td><input type="text" name="uiName" id="uiName"></td>
		</tr>
		<tr>
			<td align="center"><b>ID</b></td>
			<!-- name => key로 받아감 -->
			<td><input type="text" name="uiId" id="uiId"></td>
		</tr>
		<tr>
			<td align="center"><b>Password</b></td>
			<td><input type="password" name="uiPwd" id="uiPwd"></td>
		</tr>
				<tr>
			<td><b>Password Check</b></td>
			<td><input type="password" name="uiPwdCheck" id="uiPwdCheck"></td>
		</tr>
		<tr>
			<th colspan="2"><button>SIGN UP</button></th>
		</tr>
	</table>
</form>
<script>
function checkForm(){
	var uiName = document.getElementById("uiName");
	var uiId = document.getElementById("uiId");
	var uiPwd = document.getElementById("uiPwd");
	var uiPwdCheck = document.getElementById("uiPwdCheck");

	if(uiName.value.trim().length < 2){
		alert("A name should contain more than 2 characters.");
		uiName.value = "";
		uiName.focus();
		return false;
	}
	if(uiId.value.trim().length < 2){
		alert("An ID should contain more than 2 characters.");
		uiId.value = "";
		uiId.focus();
		return false;
	}
	if(uiPwd.value.trim().length < 5){
		alert("A password should contain more than 5 characters.");
		uiPwd.value = "";
		uiPwd.focus();
		return false;
	}
	if(uiPwd.value != uiPwdCheck.value){
		alert("Passwords do NOT match!");
		uiPwdCheck.value = "";
		uiPwdCheck.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>