package stock.control.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProhibitedResponse {

    private UUID id;

    private LocalDate requestDate;

    private LocalDate entryDate;

    private Double total;

    private Double shipping;

    private Integer invoiceNumber;

    private Double tax;

}
