package ddlspark.core

import math._
/*** The possible metrics for distances the between global model and the local model ***/
abstract class geometry{

	/*** Eucleidian distance between the vectors x,representing the global
	   * state of the neural network and y,representing the local model
	   * at the learner i
	 ***/
	case class eucleidian extends geometry{
		def distance(x:Array[Float],y:Array[Float]):Float = {
			sqrt((x zip y).map { case (x1,y1) => pow(y1 - x1, 2)} .sum)
		}
	}

	/*** Manhattan distance.***/
	case class manhattan extends geometry{
		def distance(x:Array[Float],y:Array[Float]):Float = {
			0.4
		}
	}


}
