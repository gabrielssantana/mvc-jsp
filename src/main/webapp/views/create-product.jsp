<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Editar produto</title>
  </head>

  <body>
    <form action="<%=request.getContextPath() %>/create" method="post">
      <b>Nome</b>
      <br>
      <input name="nome" required="required" />
      <br>
      <b>Valor</b>
      <br>
      <input id="valor" name="valor" type="number" required="required" oninput="getValue()" />
      <br>
      <b>Desconto</b>
      <br>
      <input id="desconto" name="desconto" type="number" required="required" oninput="getValue()" />
      <br>
      <b>Valor após desconto</b>
      <br>
      <input id="valorAposDesconto" name="valorAposDesconto" required="required" readonly="readonly" />
      <br>
      <b>Descrição</b>
      <br>
      <input name="descricao" required="required" />
      <br>
      <input type="submit" value="Criar" />
    </form>
    <script type="text/javascript">
      function getValue() {
        var valor = document.getElementById("valor").value
        var desconto = document.getElementById("desconto").value
        document.getElementById("valorAposDesconto").value = valor - desconto
      }
    </script>
  </body>

  </html>