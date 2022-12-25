package vn.com.viettel.vds.wallet3.kycmanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.com.viettel.vds.wallet3.kycmanagement.entity.RegistrationInformation;

@Repository
public interface RegistrationInformationRepository extends JpaRepository<RegistrationInformation, Long> {

    @Query("select ri from RegistrationInformation ri join ri.category c")
    @Override
    Page<RegistrationInformation> findAll(Pageable pageable);
}
