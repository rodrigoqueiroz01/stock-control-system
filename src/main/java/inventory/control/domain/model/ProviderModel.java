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
@Table(name = "provider")
public class ProviderModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String provider;

    private String address;

    private Integer number;

    private String district;

    private String cep;

    private String contact;

    private String cnpj;

    private String subscription;

    private String telephone;

//    @ManyToMany
//    @JoinTable(
//            name = "provider_city", schema = "inventory",
//            joinColumns = @JoinColumn(name = "id_provider_fk"),
//            inverseJoinColumns = @JoinColumn(name = "id_city_fk"))
//    private List<CityModel> cityModels;

}
