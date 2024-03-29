package benjamin.gu.umbrella.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainPojo {
    @SerializedName("temp")
    @Expose
    public double temp;
    @SerializedName("temp_min")
    @Expose
    public double tempMin;
    @SerializedName("temp_max")
    @Expose
    public double tempMax;
    @SerializedName("pressure")
    @Expose
    public double pressure;
    @SerializedName("sea_level")
    @Expose
    public double seaLevel;
    @SerializedName("grnd_level")
    @Expose
    public double grndLevel;
    @SerializedName("humidity")
    @Expose
    public int humidity;
    @SerializedName("temp_kf")
    @Expose
    public int tempKf;
}
