package stock.control.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class ApiError {

    private OffsetDateTime dateTime;
    private Integer status;
    private String type;
    private String title;
    private String detail;
    private List<Field> fields;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Field {
        private String name;
        private String message;
    }

}
