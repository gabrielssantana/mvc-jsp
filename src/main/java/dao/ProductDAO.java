package dao;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

import factory.ConnectionFactory;
import model.Product;

public class ProductDAO {

	public void save(Product product) {
		String sql = "INSERT INTO produto(nome, valor, descricao, desconto, valorAposDesconto) VALUES (?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			new ConnectionFactory();
			connection = ConnectionFactory.createConnectionToMySql();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, product.getNome());
			preparedStatement.setBigDecimal(2, product.getValor());
			preparedStatement.setString(3, product.getDescricao());
			preparedStatement.setBigDecimal(4, product.getDesconto());
			preparedStatement.setBigDecimal(5, product.getValorAposDesconto());
			preparedStatement.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
