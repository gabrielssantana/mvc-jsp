<%@page import="model.Product" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Editar produto</title>
    </head>
    <% Product product=(Product)request.getAttribute("product");%>

      <body>
        <form action="<%=request.getContextPath() %>/edit/?id=<%=product.getID() %>" method="post">
          <b>Nome</b>
          <br>
          <input name="nome" required="required" value="<%=product.getNome() %>" />
          <br>
          <b>Valor</b>
          <br>
          <input id="valor" type="number" name="valor" required="required" value="<%=product.getValor() %>"
            oninput="getValue()" />
          <br>
          <b>Desconto</b>
          <br>
          <input id="desconto" type="number" name="desconto" required="required" value="<%=product.getDesconto() %>"
            oninput="getValue()" />
          <br>
          <b>Valor após desconto</b>
          <br>
          <input id="valorAposDesconto" name="valorAposDesconto" required="required"
            value="<%=product.getValorAposDesconto() %>" readonly="readonly" />
          <br>
          <b>Descrição</b>
          <br>
          <input name="descricao" required="required" value="<%=product.getDescricao() %>" />
          <br>
          <input type="submit" value="Editar" />
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