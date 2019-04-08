package com.pls.pls_example;

import java.io.File;
import java.io.IOException;

import static com.pls.pls_example.helpers.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	String filePath = new File("").getAbsolutePath();
		filePath = filePath.substring(0, filePath.length() - 3);
//		filePath += "PLS\\data\\housing.csv";
		filePath += "PLS\\data\\WH-4-023_pathway_IC50.csv";
    	double[][] csv = readCSV(filePath);
    	//去除标题行和name列
    	
    	Data data = new Data(csv);
    	
    	PLS_method method = new PLS_method(data.xTrain, data.yTrain, 20);
    	double [][] yPrediction = predict(method, data.xTest);
    	try {
			reportAccuracy(data.yTest, yPrediction, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	System.out.println("done");
    }
}
