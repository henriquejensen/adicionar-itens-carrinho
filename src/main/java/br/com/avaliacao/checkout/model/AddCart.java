package br.com.avaliacao.checkout.model;

import java.io.Serializable;

public class AddCart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String cartId;
	Integer q; // quantidade do produto na compra
	String codeProduct;
	String nameProduct;
	String brand;
	Double price;
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public Integer getQ() {
		return q;
	}
	public void setQ(Integer q) {
		this.q = q;
	}
	public String getCodeProduct() {
		return codeProduct;
	}
	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

}
