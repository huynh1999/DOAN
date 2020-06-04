/*
	@author:Quang Truong
	@date: Feb 2, 2020
*/

package online.newbrandshop.repository;

import online.newbrandshop.modal.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BillRepository extends JpaRepository<BillEntity, Long> {

	BillEntity findOneByBillCode(String billCode);
}
