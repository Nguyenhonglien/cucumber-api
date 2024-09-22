package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.response.productBrand.ProductBrandListResponse;

public class ProductBrandService extends BaseRestService{
    public ProductBrandService() {
        this.setProtocol("https");
        this.setHost("rawal-admin.themes-coder.net");
    }

    public ProductBrandListResponse getListOfProductBrand() {
        ProductBrandListResponse productBrandListResponse;
        getHeaders().put("Authorization", "Bearer " + scenarioContext.getContext("TOKEN"));

        RequestSpecification spec = this.getDefaultRequestBuilder("/api/admin/brand?limit=10&searchParameter=&sortBy=id&sortType=ASC&getDetail=1");
        Response response = this.dispatchServiceRequest(spec, Method.GET);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            productBrandListResponse = objectMapper.readValue(response.body().asString(), ProductBrandListResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return productBrandListResponse;
    }

    public int getNumberOfProductBrand() {
        ProductBrandListResponse productBrandResponse = scenarioContext.getContext("ProductBrandListResponse");
        return productBrandResponse.getData().size();
    }
}
