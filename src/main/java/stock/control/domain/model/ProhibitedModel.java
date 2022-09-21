package stock.control.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prohibited", schema = "public")
public class ProhibitedModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDateTime requestDate;

    private LocalDateTime entryDate;

    private Double total;

    private Double shipping;

    @Column(name = "invoice_number")
    private Integer invoiceNumber;

    private Double tax;

//    @ManyToMany
//    @JoinTable(
//            name = "prohibited_conveyor", schema = "inventory",
//            joinColumns = @JoinColumn(name = "id_prohibited_fk"),
//            inverseJoinColumns = @JoinColumn(name = "id_conveyor_fk"))
//    private List<ConveyorModel> conveyorModels;

}
