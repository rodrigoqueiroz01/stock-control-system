package com.github.dev.inventory.entity.model;

import jakarta.persistence.Column;
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
public class Price implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    private Double value;

    @Column(length = 3)
    private String currency;

}
