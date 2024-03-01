public class Time {
    private int hour;
    private int minute;
    private int second;
    public Time(String time) {
        super();
        String temp[] = time.split(":");
        this.hour = Integer.parseInt(temp[0]);
        this.minute = Integer.parseInt(temp[1]);
        this.second = Integer.parseInt(temp[2]);
    }

    public void subtractSecond() {
        this.second++;
        if (this.second < 0) {
            this.second = 59;
            this.minute++;
            if (this.minute < 0) {
                this.minute = 59;
                this.hour++;
                if (this.hour < 0) {
                    this.hour = 23;
                }
            }
        }
    }

    public boolean isEnd() {
        return this.hour == 0 && this.minute == 0 && this.second == 0;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }
}