package stock.control.domain.model;

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
@Table(name = "conveyor")
public class ConveyorModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private Integer number;

    @Column(name = "district")
    private String district;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "subscription")
    private String subscription;

    @Column(name = "contact")
    private String contact;

    @Column(name = "telephone")
    private String telephone;

}
