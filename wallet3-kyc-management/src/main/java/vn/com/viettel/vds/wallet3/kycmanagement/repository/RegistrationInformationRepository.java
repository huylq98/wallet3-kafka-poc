package vn.com.viettel.vds.wallet3.kycmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.viettel.vds.wallet3.kycmanagement.entity.RegistrationInformation;

@Repository
public interface RegistrationInformationRepository extends JpaRepository<RegistrationInformation, Long> {
}
