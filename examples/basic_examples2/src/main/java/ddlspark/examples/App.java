package ddlspark.examples;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import ddlspark.core.NN_Estimator;

public class App 
{
    public static void main( String[] args )
    {
        SparkSession spark = SparkSession
      .builder()
      .appName("JavaSparkPi")
      .getOrCreate();

    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    System.out.println("I made it!!")
    spark.stop();
    }
}
