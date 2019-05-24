package ddlspark.core

import ddlspark.util.IOSpace
import ddlspark.tensorflow.TFParams
import ddlspark.core.coord
import ddlspark.core.model
import ddlspark.core.activationFunctions
import ddlspark.core.lossFunctions
import ddlspark.core.geometry

  /*** The local learner i.
     *
     * @param The global model at the very beginning of the local training or after a synchronization.
     * @param The input X stream of samples
     * @param The threshold D that must be respected from the local model
     * @param batchSize, the number of unique training examples per sample.B=1 for online training,B>1 for batch training
     *
   ***/
class localModel(modelType:model, X:Array[Int], id:Int, cost:lossFunctions, threshold:Float,batchSize:Int, distance:geometry) extends IOSpace{

	var referenceModel:model = modelType //The global state of the network.
	val currModel:model = modelType   //The current state of the local learner network
	var MLLossFunction:lossFunctions = cost  //The loss function used for updating weight set
	val T:Int = 0	//The round of training
	var driftMetric:geometry = distance //The distance between global and local model at round T (e.g. eucleidian distance)


	/*** Update the local model at a round T ***/
	private def updateModel(sample:Array[Float]) {
		this.currModel = trainModel(sample)//Change current model by training the network (fi ---> f(i+1) )
		this.T = this.T + 1   //Next round 
	}
		

	/*** The loss function measuring the quality of the local model
	   * It's been used for updating the local model fi in respect to a given learning algorithm.
	   *
	   * @param The labeled samples to classify
	   * @return A metric (misclassification error or other) from 0 to 1 where 0 means excellent quality and 1 means bad quality
	***/

	/*** Abbreviation of the loss of the local model ***/
	def batchLossFunction(samples:Array.ofDim[Int](numOfSamples,sizeOfSamples),labels:Array[Int]):Float = {
		MLLossFunction match{
			case  m:MSE => m.calc(samples,labels)
			case  c:CrossEntropy => c.calc(samples,labels)
		} 
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

	
	/*** Calculate possible violation of the threshold 
	   *
         ***/
	def violation():Boolean{
		// Check if we are at round T mod b = 0 (where b is the batch size)
		if(this.T % this.batchSize == 0){
			// Check if |fi-r|^2 < threshold,where fi is the current model and r the reference global model
			this.driftMetric match{
				case e:eucleidian => e.distance(this.referenceModel,this.currModel) > this.threshold)
				case m:manhattan => m.distance(this.referenceModel,this.currModel) > this.threshold)
			}
		}else{
			false
		}
	}



}
