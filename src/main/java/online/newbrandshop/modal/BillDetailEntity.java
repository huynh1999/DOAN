/*
	@author:Quang Truong
	@date: Jan 15, 2020
*/

package online.newbrandshop.modal;

import javax.persistence.*;

@Entity
@Table(name = "billdetails")
public class BillDetailEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "billid")
	private BillEntity billEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid")
	private ProductEntity productEntity;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;
	
	@Column(name = "promotion")
	private int promotion;

	public BillEntity getBillEntity() {
		return billEntity;
	}

	public void setBillEntity(BillEntity billEntity) {
		this.billEntity = billEntity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quanity) {
		this.quantity = quanity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}

	
}
