package vn.com.viettel.vds.wallet3.cms.screen.category;

import io.jmix.core.EntityStates;
import io.jmix.ui.component.Button;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import vn.com.viettel.vds.wallet3.cms.entity.Category;
import vn.com.viettel.vds.wallet3.cms.feign.AccountFeignClient;

@UiController("Category.edit")
@UiDescriptor("category-edit.xml")
@EditedEntityContainer("categoryDc")
public class CategoryEdit extends StandardEditor<Category> {

    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private InstanceContainer<Category> categoryDc;
    @Autowired
    private EntityStates entityStates;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        if (entityStates.isNew(getEditedEntity())) {
            categoryDc.setItem(accountFeignClient.save(getEditedEntity()));
        } else {
            categoryDc.setItem(accountFeignClient.save(getEditedEntity().getId(), getEditedEntity()));
        }
    }
}