package nyc.c4q.tarynking.googlenowmnt.Model;

/**
 * Created by meltemyildirim on 11/10/16.
 */

public class Main {
    public double temp;
    public int pressure;
    public int humidity;
    public double tempMin;
    public double tempMax;

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public double getTemp() {
        return (int) (1.8 * (temp -273.0) +32.0);
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }
}

