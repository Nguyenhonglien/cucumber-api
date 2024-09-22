package objects.response.productBrand;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBrandListResponse {
    public ProductBrandListResponse() {

    }

    @JsonProperty("data")
    private List<ProductBrandResponse> data;

    @JsonProperty("status")
    private String status;

    public List<ProductBrandResponse> getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
