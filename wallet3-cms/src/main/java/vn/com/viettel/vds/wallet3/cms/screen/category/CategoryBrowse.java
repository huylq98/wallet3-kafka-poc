package vn.com.viettel.vds.wallet3.cms.screen.category;

import io.jmix.core.LoadContext;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.DataGrid;
import io.jmix.ui.component.Pagination;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import vn.com.viettel.vds.wallet3.cms.entity.Category;
import vn.com.viettel.vds.wallet3.cms.feign.AccountFeignClient;

import java.util.List;

@UiController("Category.browse")
@UiDescriptor("category-browse.xml")
@LookupComponent("categoriesTable")
public class CategoryBrowse extends StandardLookup<Category> {

    @Autowired
    private CollectionLoader<Category> categoriesDl;
    @Autowired
    private DataGrid<Category> categoriesTable;
    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private Pagination pagination;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        categoriesDl.load();
    }

    @Install(to = "categoriesDl", target = Target.DATA_LOADER)
    private List<Category> categoriesDlLoadDelegate(LoadContext<Category> loadContext) {
        int size = pagination.getDataBinder().getMaxResults();
        int page = pagination.getDataBinder().getFirstResult() / size;
        return accountFeignClient.findAllCategories(PageRequest.of(page, size)).getContent();
    }

    @Install(to = "pagination", subject = "totalCountDelegate")
    private Integer paginationTotalCountDelegate() {
        return accountFeignClient.findAllCategories(PageRequest.of(0, Integer.MAX_VALUE)).getTotalElements();
    }

    @Subscribe("categoriesTable.remove")
    public void onCategoriesTableRemove(Action.ActionPerformedEvent event) {
        accountFeignClient.delete(categoriesTable.getSingleSelected().getId());
    }
}