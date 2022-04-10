package model;

import java.math.BigDecimal;

public class Product {
	
	private Integer ID;
	private String Nome;
	private BigDecimal Valor;
	private String Descricao;
	private BigDecimal Desconto;
	private BigDecimal ValorAposDesconto;
	
	public Product(String nome, BigDecimal valor, String descricao, BigDecimal desconto, BigDecimal valorAposDesconto) {
		super();
		Nome = nome;
		Valor = valor;
		Descricao = descricao;
		Desconto = desconto;
		ValorAposDesconto = valorAposDesconto;
	}

	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer iD) {
		ID = iD;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public BigDecimal getValor() {
		return Valor;
	}
	public void setValor(BigDecimal valor) {
		Valor = valor;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescrição(String descricao) {
		Descricao = descricao;
	}
	public BigDecimal getDesconto() {
		return Desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		Desconto = desconto;
	}
	public BigDecimal getValorAposDesconto() {
		return ValorAposDesconto;
	}
	public void setValorAposDesconto(BigDecimal valorAposDesconto) {
		ValorAposDesconto = valorAposDesconto;
	}
}
