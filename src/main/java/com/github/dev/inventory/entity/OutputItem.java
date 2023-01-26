package com.github.dev.inventory.entity;

import com.github.dev.inventory.model.Price;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "public")
public class OutputItem implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Output output;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> products;

    private String batch;

    private Integer quantity;

    private Price value;

}
