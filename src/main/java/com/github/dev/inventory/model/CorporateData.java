package com.github.dev.inventory.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CorporateData implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Column(name = "data_cnpj", nullable = false, length = 18)
    private String CNPJ;

    @Column(name = "data_subscription", nullable = false, length = 100)
    private String subscription;

    @Column(name = "data_contact", nullable = false, length = 100)
    private String contact;

    @Column(name = "data_telephone", nullable = false, length = 15)
    private String telephone;

}
