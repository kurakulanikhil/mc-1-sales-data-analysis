package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SalesDataAnalyzer {
   public List<SalesRecord> readFile(String fileName) {
       List<SalesRecord>    salesRecordList = new ArrayList<>();

       try{
           FileReader fileReader = new FileReader(fileName);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           int count = 0;
           while(bufferedReader.readLine() != null){
               count++;
           }
           fileReader = new FileReader(fileName);
           bufferedReader = new BufferedReader(fileReader);
           bufferedReader.readLine();
           String line = "";
           while((line = bufferedReader.readLine()) != null){
               String[] split = line.split(",");

               salesRecordList.add(new SalesRecord(split[0],Integer.parseInt(split[0]),Integer.parseInt(split[2]),split[3],Double.parseDouble(split[4]),Double.parseDouble(split[5]),Integer.parseInt(split[6]) ));




           }




       }catch (FileNotFoundException e){
           e.printStackTrace();
       }catch (IOException e){
           e.printStackTrace();
       }



       return salesRecordList;
    }

    public List<SalesRecord> getAllCustomersSortedByPurchaseAmount(List<SalesRecord> salesData){
        salesData.sort((s1,s2) -> (int) (s2.getAmount() - s1.getAmount()));
        return salesData;

    }
    public SalesRecord getTopCustomerWhoSpentMaxTimeOnSite(List<SalesRecord> salesData){
        salesData.sort((s1,s2) -> (int) (s2.getTime_on_site() - s1.getTime_on_site()));
        SalesRecord result = salesData.get(0);
        return result;

    }




}
