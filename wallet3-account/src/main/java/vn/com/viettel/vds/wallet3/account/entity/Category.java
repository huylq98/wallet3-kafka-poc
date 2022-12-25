package vn.com.viettel.vds.wallet3.account.entity;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "category")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Where(clause = "is_deleted=false")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", nullable = false, unique = true)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Builder.Default
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = Boolean.FALSE;
}
