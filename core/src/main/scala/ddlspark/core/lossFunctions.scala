package ddlspark.core

abstract class lossFunctions{
	case class MSE(learningRate:Int) extends lossFunctions{
		def calc(samples:Array[Array[Int]],labels:Array[Int]):Float = 1
	}

	case class CrossEntropy() extends lossFunctions{
		def calc(samples:Array[Array[Int]],labels:Array[Int]):Float = 1
	}
}
