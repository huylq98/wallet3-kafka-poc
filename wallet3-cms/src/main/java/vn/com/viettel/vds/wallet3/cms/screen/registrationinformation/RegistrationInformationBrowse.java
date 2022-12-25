package vn.com.viettel.vds.wallet3.cms.screen.registrationinformation;

import io.jmix.core.LoadContext;
import io.jmix.ui.component.Pagination;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import vn.com.viettel.vds.wallet3.cms.entity.RegistrationInformation;
import vn.com.viettel.vds.wallet3.cms.feign.KycManagementFeignClient;

import java.util.List;

@UiController("RegistrationInformation.browse")
@UiDescriptor("registration-information-browse.xml")
@LookupComponent("registrationInformationsTable")
public class RegistrationInformationBrowse extends StandardLookup<RegistrationInformation> {

    @Autowired
    private KycManagementFeignClient kycManagementFeignClient;
    @Autowired
    private Pagination pagination;

    @Install(to = "registrationInformationsDl", target = Target.DATA_LOADER)
    private List<RegistrationInformation> registrationInformationsDlLoadDelegate(
            LoadContext<RegistrationInformation> loadContext) {
        int size = pagination.getDataBinder().getMaxResults();
        int page = pagination.getDataBinder().getFirstResult() / size;
        return kycManagementFeignClient.findAllRegistrationInformations(PageRequest.of(page, size)).getContent();
    }

    @Install(to = "pagination", subject = "totalCountDelegate")
    private Integer paginationTotalCountDelegate() {
        return kycManagementFeignClient.findAllRegistrationInformations(PageRequest.of(0, Integer.MAX_VALUE))
                                       .getTotalElements();
    }
}