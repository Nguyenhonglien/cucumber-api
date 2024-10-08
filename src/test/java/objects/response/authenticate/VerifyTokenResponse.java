package objects.response.authenticate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VerifyTokenResponse {
    public VerifyTokenResponse() {

    }

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
