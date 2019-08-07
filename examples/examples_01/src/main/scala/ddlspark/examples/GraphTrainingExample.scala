package ddlspark.examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

//import ddlspark.core.model
//import ddlspark.core.localModel
//import ddlspark.core.activationFunctions


object GraphTrainingExample{

	def main(args:Array[String]){
		val path = "/home/pantelisg/Desktop/train.csv"
		val conf:SparkConf = new SparkConf().setAppName("Naive parallel training")
		val sc:SparkContext = new SparkContext(conf)
		val rdd = sc.textFile(path)

		/** Create model description 
		  * Implemented in the filesystem (neural_networks) with the help
		  * of popular deep learning frameworks like Tensorflow
		  * 
		  * We take an untrained neural network as input and convert it to
		  * an instance of our local model framework (in core) 
		**/

		/*var y = "Reference Model"
		val model = new model(inLayer,hLayer,ouLayer,layers,sSize,acFunction) //General neural network topology
 		val lModel = new localModel(model,x,0,losFunction,0.01,bSize,geometry,sofInput) //Local instance of this topology

		rdd.foreach{x => {y = this.agg(x,y) } }//Must be a singleton object visible(here 'GraphTrainingExample')
		sc.stop()*/	
	}

	/*def agg(s:String,state:localModel):localModel = {
		println("Hi")
		"Hi"
	}*/
}
