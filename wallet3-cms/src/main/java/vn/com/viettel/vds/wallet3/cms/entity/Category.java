package vn.com.viettel.vds.wallet3.cms.entity;

import io.jmix.core.metamodel.annotation.DependsOnProperties;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JmixEntity
public class Category implements Serializable {
    private Long id;
    private String code;
    private String name;
    @InstanceName
    @DependsOnProperties({"code", "name"})
    public String instanceName() {
        return String.join("-", code, name);
    }
}
