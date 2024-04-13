import java.util.UUID;
import model.*;
public class Main {
    public static void main(String[] args) {
        // instantiate 3 objects of each class

        Car.Engine engine1 = new Car.Engine("Gasoline", 150, 200, 2000, 4, 16, "Gasoline", "Manual", "Front", "FWD", "5.5L/100km", "120g/km");
        Car.Engine engine2 = new Car.Engine("Diesel", 150, 200, 2000, 4, 16, "Diesel", "Manual", "Front", "FWD", "5.5L/100km", "120g/km");
        Car.Engine engine3 = new Car.Engine("Electric", 150, 200, 2000, 4, 16, "Electric", "Automatic", "Front", "FWD", "5.5L/100km", "120g/km");

        Car car1 = new Car(UUID.randomUUID().toString(), "Toyota", "Corolla", "Black", "Gasoline", 20000.0, 4, 5, 2020, engine1);
        Car car2 = new Car(UUID.randomUUID().toString(), "Toyota", "Yaris", "Black", "Diesel", 15000.0, 4, 5, 2020, engine2);
        Car car3 = new Car(UUID.randomUUID().toString(), "Tesla", "Model 3", "Black", "Electric", 40000.0, 4, 5, 2020, engine3);

        Coffee coffee1 = new Coffee(UUID.randomUUID().toString(), "Nespresso", "Inissia", "Black", 100.0, 0.7, true, false);
        Coffee coffee2 = new Coffee(UUID.randomUUID().toString(), "De'Longhi", "EC155", "Black", 100.0, 1.0, true, true);
        Coffee coffee3 = new Coffee(UUID.randomUUID().toString(), "Breville", "BES870XL", "Black", 100.0, 1.0, true, true);

        Tea tea1 = new Tea(UUID.randomUUID().toString(), "Twinings", "English Breakfast", "London", 10.0, 0.5, 0.05, 100);
        Tea tea2 = new Tea(UUID.randomUUID().toString(), "Lipton", "Yellow Label", "London", 5.0, 0.5, 0.05, 100);
        Tea tea3 = new Tea(UUID.randomUUID().toString(), "Tetley", "Original", "London", 5.0, 0.5, 0.05, 100);

        Printer printer1 = new Printer(UUID.randomUUID().toString(), "HP", "LaserJet", "White", 100.0, 10.0, 10.0, true, false);
        Printer printer2 = new Printer(UUID.randomUUID().toString(), "Canon", "Pixma", "Black", 50.0, 10.0, 10.0, false, true);
        Printer printer3 = new Printer(UUID.randomUUID().toString(), "Epson", "EcoTank", "Black", 200.0, 10.0, 10.0, true, true);

        Scaner scaner1 = new Scaner(UUID.randomUUID().toString(), "Epson", "Perfection", "Black", 100.0, 10.0, 20, true, true, 8.5, "AC");
        Scaner scaner2 = new Scaner(UUID.randomUUID().toString(), "Canon", "CanoScan", "Black", 50.0, 10.0, 20, true, true, 8.5, "AC");
        Scaner scaner3 = new Scaner(UUID.randomUUID().toString(), "Brother", "DS", "Black", 150.0, 10.0, 20, true, true, 8.5, "AC");

        Monitor monitor1 = new Monitor(UUID.randomUUID().toString(), "Dell", "P2419H", "Black", 150.0, 24.0, 14.0, 60, 5.0);
        Monitor monitor2 = new Monitor(UUID.randomUUID().toString(), "Asus", "VG248QE", "Black", 250.0, 24.0, 14.0, 144, 1.0);
        Monitor monitor3 = new Monitor(UUID.randomUUID().toString(), "Acer", "KG241Q", "Black", 200.0, 24.0, 14.0, 75, 1.0);

        Desk desk1 = new Desk(UUID.randomUUID().toString(), "IKEA", "MALM", "Black", "Wood", 100.0, 40.0, 30.0, 20.0, 3);
        Desk desk2 = new Desk(UUID.randomUUID().toString(), "IKEA", "LINNMON", "White", "Wood", 50.0, 40.0, 30.0, 20.0, 3);
        Desk desk3 = new Desk(UUID.randomUUID().toString(), "IKEA", "ALEX", "White", "Wood", 150.0, 40.0, 30.0, 20.0, 3);

        Clock clock1 = new Clock(UUID.randomUUID().toString(), "Casio", "G-Shock", "Black", "Plastic", 100.0, "Round", "Quartz");
        Clock clock2 = new Clock(UUID.randomUUID().toString(), "Casio", "F91W", "Black", "Plastic", 20.0, "Square", "Quartz");
        Clock clock3 = new Clock(UUID.randomUUID().toString(), "Casio", "AE1200", "Black", "Plastic", 50.0, "Square", "Quartz");

        Phone phone1 = new Phone(UUID.randomUUID().toString(), "Apple", "iPhone 11", "Black", 1245.0, 128, 8, "ios");
        Phone phone2 = new Phone(UUID.randomUUID().toString(), "Samsung", "Galaxy S20", "Black", 1245.0, 128, 8, "android");
        Phone phone3 = new Phone(UUID.randomUUID().toString(), "OnePlus", "8 Pro", "Black", 1245.0, 128, 8, "android");

        Computer.CPU cpu1 = new Computer.CPU("Intel", "i5", 4, 8, 3.5, 6, "LGA1151", "x86", "14nm", "65W", "Intel UHD Graphics 630");
        Computer.CPU cpu2 = new Computer.CPU("AMD", "Ryzen 5", 6, 12, 3.5, 6, "AM4", "x86", "7nm", "65W", "Radeon RX Vega 11");
        Computer.CPU cpu3 = new Computer.CPU("Intel", "i7", 8, 16, 3.5, 6, "LGA1151", "x86", "14nm", "65W", "Intel UHD Graphics 630");

        Computer computer1 = new Computer(UUID.randomUUID().toString(), "Dell", "Inspiron", "Black", 1000.0, 8, 1000, cpu1);
        Computer computer2 = new Computer(UUID.randomUUID().toString(), "HP", "Pavilion", "Black", 800.0, 8, 1000, cpu2);
        Computer computer3 = new Computer(UUID.randomUUID().toString(), "Apple", "iMac", "Black", 1500.0, 8, 1000, cpu3);

    }

}

