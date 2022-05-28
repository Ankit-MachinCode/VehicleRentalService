package org.vehiclerental.dao;

import java.util.Objects;

public class Price {

    VehicleType vehicleType;
    int pricePerHour;

    public Price(VehicleType vehicleType, int pricePerHour) {
        this.vehicleType = vehicleType;
        this.pricePerHour = pricePerHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price = (Price) o;
        return getVehicleType() == price.getVehicleType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicleType());
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
