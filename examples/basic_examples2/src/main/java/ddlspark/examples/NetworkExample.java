package ddlspark.examples;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;

import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

//import org.apache.spark.api.java.function;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.StorageLevels;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.hadoop.fs.FileSystem;

public class NetworkExample{
	public static void main(String[] args) throws Exception{
	

		if (args.length < 2) {
      			System.err.println("Usage: NetworkExample <hostname> <port>");
      			System.exit(1);
    		}
		SparkConf sparkConf = new SparkConf().setAppName("NetworkExample");
    		JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(1));//1 secbatch size
		JavaReceiverInputDStream<String> lines = ssc.socketTextStream(args[0],	Integer.parseInt(args[1]),StorageLevels.MEMORY_AND_DISK_SER); // Create a JavaReceiverInputDStream on target ip:port
		

		// Convert RDDs of the weights to DataFrame for ML compatibility
		lines.foreachRDD(convRDDtoDF.rddToDf(rdd,time));
		ssc.start();
		ssc.awaitTermination();
	}
}

private static class convRDDtoDF implements VoidFunction2{
	private void rddToDf(rdd rdd,time time){
		SparkSession spark = JavaSparkSessionSingleton.getInstance(rdd.context().getConf());
		JavaRDD<JavaRecord> rowRDD = rdd.map(setTuple.getJR(tuple));
		Dataset<Row> NNDataFrame = spark.createDataFrame(rowRDD, JavaRecord.class);

		// Creates a temporary view using the DataFrame
      		NNDataFrame.createOrReplaceTempView("words");
	}
}

private static class setTuple{
	public JavaRecord getJR(tuple tuple){
		JavaRecord record = new JavaRecord();
        	record.setWord(tuple);
        	return record;
	}
}
