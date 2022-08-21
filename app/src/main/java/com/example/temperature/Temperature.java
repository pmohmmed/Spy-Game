package com.example.temperature;

public class Temperature {

    private float temperature;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temper) {
        this.temperature = temper;
    }
    public float convertFahrenheitToCelsius(){
        return( ((temperature -32) * 5) /9);
    }

    public float convertCelsiusToFahrenheit(){
        return( ((temperature * 9) / 5) +32);
    }

}
