package org.gonra.desafio.dto;

public class ProductDto {
    private Long id;
    private String code;
    private String description;
    private Double providerPrice;
    private int stock;
    private TypeProductDto typeProduct;
    private String lastUpdate;

    public ProductDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getProviderPrice() {
        return providerPrice;
    }

    public void setProviderPrice(Double providerPrice) {
        this.providerPrice = providerPrice;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public TypeProductDto getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProductDto typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
