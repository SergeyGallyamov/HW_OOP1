package ru.gb.oseminar.lesson1;

public class HotDrinks extends Product {
    private int temp;
    private int volume;

    public HotDrinks(String name, double cost, int temp, int volume) {
        super(name, cost);
        this.temp = temp;
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "HotDrinks{" +
                "name='" + super.getName() + '\'' +
                "volume='" + this.volume + '\'' +
                ", cost=" + super.getCost() +
                ", temp=" + this.getTemp() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HotDrinks)) {
            return false;
        }

        HotDrinks that = (HotDrinks) o;

        return super.getName().equalsIgnoreCase(that.getName())
                && super.getCost() == that.getCost()
                && getVolume() == that.getVolume()
                && getTemp() == that.getTemp();
    }
}
