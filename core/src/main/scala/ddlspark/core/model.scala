package ddlspark.core

import ddlspark.core.activationFunctions

	/*** The basic represantation of the weights of a neural network.
	   * Instances of this class are passed through coordinator and cides.
	   * It represents the state f of a neural network model
	   * @params 3 arrays representing the weights of the layers --> inputLayer,hiddenLayer and outputLayer
	   * @params The number of neurons at each layer representing the topology of the network --> layers
	   * @params The activation function of the neurons --> function
  	 ***/

class model(inputLayer:Array[Array[Float]], hiddenLayer:Array[Array[Float]], outputLayer:Array[Array[Float]], layers:Array[Int],sampleSize:Int,function:activationFunctions){
	
	/*** The representation of the local instance of the neural network at time T.
   	   * It has three layers;input,hidden and output layer.
   	   * Each layer is a 2D array with rows being the neuron of the layers and columns the corresponding weights.
   	   * E.g. inputLayer = [3   -2  -0.1  0.56  2]
   	   *		       [3.2 -1  -1.23 0.44 1.9]
   	   *		       [3.3 -2  -0.16 0.5   2]
   	   * means that for neuron 1 of the input layer the weight vector is [3,-2,-0.1,0.56,2],for neuron 2 [3.2,-1,-1.23,0.44,1.9] etc.
   	   * This represantation is used for predictions only and is isolated from the framework used for training.
   	   * Every layer change their values after a sunchronization,
	   * and are initialized from an external
   	   * source containing a trained network(e.g. Tensorflow)
 	 ***/
	val input_layer:Array[Array[Float]] = inputLayer
	val hidden_layer:Array[Array[Float]] = hiddenLayer
	val output_layer:Array[Array[Float]] = outputLayer


	/*** The activation function of the neurons.It returns a number from 0 to 1 ***/
	val activation_function:activationFunctions = function


	/*** Checking if the sample input has the proper size
	   * @return 0 for invalid,1 for valid
	 ***/ 
	val inputGood:Int = 1
	val inputBad:Int = 0

	def inputConsistency(sample:Array[Int]):Int = {
		if(sample.size != sampleSize){
			print("Unacceptable sample size\n")
			inputGood
		}else{
			inputBad
		}
	}
}


