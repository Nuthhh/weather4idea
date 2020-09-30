package com.ohow.weather.data;


public class WeatherInfo {

    /**
     * 城市id
     */
    private String cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 天气更新时间
     */
    private String updateTime;
    /**
     * 天气信息
     */
    private String weather;
    /**
     * 天气信息图片
     */
    private String weatherImage;
    /**
     * 实时温度
     */
    private String temperature;
    /**
     * 最高温度
     */
    private String maxTemperature;
    /**
     * 最低温度
     */
    private String minTemperature;
    /**
     * 风向
     */
    private String wind;
    /**
     * 风力等级
     */
    private String windLevel;
    /**
     * 风速
     */
    private String windSpeed;
    /**
     * 湿度
     */
    private String humidity;
    /**
     * 能见度
     */
    private String visibility;
    /**
     * 气压
     */
    private String pressure;
    /**
     * 空气质量
     */
    private String air;
    /**
     * 空气质量等级
     */
    private String airLevel;
    /**
     * 空气质量描述
     */
    private String airTips;

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", weather='" + weather + '\'' +
                ", weatherImage='" + weatherImage + '\'' +
                ", temperature='" + temperature + '\'' +
                ", maxTemperature='" + maxTemperature + '\'' +
                ", minTemperature='" + minTemperature + '\'' +
                ", wind='" + wind + '\'' +
                ", windLevel='" + windLevel + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", humidity='" + humidity + '\'' +
                ", visibility='" + visibility + '\'' +
                ", pressure='" + pressure + '\'' +
                ", air='" + air + '\'' +
                ", airLevel='" + airLevel + '\'' +
                ", airTips='" + airTips + '\'' +
                '}';
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherImage() {
        return weatherImage;
    }

    public void setWeatherImage(String weatherImage) {
        this.weatherImage = weatherImage;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWindLevel() {
        return windLevel;
    }

    public void setWindLevel(String windLevel) {
        this.windLevel = windLevel;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getAirLevel() {
        return airLevel;
    }

    public void setAirLevel(String airLevel) {
        this.airLevel = airLevel;
    }

    public String getAirTips() {
        return airTips;
    }

    public void setAirTips(String airTips) {
        this.airTips = airTips;
    }
}
