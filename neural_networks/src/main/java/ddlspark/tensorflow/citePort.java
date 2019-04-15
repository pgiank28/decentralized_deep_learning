package ddlspark.tensorflow;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.apache.spark.sql.Row;
import org.apache.spark.api.java.function.Function;
import ddlspark.tensorflow.cite;
import ddlspark.util.tuple;

public class citePort implements Function<Row,Row>{
	
	
	public Row call(Row r){
		Graph g = new Graph();
		//Map the input row to the graph for training
		try( Session sess = new Session(g)){
			System.out.println(new String(output.bytesValue()));
		}
			
		return r;
	}
}

