package objects.response.productBrand;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBrandResponse {
    @JsonProperty("brand_id")
    private String brandId;

    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("brand_slug")
    private String brandSlug;

    @JsonProperty("brand_status")
    private String brandStatus;

    public String getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getBrandSlug() {
        return brandSlug;
    }

    public String getBrandStatus() {
        return brandStatus;
    }
}
