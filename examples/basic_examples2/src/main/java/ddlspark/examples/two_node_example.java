package ddlspark.examples;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import ddlspark.core.NN_Estimator;

public class two_node_example 
{
    public static void main( String[] args )
    {
        SparkSession spark = SparkSession
      .builder()
      .appName("JavaSparkPi")
      .getOrCreate();

    NN_Estimator ne; 
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    ne = new NN_Estimator(12);
    ne.printConf();
    System.out.println("I made it!!");
    spark.stop();
    }
}
