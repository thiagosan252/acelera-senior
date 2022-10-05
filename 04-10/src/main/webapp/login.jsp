<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<form method="post" action="login">

		<label>Usuário:</label> 
		<input type="text" name="username" />
		<label>Senha:</label> 
		<input type="text" name="password" />
		
		<label>Confirmar Senha:</label> 
		<input type="text" name="passwordConfirmation" />
		
		<input type="submit" /> 
	</form>

</body>
</html>