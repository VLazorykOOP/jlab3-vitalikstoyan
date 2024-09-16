import java.util.ArrayList;
import java.util.List;

// Базовий клас TransportVehicle (Транспортний засіб)
class TransportVehicle {
    protected String manufacturer;
    protected String model;
    protected int maxSpeed;
    protected int capacity;

    // Конструктор
    public TransportVehicle(String manufacturer, String model, int maxSpeed, int capacity) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.capacity = capacity;
    }

    // Метод для виводу інформації про транспортний засіб
    public void show() {
        System.out.println("TransportVehicle: " + manufacturer + " " + model + ", Max Speed: " + maxSpeed 
                            + " km/h, Capacity: " + capacity + " persons");
    }
}

// Похідний клас Car (Автомобіль)
class Car extends TransportVehicle {
    private String engineType;
    private float fuelConsumption;
    private int trunkVolume;

    // Конструктор
    public Car(String manufacturer, String model, int maxSpeed, int capacity, String engineType, float fuelConsumption, int trunkVolume) {
        super(manufacturer, model, maxSpeed, capacity);
        this.engineType = engineType;
        this.fuelConsumption = fuelConsumption;
        this.trunkVolume = trunkVolume;
    }

    // Перевизначений метод show
    @Override
    public void show() {
        System.out.println("Car: " + manufacturer + " " + model + ", Engine: " + engineType 
                            + ", Fuel consumption: " + fuelConsumption + " L/100km, Trunk volume: " 
                            + trunkVolume + " L, Max Speed: " + maxSpeed + " km/h, Capacity: " 
                            + capacity + " persons");
    }
}

// Похідний клас Train (Поїзд)
class Train extends TransportVehicle {
    protected int numWagons;
    protected String trainType;
    protected float length;

    // Конструктор
    public Train(String manufacturer, String model, int maxSpeed, int capacity, int numWagons, String trainType, float length) {
        super(manufacturer, model, maxSpeed, capacity);
        this.numWagons = numWagons;
        this.trainType = trainType;
        this.length = length;
    }

    // Перевизначений метод show
    @Override
    public void show() {
        System.out.println("Train: " + manufacturer + " " + model + ", Train type: " + trainType 
                            + ", Wagons: " + numWagons + ", Length: " + length + " meters, Max Speed: " 
                            + maxSpeed + " km/h, Capacity: " + capacity + " persons");
    }
}

// Похідний клас Express (Експрес), що успадковується від Train
class Express extends Train {
    private int numStops;

    // Конструктор
    public Express(String manufacturer, String model, int maxSpeed, int capacity, int numWagons, String trainType, float length, int numStops) {
        super(manufacturer, model, maxSpeed, capacity, numWagons, trainType, length);
        this.numStops = numStops;
    }

    // Перевизначений метод show
    @Override
    public void show() {
        System.out.println("Express: " + manufacturer + " " + model + ", Stops: " + numStops 
                            + ", Wagons: " + numWagons + ", Length: " + length + " meters, Max Speed: " 
                            + maxSpeed + " km/h, Capacity: " + capacity + " persons");
    }
}

// Основна програма
public class Main {
    public static void main(String[] args) {
        // Масив (список) об'єктів типу TransportVehicle
        List<TransportVehicle> vehicles = new ArrayList<>();

        // Додаємо об'єкти до списку
        vehicles.add(new Car("Toyota", "Corolla", 180, 5, "Gasoline", 6.5f, 470));
        vehicles.add(new Train("Siemens", "Velaro", 320, 800, 10, "Passenger", 200.0f));
        vehicles.add(new Express("Bombardier", "Acela Express", 300, 450, 8, "Passenger", 150.0f, 5));

        // Виводимо інформацію про всі об'єкти
        for (TransportVehicle vehicle : vehicles) {
            vehicle.show();
        }
    }
}
