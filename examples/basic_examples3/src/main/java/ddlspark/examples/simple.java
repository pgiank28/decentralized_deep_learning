package ddlspark.examples;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class simple{
	public static void main( String[] args )
    {
	SparkConf conf = new SparkConf().setAppName("master-slave example").setMaster("local[2]");
	//JavaSparkContext sc = new JavaSparkContext(conf);
	
	SparkSession session = SparkSession.builder().getOrCreate();
	System.out.println( "Starting training session" );
	
	//JavaRDD<String> distFile = sc.textFile("file:///home/pantelisg/Desktop/data.txt");
	Dataset<Row> df = session.read().csv("file:///home/pantelisg/Desktop/train.csv");
	
    	df.show(13);
        
        
	session.stop();
    }


}
