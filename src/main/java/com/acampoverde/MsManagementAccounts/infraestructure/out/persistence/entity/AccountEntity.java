package com.acampoverde.MsManagementAccounts.infraestructure.out.persistence.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tbl_adm_account")
@Getter
@Setter
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;
    @Column(length = 15, nullable = false)
    private String accountNumber;
    @Column(length = 20, nullable = false)
    private String accountType;
    private Double initialBalance;
    private Boolean status;

//     @NotNull
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<MovementEntity> movements;

    public AccountEntity(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

}
