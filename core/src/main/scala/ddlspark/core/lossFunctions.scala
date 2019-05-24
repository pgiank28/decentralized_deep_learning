package ddlspark.core

abstract class lossFunctions{
	case class MSE extends lossFunctions{
		def calc(samples:Array.ofDim[Int](a,b),labels:Array[Int]):Float = 0.5
	}

	case class CrossEntropy extends lossFunctions{
		def calc(samples:Array.ofDim[Int](a,b),labels:Array[Int]):Float = 0.5
	}
}
