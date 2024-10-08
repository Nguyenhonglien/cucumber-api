package config;


import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RestAssuredRequestFilter implements Filter {
    private static final Log log = LogFactory.getLog(RestAssuredRequestFilter.class);
    private int number;
    private String str;

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        if (response.statusCode() != 200) {
            log.error(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " +
            response.getStatusCode() + " " + response.getStatusLine());
        }
        log.info(requestSpec.getMethod() + " " + requestSpec.getURI() + "\nRequest Body =>" + requestSpec.getBody() + "\nResponse Status => " +
                response.getStatusCode() + " " + response.getStatusLine() + "\nResponse Body => " + response.getBody().prettyPrint());

        Allure.addAttachment( "INFO:", requestSpec.getMethod() + " " + requestSpec.getURI() + "\nRequest Body =>" + requestSpec.getBody() + "\nResponse Status => " +
                response.getStatusCode() + " " + response.getStatusLine() + "\nResponse Body => " + response.getBody().prettyPrint());

        return response;
    }

}
