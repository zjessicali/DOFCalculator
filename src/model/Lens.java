package model;

public class Lens {
    private String make;
    private double maxAperture;
    private int focalLen;

    public Lens(String make, int focalLen, double maxAperture) {
        this.make = make;
        this.maxAperture = maxAperture;
        this.focalLen = focalLen;
    }

    public String getMake() {
        return make;
    }

    public double getMaxAperture() {
        return maxAperture;
    }

    public int getFocalLen() {
        return focalLen;
    }

    @Override
    public String toString() {
        return "Lens{" +
                "make='" + make + '\'' +
                ", maxAperture=" + maxAperture +
                ", focalLen=" + focalLen +
                '}';
    }
}
