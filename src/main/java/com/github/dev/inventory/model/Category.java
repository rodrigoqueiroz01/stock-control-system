package com.github.dev.inventory.model;

import com.github.dev.inventory.model.enums.CategoryType;
import jakarta.persistence.*;
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
public class Category implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_type", nullable = false, length = 100)
    private CategoryType type;

}
