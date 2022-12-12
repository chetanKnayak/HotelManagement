package com.example.HotelManagement.entites;

public class HotelManagement {


    private String hotelName;
    private int customerId;

    private String customerName;
    private Long customerNumber;
    private String paymentMethod;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "HotelManagement{" +
                "hotelName='" + hotelName + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerNumber=" + customerNumber +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public HotelManagement(String hotelName, int customerId, String customerName, Long customerNumber, String paymentMethod) {
        this.hotelName = hotelName;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.paymentMethod = paymentMethod;
    }

    public HotelManagement() {
    }
}
