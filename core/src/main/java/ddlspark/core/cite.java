package ddlspark.core;
import org.apache.spark.sql.Dataset;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

public class cite{
      Tensor state;
      public static void createTfCluster(Graph g)throws Exception{
        
          try(Session s = new Session(g)){
            this.state = s.runner.fetch("weights").run();
          }
        
}
