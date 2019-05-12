package ddlspark.core

import ddlspark.util.IOSpace
import ddlspark.neural_networks._

class localModel(modelType:Int, X:Array[Int], Y:Array[Int], sigma:Int) extends IOSpace{
	
	override def input(in:Int){
		
	}
	
	override def sample_size = 1
	

	/*** Sizes of layers from input layer to output layer.
           * E.g., Array(780, 100, 10) means 780 inputs,
           * one hidden layer with 100 neurons and output layer of 10 neurons.***/
	final val topology:Array[Int] = NeuralNetwork.getNeurons()

	final val inputLayerParams:Array[Int] = NeuralNetwork.getParams(0)

	final val outputLayerParams:Array[Int] = NeuralNetwork.getParams(layers)

	final val hiddenLayerParams:Array[Int] = NeuralNetwork.getParams(1)

	/*** Initializing local abstract model instance from external trained 
	   * model(TF or MLLib) ***/
	def layers:Int = NeuralNetwork.getLayers()  //Neural network helper function

	def model(layers:Int,topology:Array[Int]):Array[Int] = {
		/*** This function does not train a model,but gets a trained single-node neural network
		   * model and abbreviates it to a local model ,so it can easily be aggregated ***/	
}
