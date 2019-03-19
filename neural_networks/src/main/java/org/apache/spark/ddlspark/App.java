package org.apache.spark.ddlspark;


public class App 
{
    public static void main( String[] args )
    {
        JavaSparkContext sc = new JavaSparkContext("local[2]","ddlspark");

    }
}
