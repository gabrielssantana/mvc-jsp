<%@page import="java.math.BigDecimal" %>
  <%@page import="model.Product" %>
    <%@page import="java.util.List" %>
      <%@page import="java.util.Arrays" %>
        <%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
          <!DOCTYPE html>
          <html>

          <head>
            <meta charset="UTF-8">
            <title>Produtos</title>
          </head>
          <% List<Product> products = (List<Product>)request.getAttribute("products");
              %>

              <body>
                <table border="1">
                  <thead>
                    <tr>
                      <td>Nome</td>
                      <td>Descrição</td>
                      <td>Valor</td>
                      <td>Desconto</td>
                      <td>Valor após desconto</td>
                      <td colspan="2"><a href="<%=request.getContextPath() %>/views/create-product.jsp">Cadastrar
                          produto</a></td>
                    </tr>
                  </thead>
                  <tbody>
                    <%for (Product product : products){ %>
                      <tr>
                        <td>
                          <%=product.getNome()%>
                        </td>
                        <td>
                          <%=product.getDescricao()%>
                        </td>
                        <td>
                          <%=product.getValor()%>
                        </td>
                        <td>
                          <%=product.getDesconto()%>
                        </td>
                        <td>
                          <%=product.getValorAposDesconto()%>
                        </td>
                        <td>
                          <a href="<%=request.getContextPath() %>/edit-page/?id=<%=product.getID() %>">Editar</a>
                        </td>
                        <td>
                          <a href="<%=request.getContextPath() %>/delete/?id=<%=product.getID() %>">Excluir</a>
                        </td>
                      </tr>
                      <%};%>
                  </tbody>
                </table>
              </body>

          </html>