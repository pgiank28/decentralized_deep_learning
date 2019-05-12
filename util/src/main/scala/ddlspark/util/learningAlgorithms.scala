package ddlspark.util

/**
  * Custom object for using only those learning algorithms 
  * available from the system at
  * each local learner i
**/

object learningAlgorithm extends Enumeration{

	type learningAlgorithm = Value
	val minibatchSGD,classicSGD = Value  //mini-batch Stohastic gradient descent and Stochastic gradient descent currently available
}

