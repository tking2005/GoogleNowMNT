package nyc.c4q.tarynking.googlenowmnt.models.weather;

/**
 * Created by meltemyildirim on 11/10/16.
 */

public class Weather {
    int id;
    String main;
    String description;
    String icon;
    int hummidty;
    int pressure;

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public int getHummidty() {
        return hummidty;
    }

    public int getPressure() {
        return pressure;
    }
}