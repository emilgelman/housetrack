package com.emilgelman.housetrack.housetrack.domain;

public enum SellerType {
    PRIVATE,MERCHANT;

    public static SellerType from(boolean isMerchant) {
        return isMerchant ? MERCHANT : PRIVATE;
    }
}
