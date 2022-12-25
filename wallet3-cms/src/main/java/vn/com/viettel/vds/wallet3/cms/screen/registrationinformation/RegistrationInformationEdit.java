package vn.com.viettel.vds.wallet3.cms.screen.registrationinformation;

import io.jmix.ui.screen.*;
import vn.com.viettel.vds.wallet3.cms.entity.RegistrationInformation;

@UiController("RegistrationInformation.edit")
@UiDescriptor("registration-information-edit.xml")
@EditedEntityContainer("registrationInformationDc")
public class RegistrationInformationEdit extends StandardEditor<RegistrationInformation> {
}