package vn.com.viettel.vds.wallet3.kycmanagement.entity;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "registration_information")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Where(clause = "is_deleted=false")
public class RegistrationInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @Builder.Default
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = Boolean.FALSE;
}
