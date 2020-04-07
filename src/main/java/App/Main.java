package App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String dataSet = "function=TIME_SERIES_DAILY";       //type of info about the symbol that is selected
        String apiKey = "&apikey=D44LPNJ4W7DXPN2Y";         //alpha vantage apikey
        String symbol = "&symbol=";                        //user entered stock symbol
        String dataFormat = "&datatype=json";               //data set format in JSON
        String baseURL = "https://www.alphavantage.co/query?";  //base URL
        String finalURL;

        Scanner in = new Scanner(System.in);        //declare scanner object
        System.out.println("Please enter the stock ticker symbol you are interested in: ");
        symbol = symbol + in.next().toUpperCase();           //user entered ticker symbol converted to upper case

        //later add code here for user to enter other types of data and stuff that they want

        finalURL = baseURL + dataSet + symbol + apiKey + dataFormat;        //builds the final URL used for the GET

        System.out.println(finalURL);

        URL urlAddress = new URL(finalURL);         //utilize the URL object
        HttpURLConnection connect = (HttpURLConnection)urlAddress.openConnection();     //open a url connection and set it to GET
        connect.setRequestMethod("GET");        //set the request method to GET
        System.out.println("Sending GET...");

        BufferedReader inStream = new BufferedReader(new InputStreamReader(connect.getInputStream()));      //creates a buffered reader that takes in larger streams and stores what is needed. Inputstream reads only a few bytes at a time
        StringBuilder getResponse = new StringBuilder();        //String used to append and build the response from the HTTP get request
        String nextLine;                //holds the next line to be read and added to the getResponse

        while ((nextLine = inStream.readLine()) != null)    {
            getResponse.append(nextLine + "\n");           //keep adding the next line of the program to the end of the getResponse String builder until null
        }


        inStream.close();       //close the input stream
        System.out.println(getResponse.toString());     //print the contents of getResponse

    }



    }


