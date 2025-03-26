package com.example.sit703_task21p_unitconverter;


import java.util.HashMap;
import java.util.Map;

public class ConversionUtils {
    private static final Map<String, Double> lengthUnits = new HashMap<>();
    private static final Map<String, Double> weightUnits = new HashMap<>();

    static {
        // Length conversion factors (relative to cm)
        lengthUnits.put("Inches", 2.54);
        lengthUnits.put("Feet", 30.48);
        lengthUnits.put("Yards", 91.44);
        lengthUnits.put("Miles", 160934.4);
        lengthUnits.put("Centimeters", 1.0);

        // Weight conversion factors (relative to kg)
        weightUnits.put("Pounds", 0.453592);
        weightUnits.put("Ounces", 0.0283495);
        weightUnits.put("Tons", 907.185);
        weightUnits.put("Kilograms", 1.0);
    }

    public static double convert(String from, String to, double value) {
        if (from.equals(to)) {
            throw new IllegalArgumentException("Same unit, no conversion needed.");
        }

        // Length conversion
        if (lengthUnits.containsKey(from) && lengthUnits.containsKey(to)) {
            return value * (lengthUnits.get(to) / lengthUnits.get(from));
        }

        // Weight conversion
        if (weightUnits.containsKey(from) && weightUnits.containsKey(to)) {
            return value * (weightUnits.get(to) / weightUnits.get(from));
        }

        // Temperature conversion
        switch (from + " to " + to) {
            case "Celsius to Fahrenheit":
                return (value * 1.8) + 32;
            case "Fahrenheit to Celsius":
                return (value - 32) / 1.8;
            case "Celsius to Kelvin":
                return value + 273.15;
            case "Kelvin to Celsius":
                return value - 273.15;
            default:
                throw new IllegalArgumentException("Invalid conversion.");
        }
    }
}

