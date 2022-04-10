package controller;

import jakarta.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

import dao.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet("/")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDao;
       
    public ProductController() {
        this.productDao = new ProductDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String action = request.getServletPath();
		String id = request.getParameter("id");
		switch (action) {
		case "/create":
			try {
				this.handleSave(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/edit-page/":
			if (id != null) {
			request.setAttribute("product", this.productDao.firstOrDefault(Integer.parseInt(id)));
			dispatcher = request.getRequestDispatcher("/views/edit-product.jsp");
			dispatcher.forward(request, response);
			}
			break;
		case "/edit/":
			try {
				this.handleEdit(request, response, id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/delete/":
			if (id != null) {
			this.productDao.delete(Integer.parseInt(id));
			request.setAttribute("products", this.productDao.toList());
			dispatcher = request.getRequestDispatcher("/views/products.jsp");
			dispatcher.forward(request, response);
			}
			break;
		default:
			request.setAttribute("products", this.productDao.toList());
			dispatcher = request.getRequestDispatcher("/views/products.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private BigDecimal bigDecimalParse(String number) throws Exception {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);
		BigDecimal bigDecimal = (BigDecimal) decimalFormat.parse(number);
		return bigDecimal;
	}
	
	private void handleSave(HttpServletRequest request, HttpServletResponse response) throws Exception, Exception {
		RequestDispatcher dispatcher = null;
		Product product = new Product(
				request.getParameter("nome"),
				this.bigDecimalParse(request.getParameter("valor")),
				request.getParameter("descricao"),
				this.bigDecimalParse(request.getParameter("desconto")),
				this.bigDecimalParse(request.getParameter("valorAposDesconto")));
		this.productDao.save(product);
		request.setAttribute("products", this.productDao.toList());
		dispatcher = request.getRequestDispatcher("/views/products.jsp");
		dispatcher.forward(request, response);
	}
	
	private void handleEdit(HttpServletRequest request, HttpServletResponse response, String id) throws Exception, Exception {
		RequestDispatcher dispatcher = null;
		Product product = new Product(
				Integer.parseInt(id),
				request.getParameter("nome"),
				this.bigDecimalParse(request.getParameter("valor")),
				request.getParameter("descricao"),
				this.bigDecimalParse(request.getParameter("desconto")),
				this.bigDecimalParse(request.getParameter("valorAposDesconto")));
		this.productDao.update(product);
		request.setAttribute("products", this.productDao.toList());
		dispatcher = request.getRequestDispatcher("/views/products.jsp");
		dispatcher.forward(request, response);
	}

}
