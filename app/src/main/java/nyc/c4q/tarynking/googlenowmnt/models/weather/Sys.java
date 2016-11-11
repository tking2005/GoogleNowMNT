package nyc.c4q.tarynking.googlenowmnt.models.weather;

/**
 * Created by meltemyildirim on 11/10/16.
 */

public class Sys {
    public int type;
    public int id;
    public double message;
    public String country;
    public int sunrise;
    public int sunset;

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public double getMessage() {
        return message;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public int getType() {
        return type;
    }
}