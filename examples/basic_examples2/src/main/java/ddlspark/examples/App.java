package ddlspark.examples;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
public class App 
{
    public static void main( String[] args )
    {
        SparkSession spark = SparkSession
      .builder()
      .appName("DDLSpark")
      .getOrCreate();

      JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());
      System.out.println("I made it!!!");
      spark.stop();
    }
}
