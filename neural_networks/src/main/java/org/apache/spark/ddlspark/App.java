package org.apache.spark.ddlspark;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;

public class App 
{
    public static void main( String[] args )
    {
	SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("ddlspark");
        JavaSparkContext sc = new JavaSparkContext(conf);
	
        
    }
}
