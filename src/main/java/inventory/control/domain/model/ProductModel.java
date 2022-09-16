package inventory.control.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String description;

    private Double weight;

    private Boolean controlled;

    private Integer minimumAmount;

//    @ManyToMany
//    @JoinTable(
//            name = "product_provider", schema = "inventory",
//            joinColumns = @JoinColumn(name = "id_product_fk"),
//            inverseJoinColumns = @JoinColumn(name = "id_provider_fk"))
//    private List<ProviderModel> providerModels;
//
//    @ManyToOne
//    @JoinColumn(name = "id_category_fk")
//    private CategoryModel categoryModel;

}
