package ddlspark.core

import ddlspark.core.model
import scala.math.{exp,tanh}

/*** The available activation functions for the network.
   * Available functions are sigmoid,perceptron and tanh.
 ***/
abstract class activationFunctions{

	case class perceptron(boundary:Float) extends activationFunctions{
		def calc(samp:Array[Float],weights:Array[Float],bias:Int):Int = if(sum(samp,weights)<bias) 0 else 1
	}

	case class sigmoid(lowBoundary:Float,upperBoundary:Float) extends activationFunctions{
		def calc(samp:Array[Float],weights:Array[Float],bias:Int):Int = if(1/(1+exp(-sum(samp,weights)))<bias) 0 else 1
	}

	case class tan_h() extends activationFunctions{
		def calc(samp:Array[Float],weights:Array[Float],bias:Int):Int = if(tanh(sum(samp,weights))<bias) 0 else 1
	}

	def sum(samp:Array[Float],weights:Array[Float]):Int = {
			val sum = 0
			//w0*x0 + w1*x1 + w2*x2 + .... +wn*xn 
			for(i <- 1 to samp.length){
				sum += samp(i)*weights(i)
			}
			sum
	}
}
