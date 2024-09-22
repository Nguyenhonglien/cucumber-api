Feature: Product Brands
  @ProductBrand
  Scenario: Verify Product Brands
    Given   I login to Rawal by using email: "owner@email.com" and password: "123"
    When    I access to Product Brands
    Then    The Product Brands has a return 100 brands