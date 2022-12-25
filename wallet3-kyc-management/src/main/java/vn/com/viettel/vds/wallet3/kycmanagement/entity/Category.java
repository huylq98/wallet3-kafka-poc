package vn.com.viettel.vds.wallet3.kycmanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "category")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
}
