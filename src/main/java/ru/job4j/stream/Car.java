package ru.job4j.stream;

public class Car {
    private String name;
    private String manufacturer;
    private String country;
    private BodyType bodyType;
    private short releaseDate;
    private short maxSpeed;
    private float engineVolume;

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", manufacturer='" + manufacturer + '\''
                + ", country='" + country + '\''
                + ", bodyType=" + bodyType
                + ", releaseDate=" + releaseDate
                + ", engineVolume=" + engineVolume
                + ", maxSpeed=" + maxSpeed
                + '}';
    }

    enum BodyType {
        Sedan,
        Hatchback
    }

    static class Builder {
        private String name;
        private String manufacturer;
        private String country;
        private BodyType bodyType;
        private short releaseDate;
        private short maxSpeed;
        private float engineVolume;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        Builder buildCountry(String country) {
            this.country = country;
            return this;
        }

        Builder buildBodyType(BodyType bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        Builder buildReleaseDate(short releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        Builder buildMaxSpeed(short maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildEngineVolume(float engineVolume) {
            this.engineVolume = engineVolume;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.name = name;
            car.manufacturer = manufacturer;
            car.country = country;
            car.bodyType = bodyType;
            car.releaseDate = releaseDate;
            car.maxSpeed = maxSpeed;
            car.engineVolume = engineVolume;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder().buildName("3")
                .buildManufacturer("Mazda")
                .buildCountry("Japan")
                .buildBodyType(BodyType.Sedan)
                .buildReleaseDate((short) 2006)
                .buildMaxSpeed((short) 209)
                .buildEngineVolume(2.0f)
                .build();
        System.out.println(car);
    }
}
