package ddlspark.core

import ddlspark.util.IOSpace
import ddlspark.tensorflow.TFParams
import ddlspark.core.coord
import ddlspark.core.model
import ddlspark.core.activationFunction

  /*** The local learner i.
     *
     * @param The global model at the very beginning of the local training or after a synchronization.
     * @param The input X stream of samples
     * @param The threshold D that must be respected from the local model
     * 
   ***/
class localModel(modelType:model, X:Array[Int], id:Int, threshold:Float) extends IOSpace{

	var referenceModel:model = modelType //The global state of the network.
	val currModel:model = modelType   //The current state of the local learner network
	val T:Int = 0

	/*** Update the local model at each round T ***/
	private def updateModel(round:Int,sample:Array[Float]) {
		this.currModel = trainModel(sample)//Change current model by training the network (fi ---> f(i+1) )
		this.T = round 
	}
		

	/*** The loss function measuring the quality of the local model
	   * It's been used for updating the local model fi in respect to a given learning algorithm.
	   *
	   * @param The labeled samples to classify
	   * @return A metric (misclassification error or other) from 0 to 1 where 0 means excellent quality and 1 means bad quality
	***/

	/*** Abbreviation of the loss of the local model ***/
	def batchLossFunction(samples:Array.ofDim[Int](numOfSamples,sizeOfSamples),labels:Array[Int]):Float = {
		0.5
	}

	/*** The loss function for one sample ***/
	def lossFunction(sample:Array[Int],label:Int):Float = {
		0.1
	}


	/*** Prediction for a unique sample given a neural network ***/
	def pred(sample:Array[Int],func:activationFunction):Array[Float] = LayerPrediction(LayerPrediction(LayerPrediction(sample,0),1),2)
		

	/*** Calculate the output of one layer neurons as an array.
	   * For input layer,sample is the tuple for prediction.
	   * In case of the hidden and the output layer,sample is the output of the previous layer***/
	def LayerPrediction(sample:Array[Float],layer:Int):Array[Int] = {
		
		val j:Int = 0
		if(layer==0){
			val inputToHiddenResults:Array[Float] = new Array[Float](cur_model.inputLayer.w)
			for(row <- cur_model.inputLayer){
				inputToHiddenResults[j] = cur_model.activation_function.calc(sample,row,0)
				j=j+1
			}
			inputToHiddenResults
		}

		
		if(layer==1){
			val hiddenToOutputResults:Array[Float] = new Array[Float](cur_model.hiddenLayer.w2)
			for(row <- cur_model.hiddenLayer){
				hiddenToOutputResults[j] = cur_model.activation_function.calc(sample,row,0)
				j=j+1
			}
			hiddenToOutputResults
		}
				

		if(layer==2){
			val outputResults:Array[Float] = new Array[Float](cur_model.outputLayer.w3)
			for(row <- cur_model.outputLayer){
				outputResults[j] = cur_model.activation_function.calc(sample,row,0)
				j=j+1
			}
			outputResults
		}
	}

	/*** Update fi using the learning algorithm phi ***/
	
	/*** Calculate possible violation of the threshold 
	   *
         ***/
	def violation(){
		// Check if we are at round T mod b = 0 (where b is the batch size)
		
		// Check if |fi-r|^2 < threshold,where fi is the current model and r the reference global model
	}

}
