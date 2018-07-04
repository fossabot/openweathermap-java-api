/*
 * Copyright (c) 2018 Alexey Zinchenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package by.prominence.openweather.api.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.time.LocalTime;
import java.util.List;

public class WeatherResponse {

    @JSONField(name = "id")
    private long cityId;

    @JSONField(name = "name")
    private String cityName;

    @JSONField(name = "coord")
    private Coordinates coordinates;

    @JSONField(name = "weather")
    private List<Weather> weather;

    @JSONField(name = "base")
    private String base;

    @JSONField(name = "main")
    private WeatherInfo weatherInfo;

    @JSONField(name = "wind")
    private Wind wind;

    @JSONField(name = "clouds")
    private Clouds clouds;

    @JSONField(name = "rain")
    private Rain rain;

    @JSONField(name = "snow")
    private Snow snow;

    @JSONField(name = "dt")
    private LocalTime dataCalculationTime;

    @JSONField(name = "sys")
    private WeatherSystemInfo weatherSystemInfo;

    @JSONField(name = "cod")
    private short responseCode;

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public LocalTime getDataCalculationTime() {
        return dataCalculationTime;
    }

    public void setDataCalculationTime(LocalTime dataCalculationTime) {
        this.dataCalculationTime = dataCalculationTime;
    }

    public WeatherSystemInfo getWeatherSystemInfo() {
        return weatherSystemInfo;
    }

    public void setWeatherSystemInfo(WeatherSystemInfo weatherSystemInfo) {
        this.weatherSystemInfo = weatherSystemInfo;
    }

    public short getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(short responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "cityId=" + cityId +
                ",\n cityName='" + cityName + '\'' +
                ",\n coordinates=" + coordinates +
                ",\n weather=" + weather +
                ",\n base='" + base + '\'' +
                ",\n weatherInfo=" + weatherInfo +
                ",\n wind=" + wind +
                ",\n clouds=" + clouds +
                ",\n rain=" + rain +
                ",\n snow=" + snow +
                ",\n dataCalculationTime=" + dataCalculationTime +
                ",\n weatherSystemInfo=" + weatherSystemInfo +
                ",\n responseCode=" + responseCode +
                '}';
    }
}
