package vn.com.viettel.vds.wallet3.cms.screen.registrationinformation;

import io.jmix.core.LoadContext;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.DataGrid;
import io.jmix.ui.component.Pagination;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    private CollectionLoader<RegistrationInformation> registrationInformationsDl;
    @Autowired
    private DataGrid<RegistrationInformation> registrationInformationsTable;
    @Autowired
    private Pagination pagination;

    @Install(to = "registrationInformationsDl", target = Target.DATA_LOADER)
    private List<RegistrationInformation> registrationInformationsDlLoadDelegate(
            LoadContext<RegistrationInformation> loadContext) {
        List<DataGrid.SortOrder> sortOrder = registrationInformationsTable.getSortOrder();
        Sort sort = Sort.unsorted();
        if (!sortOrder.isEmpty() && "category".equals(sortOrder.get(0).getColumnId())) {
            Sort.Direction direction = sortOrder.get(0)
                                                .getDirection() == DataGrid.SortDirection.ASCENDING ? Sort.Direction.ASC : Sort.Direction.DESC;
            sort = Sort.by(direction, "c.code");
        }
        int size = pagination.getDataBinder().getMaxResults();
        int page = pagination.getDataBinder().getFirstResult() / size;
        return kycManagementFeignClient.findAllRegistrationInformations(PageRequest.of(page, size, sort)).getContent();
    }

    @Subscribe("registrationInformationsTable")
    public void onRegistrationInformationsTableSort(DataGrid.SortEvent event) {
        registrationInformationsDl.load();
    }

    @Install(to = "pagination", subject = "totalCountDelegate")
    private Integer paginationTotalCountDelegate() {
        return kycManagementFeignClient.findAllRegistrationInformations(PageRequest.of(0, Integer.MAX_VALUE))
                                       .getTotalElements();
    }

    @Subscribe("registrationInformationsTable.remove")
    public void onRegistrationInformationsTableRemove(Action.ActionPerformedEvent event) {
        kycManagementFeignClient.delete(registrationInformationsTable.getSingleSelected().getId());
    }
}