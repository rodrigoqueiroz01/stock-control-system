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
@Table(name = "store")
public class StoreModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String zipCode;
    private String address;
    private Integer number;
    private String district;
    private String telephone;
    private String subscription;
    private String cnpj;

//    @OneToMany(mappedBy = "storeModel")
//    private List<ExitModel> exitModels;
//
//    @ManyToMany
//    @JoinTable(
//            name = "store_city", schema = "inventory",
//            joinColumns = @JoinColumn(name = "id_store_fk"),
//            inverseJoinColumns = @JoinColumn(name = "id_city_fk"))
//    private List<CityModel> cityModels;

}
