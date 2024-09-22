package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.response.productBrand.ProductBrandListResponse;
import org.testng.Assert;
import services.ProductBrandService;

public class ProductBrandSteps extends BaseSteps {
    ProductBrandService productBrandService = new ProductBrandService();

    @When("I access to Product Brands")
    public void accessToProductBrands() {
        ProductBrandListResponse lsProductBrandResponse = productBrandService.getListOfProductBrand();
        scenarioContext.setContext("ProductBrandListResponse", lsProductBrandResponse);
    }

    @Then("The Product Brands has a return {int} brands")
    public void verifyNumberOfProductBrand(int numberOfBrand) {
        Assert.assertEquals(productBrandService.getNumberOfProductBrand(), numberOfBrand);
    }
}
