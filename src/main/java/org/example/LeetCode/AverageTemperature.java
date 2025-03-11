package org.example.LeetCode;

import java.util.Scanner;

public class AverageTemperature {

    public static void main(String[] args) {
        intiateAvgTemp();
    }

    private static void intiateAvgTemp() {
        Scanner console = new Scanner(System.in);

        System.out.print("How many days of temperature :");
        int totalDays = console.nextInt();
        int sum = 0;
        int daysAboveAvgTemperature=0;
        int[] temperatureArray = new int[totalDays];
        for (int i=1; i<=totalDays;i++){
            System.out.print("Temp of day " + i + " is :");
            int dayTemp = console.nextInt();
            temperatureArray[i-1] = dayTemp;
            sum += dayTemp;
        }
        int avgTemp = sum/totalDays;
        for (int temp : temperatureArray){
            if (temp > avgTemp)
                daysAboveAvgTemperature++;
        }

        System.out.println("total number of days above avg temperature is : " + daysAboveAvgTemperature);
    }

}
