package nyc.c4q.tarynking.googlenowmnt;

import nyc.c4q.tarynking.googlenowmnt.weatherCard.Weather;

/**
 * Created by meltemyildirim on 11/2/16.
 */

public class CardsItem {
    private Weather weatherCard;

    public Weather getWeatherCard() {
        return weatherCard;
    }

    public CardsItem(Weather weatherCard) {
        this.weatherCard = weatherCard;
    }
}
