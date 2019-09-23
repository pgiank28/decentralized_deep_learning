package ddlspark.tensorflow

import org.apache.spark.sql.Dataset

class TFParams{

	

	def getParams(layerDepth:Int):Array[Int] = {
		Array(0,0,0);
	}

	def getLayers:Array[Int] = {
		Array(0,0,0);
	}

	def getNeurons:Array[Int] = {
		Array(0,0,0);
	}	
}
