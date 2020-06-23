package online.newbrandshop.repository;

import online.newbrandshop.modal.MenuEntity;
import online.newbrandshop.modal.PayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    @Query("select p from MenuEntity p order by p.type")
    List<MenuEntity>findAllOrderByType();
}
