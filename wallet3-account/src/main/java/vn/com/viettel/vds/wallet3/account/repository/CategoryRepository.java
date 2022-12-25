package vn.com.viettel.vds.wallet3.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.viettel.vds.wallet3.account.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
