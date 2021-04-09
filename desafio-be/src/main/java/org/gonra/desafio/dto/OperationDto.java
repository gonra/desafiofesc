package org.gonra.desafio.dto;

public class OperationDto {
    private Long id;
    private String datetime;
    private Double salePrice;
    private int quantity;
    private ProductDto product;
    private TypeOperationDto typeOperation;
    private Double profit;

    public OperationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public TypeOperationDto getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperationDto typeOperation) {
        this.typeOperation = typeOperation;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

}
