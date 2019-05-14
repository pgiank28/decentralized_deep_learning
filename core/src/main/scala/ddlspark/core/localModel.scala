package ddlspark.core

import ddlspark.util.IOSpace
import ddlspark.tensorflow.TFParams
import ddlspark.core.coord

class localModel(modelType:Int, X:Array[Int], Y:Array[Int], sigma:Int) extends IOSpace{

	
	/*** Managing the input samples
	   *
	 ***/
	override def input(in:Int){
		
	}
	
	override def sample_size = 1
	

        /*** The topology of the network
	   * E.g., Array(780, 100, 10) means 780 inputs,
           * one hidden layer with 100 neurons and output layer of 10 neurons.
         ***/
	final val topology:Array[Int] = NeuralNetwork.getNeurons()

	final val inputLayerParams:Array[Int] = NeuralNetwork.getParams(0)

	final val outputLayerParams:Array[Int] = NeuralNetwork.getParams(layers)

	final val hiddenLayerParams:Array[Int] = NeuralNetwork.getParams(1)

	/*** Initializing local abstract model instance from external trained 
	   * model(TF or MLLib) ***/
	def layers:Int = NeuralNetwork.getLayers()  //Neural network helper function


	/*** The weights of the model at the beginning of the monitoring
	   * They are the same for every learner
	   *
    	   * @return The weights of the model
	***/
	def modelWeights:Array[Float] = NeuralNetwork.getWeights()

	/*** Updating the models weights after synchronization.
	   *
	   * @return The updated weights
	 ***/
	def updateWeights(round:Int):Array[Float] = {
		coord.getWeights(round)
	}

	/*** Current local model.It is used for making predictions and thus measuring models quality.
	   * It consists of three parts;topology,layers and weights
	 ***/
	def model(layers:Int,topology:Array[Int],weights:Array[Float]):Array[Int] = {
		val lays = layers
	}


	/*** The loss function measuring the quality of the local model
	   *
	   * @param The weights of the current model
	   * @param The labeled samples to classify
	   * @return A metric,not only misclassification error, from 0 to 1 where 0 means excellent quality and 1 means bad quality
	***/
	def lossfunction(weights:Array[Float],samples:RDD):float = {
		0.5
	}

	

	/*** Send alert to coordinator that a violation of loss bound occured at this local model.
	   *
	 ***/
	def violation:Int = {
		if(lossfunction(updateWeights(0)) > 0.01){
			0
		}else{
			1
		}
	}
}
