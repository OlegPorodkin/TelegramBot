package weather;

public class Model {
    private String nameSity;
    private double temp;
    private int pressure;
    private double humidity;


    public String getNameSity() {
        return nameSity;
    }

    public void setNameSity(String nameSity) {
        this.nameSity = nameSity;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
