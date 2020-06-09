/*
	@author:Quang Truong
	@date: Jan 15, 2020
*/

package online.newbrandshop.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity{
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "productid"),
			inverseJoinColumns = @JoinColumn(name = "categoryid"))
	private List<CategoryEntity> listCategories = new ArrayList<>();

	@Column(name = "name")
	private String name;

	@Column(name = "amount")
	private int amount;

	@Column(name = "image")
	private String url1;

	@Column(name = "price")
	private String price;

	@Column(name = "promotion")
	private int promotion;

	@Column(name = "content")
	String content;


	public List<CategoryEntity> getListCategories() {
		return listCategories;
	}

	public void setListCategories(List<CategoryEntity> listCategories) {
		this.listCategories = listCategories;
	}

	public int getAmount() {
		return amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUrl1() {
		return url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
