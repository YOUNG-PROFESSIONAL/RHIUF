package rhi.rhiuf;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude
public class ApiResponse {
    protected LocalDateTime apiTimestamp;
    protected HttpStatus apiStatus;
    protected  String apiMessage;
    protected Map<?,?> apiData;
}
