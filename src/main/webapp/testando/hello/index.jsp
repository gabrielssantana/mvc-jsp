<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teste</title>
</head>
<%--
Todas as variáveis onde quer que estejam são acessadas pelo java
Imagine que o JSP é uma classe, tudo dentro da declaração <%! %> é colocada como atributo ou método da classe
e tudo dentro da <%%> é colocado dentro de um método especial que é quem retorna os valores para a tela, dentro de <%%> não
é possível declarar métodos, pois em java métodos dentro de métodos são proibidos.
O que está dentro de <%!%> ao recarregar a pagina ou ir para outra e voltar ou navegar novamente é conservado seu estado, mas o que esta dentro de <%%> é retornado ao valor inicial
 --%>
<%!
int i = 0;
boolean teste = true;
%>
<body>
<div>
<h1>
<%--Mano, isso aqui não consegue ser realtime --%>
<%
int local = 10;
while (teste) {
out.println(i++);
if (i == 5)
	{
	teste = false;
	out.println(local);
	}
}
%>
</h1>
<p>
<%--Isto substitui o println --%>
<%="Printando"%>
<%=(2+2)%>
</p>
<button
onclick="redirect(<%=teste %>)"
>Clickme</button>
</div>
<script type="text/javascript">
function redirect(any) {
	console.log(any)
}
</script>
</body>
</html>