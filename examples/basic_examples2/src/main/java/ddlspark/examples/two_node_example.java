package ddlspark.examples;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.hadoop.fs.FileSystem;
import ddlspark.core.NN_Estimator;

public class two_node_example 
{
    public static void main( String[] args )
    {
        SparkSession spark = SparkSession
      .builder()
      .appName("JavaSparkPi")
      .getOrCreate();
 
    JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
    Dataset<float> tuples = spark.read.format("csv").option("header","true").load(args[0]);
    System.out.println(tuples.count());
    spark.stop();
    }
}
