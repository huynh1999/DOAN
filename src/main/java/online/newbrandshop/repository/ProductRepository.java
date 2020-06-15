/*
	@author:Quang Truong
	@date: Jan 21, 2020
*/

package online.newbrandshop.repository;

import java.util.List;

import online.newbrandshop.modal.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	@Transactional
	@Query("select r from ProductEntity r ")
	public List<ProductEntity> find20Product();

	ProductEntity findById(Long id);
	@Query(value = "select u from ProductEntity u where u.name like '%' || :keyword || '%'")
	public List<ProductEntity> search(@Param("keyword") String keyword);

	@Transactional
	@Query("delete from ProductEntity r where r.name = :name")
	void delete(String name);

	@Transactional
	@Query("select count (r.id) from ProductEntity r")
	long countTotalRecords();

	@Transactional
	@Query("select r from ProductEntity r")
	public List<ProductEntity> find10Products(Pageable pageable);

}
