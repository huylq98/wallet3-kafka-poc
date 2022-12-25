package vn.com.viettel.vds.wallet3.cms.screen.registrationinformation;

import io.jmix.core.EntityStates;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import vn.com.viettel.vds.wallet3.cms.entity.RegistrationInformation;
import vn.com.viettel.vds.wallet3.cms.feign.KycManagementFeignClient;

@UiController("RegistrationInformation.edit")
@UiDescriptor("registration-information-edit.xml")
@EditedEntityContainer("registrationInformationDc")
public class RegistrationInformationEdit extends StandardEditor<RegistrationInformation> {
    @Autowired
    private EntityStates entityStates;
    @Autowired
    private KycManagementFeignClient kycManagementFeignClient;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        if (entityStates.isNew(getEditedEntity())) {
            kycManagementFeignClient.save(getEditedEntity());
        } else {
            kycManagementFeignClient.save(getEditedEntity().getId(), getEditedEntity());
        }
    }
}