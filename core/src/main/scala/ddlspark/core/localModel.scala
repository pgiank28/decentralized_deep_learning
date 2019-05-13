package ddlspark.core

import ddlspark.util.IOSpace
import ddlspark.tensorflow.TFParams

class localModel(modelType:Int, X:Array[Int], Y:Array[Int], sigma:Int) extends IOSpace{
	
	override def input(in:Int){
		
	}
	
	override def sample_size = 1
	

        /*** E.g., Array(780, 100, 10) means 780 inputs,
           * one hidden layer with 100 neurons and output layer of 10 neurons.***/
	final val topology:Array[Int] = NeuralNetwork.getNeurons()

	final val inputLayerParams:Array[Int] = NeuralNetwork.getParams(0)

	final val outputLayerParams:Array[Int] = NeuralNetwork.getParams(layers)

	final val hiddenLayerParams:Array[Int] = NeuralNetwork.getParams(1)

	/*** Initializing local abstract model instance from external trained 
	   * model(TF or MLLib) ***/
	def layers:Int = NeuralNetwork.getLayers()  //Neural network helper function


	/*** The weights of the model at the beginning of the beginning of the monitoring
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

	def model(layers:Int,topology:Array[Int]):Array[Int] = {
		/*** This function does not train a model,but gets a trained single-node neural network

		   * model and abbreviates it to a local model ,so it can easily be aggregated ***/


	/*** The loss function measuring the quality of the local model
	   *
	   * @param The weights of the current model
	   * @param The labeled samples to classify
	   * @return A metric,not only misclassification error, from 0 to 1 where 0 means excellent quality and 1 means bad quality
	***/
	def lossfunction(weights:Array[Float],samples:RDD):float = {
		0.5
	}


	
}
