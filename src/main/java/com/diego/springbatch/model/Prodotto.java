package com.diego.springbatch.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Prodotto")
public class Prodotto {

    private String productName;

    private double price;

    private boolean state;

    private String description;

    private int quantity;

    @XmlElement(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @XmlElement(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement(name = "state")
    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", state=" + state +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
