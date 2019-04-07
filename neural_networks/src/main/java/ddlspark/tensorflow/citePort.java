package ddlspark.tensorflow;

import java.io.Serializable;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.apache.spark.sql.Row;
import ddlspark.tensorflow.cite;

public class citePort implements Serializable{
	private Graph null_graph;
	public citePort(){

	}
	
	public static Graph training_function(Row s,Graph g){
		//Map the input row to the graph for training
		try( Session sess = new Session(g);
		     Tensor output = sess.runner().fetch("MyConst").run().get(0)){
			System.out.println(new String(output.bytesValue()));
		}
			
		return g;
	}
}
