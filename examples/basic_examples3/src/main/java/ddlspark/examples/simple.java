package ddlspark.examples;

import java.io.Serializable;
import java.io.*;
import scala.Tuple2;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.tensorflow.Graph;
import org.tensorflow.TensorFlow;
import org.tensorflow.Tensor;
import ddlspark.tensorflow.cite;
import ddlspark.tensorflow.citePort;
import ddlspark.tensorflow.tensorflow_graph;

public class simple{
	public static void main( String[] args )
    {
	
	SparkConf conf = new SparkConf().setAppName("master-slave example").setMaster("local[2]");
	//JavaSparkContext sc = new JavaSparkContext(conf);
	
	SparkSession session = SparkSession.builder().getOrCreate();
	System.out.println( "Starting training session" );
	
	//------Dataset API (...later...)
	//Dataset<Row> df = session.read().csv("file:///home/pantelisg/Desktop/train.csv");
	//df.map(MapFunction<T,U> func, Encoder<U> encoder)

    	Dataset<Row> input = session.read().format("csv").load("file:///home/pantelisg/Desktop/train.csv");
        
	try (Graph g = new Graph()) {
      		final String value = "Hello from " + TensorFlow.version();

      		// Construct the computation graph with a single operation, a constant
      		// named "MyConst" with a value "value".
      		try (Tensor t = Tensor.create(value.getBytes("UTF-8"))) {
        		// The Java API doesn't yet include convenience functions for adding operations.
        		g.opBuilder("Const", "MyConst").setAttr("dtype", t.dataType()).setAttr("value", t).build();
			Broadcast<Graph> tf_nn = session.broadcast(tensorflow_graph(g));
        		Graph tf_trained_graph = input.javaRDD().reduce(s->(citePort.training_function(s)));

			//tf_trained_graph.saveAsTextFile("file:///home/pantelisg/Desktop/output");
		}catch(UnsupportedEncodingException e){
		
		}
	}

	session.stop();
    }

 
}


