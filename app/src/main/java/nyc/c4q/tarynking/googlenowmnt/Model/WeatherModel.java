package nyc.c4q.tarynking.googlenowmnt.Model;

import java.util.List;

/**
 * Created by meltemyildirim on 11/1/16.
 */

public class WeatherModel {

    public Coord coord;
    public List<Weather> weather;
    public Main main;
    public Clouds clouds;
    public Sys sys;
    public String base;
    public String name;
    public int visibility;
    public int dt;
    public int cod;

    public String getBase() {
        return base;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public int getCod() {
        return cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public int getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public String getName() {
        return name;
    }

    public Sys getSys() {
        return sys;
    }

    public int getVisibility() {
        return visibility;
    }

    public List<Weather> getWeather() {
        return weather;
    }


}
