package online.newbrandshop.repository;

import online.newbrandshop.modal.NameTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameTypeRepository extends JpaRepository<NameTypeEntity,Long> {
    NameTypeEntity findFirstByType(int type);
}
