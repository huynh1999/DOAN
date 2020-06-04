/*
	@author:Quang Truong
	@date: Jan 15, 2020
*/

package online.newbrandshop.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{

	@ManyToMany(mappedBy = "listCategories")
    private List<ProductEntity> listProducts = new ArrayList<>();
	
	@Column(name = "categoryname")
	private String categoryName;

	public List<ProductEntity> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<ProductEntity> listProducts) {
		this.listProducts = listProducts;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
