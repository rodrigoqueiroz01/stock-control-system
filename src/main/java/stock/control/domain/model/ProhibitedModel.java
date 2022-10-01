package stock.control.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prohibited")
public class ProhibitedModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "total")
    private Double total;

    @Column(name = "shipping")
    private Double shipping;

    @Column(name = "invoice_number")
    private Integer invoiceNumber;

    @Column(name = "tax")
    private Double tax;

}
