package model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductService {
	
	public List<Product> getProducts() {
		return Arrays.asList(new Product("Mouse", new BigDecimal(100), "Objeto clicante", new BigDecimal(10), new BigDecimal(90)));
	}

}
