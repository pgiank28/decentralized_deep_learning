package ddlspark.tensorflow;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.apache.spark.sql.Row;
import org.apache.spark.api.java.function.Function2;
import ddlspark.tensorflow.cite;
import ddlspark.util.tuple;

public class citePort implements Function2<tuple,tuple,tuple>{
	
	
	public tuple call(tuple s,tuple t){
		Graph g = new Graph();
		//Map the input row to the graph for training
		try( Session sess = new Session(g);
		     Tensor output = sess.runner().fetch("MyConst").run().get(0)){
			System.out.println(new String(output.bytesValue()));
		}
			
		return s;
	}
}

