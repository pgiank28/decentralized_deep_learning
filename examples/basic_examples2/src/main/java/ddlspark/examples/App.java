package ddlspark.examples;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
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
    Dataset df = spark.read().format("csv").option("header","true").load(args[0]);
    NN_Estimator nn = new NN_Estimator(2);
    nn.train(df);
    spark.stop();
    }
}
