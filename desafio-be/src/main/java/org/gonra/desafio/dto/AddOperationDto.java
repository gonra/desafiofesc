package org.gonra.desafio.dto;

public class AddOperationDto {

    private Double salePrice;
    private int quantity;
    private Long productId;
    private Long typeOperationId;

    public AddOperationDto() {
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

    public Long getProductId() {
        return productId;
    }

    public void setProduct(Long productId) {
        this.productId = productId;
    }

    public Long getTypeOperationId() {
        return typeOperationId;
    }

    public void setTypeOperationId(Long typeOperationId) {
        this.typeOperationId = typeOperationId;
    }

}
