package ddlspark.examples;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;

public class App 
{
    public static void main( String[] args )
    {
	SparkConf conf = new SparkConf().setAppName("master-slave example").setMaster("local");
	JavaSparkContext sc = new JavaSparkContext(conf);
        System.out.println( "Hello World!" );
	JavaRDD<String> distFile = sc.textFile("file:///home/pantelisg/Desktop/data.txt");
	distFile.map(s->s.length()).reduce((a,b)->a+b);
	sc.stop();
    }
}
