package 面试;

import java.lang.ref.WeakReference;

/**
 * Created by liyanzhen on 17/4/24.
 */
class Car {
    private int price;
    private int color;

    public Car(int price, int color) {
        this.price = price;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

public class WeakReferenceDemo {
    public static void main(String[] args) {
        Car car = new Car(111, 123);
        WeakReference<Car> weakCar = new WeakReference<>(car);

        int i = 0;
        while (true) {
            System.out.println(car);
            if (weakCar.get() != null) {
                i++;
                System.out.println("is alive" + i + "loops" + weakCar);
            } else {
                System.out.println("null");
                break;
            }
        }
    }
}
