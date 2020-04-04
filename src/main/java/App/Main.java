package App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        String dataSet = "function=TIME_SERIES_DAILY";       //type of info about the symbol that is selected
        String apikey = "&apikey=D44LPNJ4W7DXPN2Y";         //alpha vantage apikey
        String symbol = "&symbol=";                        //user entered stock symbol
        String dataFormat = "&datatype=json";               //data set format in JSON
        String baseURL = "https://www.alphavantage.co/query?";  //base URL
        String finalURL;

        Scanner in = new Scanner(System.in);        //declare scanner object
        System.out.println("Please enter the stock ticker symbol you are interested in: ");
        symbol = symbol + in.next().toUpperCase();           //user entered ticker symbol converted to upper case

        //later add code here for user to enter other types of data and stuff that they want

       finalURL = baseURL + dataSet + symbol + apikey + dataFormat;        //builds the final URL used for the GET

        System.out.println(finalURL);


    }

}
