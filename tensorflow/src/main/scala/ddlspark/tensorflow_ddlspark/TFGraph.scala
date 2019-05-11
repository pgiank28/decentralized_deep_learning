package ddlspark.tensorflow_ddlspark

import org.tensorflow._

object TFGraph{

  var sess:Session = _
}

/**
  * Represents a TensorFlow graph, allowing callers to train it locally.
  * This currently only supports graphs that fit in the memory of a single executor, and it executes the 
  * training of the graph with different RDD partitions at every executor,as a
  * complete TensorFlow application on each of the executors seperatevely.  
  *
  */

class TFGraph{
	
}
