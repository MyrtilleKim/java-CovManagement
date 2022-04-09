package com.kina.model;

public class PackDetail {
    private int packId;
    private Product product;
    private int quantity;


    public PackDetail() {
    }

    public PackDetail(int packId, Product product, int quantity) {
        this.packId = packId;
        this.product = product;
        this.quantity = quantity;
    }


    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
            " product='" + getProduct() + "'" +
            ", quantity='" + getQuantity() + "'" +
            "}";
    }
    
}
