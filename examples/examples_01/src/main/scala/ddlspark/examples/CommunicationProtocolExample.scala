package ddlspark.examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object CommunicationProtocolExample{

	def main(args:Array[String]){
		
		
		val conf:SparkConf = new SparkConf().setAppName("Naive parallel training")
		val sc:SparkContext = new SparkContext(conf)
		val rdd = sc.parallelize(Seq(("Sunday",1),("Monday",2),("Tuesday",3),("Wednesday",4),("Thursday",5)))

		rdd.foreach{ x=> { this.com(x) } }
		sc.stop()
	}

	def com(s:(String,Int)){
		print(s)
	}
}
