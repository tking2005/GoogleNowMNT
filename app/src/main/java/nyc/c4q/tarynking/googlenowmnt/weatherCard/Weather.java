package nyc.c4q.tarynking.googlenowmnt.weatherCard;

/**
 * Created by meltemyildirim on 11/1/16.
 */

public class Weather {

    private int img;
    private String temp, location, description;

    public Weather(String description, int img, String location, String temp) {
        this.description = description;
        this.img = img;
        this.location = location;
        this.temp = temp;
    }

    public String getDescription() {
        return description;
    }

    public int getImg() {
        return img;
    }

    public String getLocation() {
        return location;
    }

    public String getTemp() {
        return temp;
    }
}
