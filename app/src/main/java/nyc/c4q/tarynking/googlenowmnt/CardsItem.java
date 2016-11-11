package nyc.c4q.tarynking.googlenowmnt;

import nyc.c4q.tarynking.googlenowmnt.Model.WeatherModel;

/**
 * Created by meltemyildirim on 11/2/16.
 */

public class CardsItem {
    private WeatherModel weatherCard;

    public WeatherModel getWeatherCard() {
        return weatherCard;
    }

    public CardsItem(WeatherModel weatherCard) {
        this.weatherCard = weatherCard;
    }
}
