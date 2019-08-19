package benjamin.gu.umbrella.model;

public class ListPojo {
    public WeatherPojo weather;
    public MainPojo main;
    public DatePojo date;

    public String getDate(){
        return  date.dtTxt;
    }


}
