package com.niantic.models;

public class Product
{
    private int productId;
    private int categoryId;
    private String productName;
    private String quantityPerUnit;
    private Double unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;

    public Product()
    {
    }

    public Product(int productId, int categoryId, String productName, String quantityPerUnit, Double unitPrice, Integer unitsInStock, Integer unitsOnOrder, Integer reorderLevel)
    {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getQuantityPerUnit()
    {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit)
    {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Double getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitsInStock()
    {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock)
    {
        this.unitsInStock = unitsInStock;
    }

    public Integer getUnitsOnOrder()
    {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Integer unitsOnOrder)
    {
        this.unitsOnOrder = unitsOnOrder;
    }

    public Integer getReorderLevel()
    {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel)
    {
        this.reorderLevel = reorderLevel;
    }
}
