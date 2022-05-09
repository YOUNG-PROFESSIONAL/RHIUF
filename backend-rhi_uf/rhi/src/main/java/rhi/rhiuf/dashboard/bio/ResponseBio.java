package rhi.rhiuf.dashboard.bio;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude
public class ResponseBio {
    protected LocalDateTime bioTimeStamp;
    protected HttpStatus bioStatus;
    protected  String bioMessage;
    protected Map<?,?> bioData;
}
