package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
	
	public void update(Product product) {
		String sql = "UPDATE produto SET nome=?, valor=?, descricao=?, desconto=?, valorAposDesconto=? WHERE id=?";
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
			preparedStatement.setInt(6, product.getID());
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
	
	public void delete(int id) {
		String sql = "DELETE from produto WHERE id=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			new ConnectionFactory();
			connection = ConnectionFactory.createConnectionToMySql();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
	
	public List<Product> toList() {
		String sql = "SELECT * FROM produto";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Product> products = new ArrayList<Product>();
		try {
			new ConnectionFactory();
			connection = ConnectionFactory.createConnectionToMySql();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Product product = new Product();
				product.setID(resultSet.getInt("id"));
				product.setNome(resultSet.getString("nome"));
				product.setValor(resultSet.getBigDecimal("valor"));
				product.setDescricao(resultSet.getString("descricao"));
				product.setDesconto(resultSet.getBigDecimal("desconto"));
				product.setValorAposDesconto(resultSet.getBigDecimal("valorAposDesconto"));
				products.add(product);
			}
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
		return products;
	}
	
	public Product firstOrDefault(int id) {
		String sql = "SELECT * FROM produto WHERE id=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Product foundProduct = null;

		try {
			new ConnectionFactory();
			connection = ConnectionFactory.createConnectionToMySql();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Product product = new Product();
				product.setID(resultSet.getInt("id"));
				product.setNome(resultSet.getString("nome"));
				product.setValor(resultSet.getBigDecimal("valor"));
				product.setDescricao(resultSet.getString("descricao"));
				product.setDesconto(resultSet.getBigDecimal("desconto"));
				product.setValorAposDesconto(resultSet.getBigDecimal("valorAposDesconto"));
				foundProduct = product;
			}
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
		return foundProduct;
	}
}
