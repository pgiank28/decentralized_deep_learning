package ddlspark.examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object GraphTrainingExample{

	def main(args:Array[String]){
		val conf:SparkConf = new SparkConf().setAppName("Naive parallel training")
		val sc:SparkContext = new SparkContext(conf)

		sc.stop()	
	}
}
