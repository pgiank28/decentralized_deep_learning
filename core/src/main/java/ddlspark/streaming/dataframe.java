package ddlspark.streaming;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class dataframe{
	private SparkSession ss;
	private JavaSparkContext jsc;
	private Dataset<Row> df;

	public dataframe(SparkSession ss,JavaSparkContext jsc){
		this.ss = ss;
		this.jsc = jsc;
	}

	public Dataset<Row> call(String inputPath){
		
		//df = spark.read.format("csv").option("header", "true").load(inputPath);
		return df;
	}

}
