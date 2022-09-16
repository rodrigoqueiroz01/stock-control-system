package inventory.control.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "output_item")
public class OutputItemModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String batch;

    private Integer amount;

    private Double value;

//    @ManyToOne
//    @JoinColumn(name = "id_product_fk")
//    private ProductModel productModel;
//
//    @ManyToOne
//    @JoinColumn(name = "id_exit_fk")
//    private ExitModel exitModel;

}
