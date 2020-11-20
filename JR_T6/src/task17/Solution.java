package task17;

import task12.Plane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String title = reader.readLine();
            if(title.equals(Planet.EARTH)){
                thePlanet = Earth.getInstance();
            } else if(title.equals(Planet.MOON)){
                thePlanet = Moon.getInstance();
            } else if(title.equals(Planet.SUN)){
                thePlanet = Sun.getInstance();
            } else{
                thePlanet = null;
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

