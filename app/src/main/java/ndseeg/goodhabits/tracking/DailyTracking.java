package ndseeg.goodhabits.tracking;

import java.util.Date;


public class DailyTracking {
    public DailyTracking(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

}
