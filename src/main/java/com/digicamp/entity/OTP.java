package com.digicamp.entity;

public class OTP {

    private Integer otp;
    private Double id;

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public OTP(Integer otp, Double id) {
        this.otp = otp;
        this.id = id;
    }

    public OTP(){}
}
