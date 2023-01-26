package com.github.dev.inventory.entity;

import com.github.dev.inventory.model.Address;
import com.github.dev.inventory.model.CorporateData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "public")
public class Provider implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name_provider", nullable = false)
    private String nameProvider;

    @Embedded
    private Address address;

    @Embedded
    private CorporateData corporateData;

}
