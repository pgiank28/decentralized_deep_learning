package ddlspark.core

import math._
import ddlspark.core.model

/*** The possible metrics for distances the between global model and the local model ***/
abstract class geometry{

	/*** Eucleidian distance between the vectors x,representing the global
	   * state of the neural network and y,representing the local model
	   * at the learner i
	 ***/
	case class eucleidian() extends geometry{
		def distance(x:model,y:model):Float = {
			//sqrt((x zip y).map { case (x1,y1) => pow(y1 - x1, 2)} .sum)
			1
		}
	}

	/*** Manhattan distance.***/
	case class manhattan(squareSize:Int) extends geometry{
		def distance(x:model,y:model):Float = {
			1
		}
	}


}
