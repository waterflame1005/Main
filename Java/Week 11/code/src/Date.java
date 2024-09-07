public class Date {
    private int day;
    private int month;
    private int year;

    // parameterized construct
    Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    // default values
    Date() {
        this.day = this.month = this.year = 0;
    }

    // get date
    public String getDate() {
        return month + "/" + day + "/" + year;
    }

    // set date
    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // get day
    public int getDay() {
        return day;
    }
}
