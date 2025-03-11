package org.example.LeetCode;

public class BestTimeToSellStocks {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    private static int maxProfit(int[] arr) {

        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;

        for (int currPrice : arr){
            if (currPrice < minPrice)
                minPrice = currPrice;
            else if ((currPrice - minPrice) > maxProfit)
                maxProfit = (currPrice - minPrice);
        }

        return maxProfit;
    }

//    private static int maxProfit(int[] arr) {
//        int maxProfitValue = 0;
//        int minPrice = Integer.MAX_VALUE;
//
//        for (int currDayPrice : arr){
//            if (currDayPrice < minPrice){
//                minPrice = currDayPrice;
//            }
//            if (maxProfitValue < currDayPrice - minPrice){
//                maxProfitValue = currDayPrice - minPrice;
//            }
//        }
//        return maxProfitValue;
//    }
}
