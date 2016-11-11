package nyc.c4q.tarynking.googlenowmnt.Model;

/**
 * Created by meltemyildirim on 11/10/16.
 */

public class Weather {
    int id;
    String main;
    String description;
    String icon;

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
}
