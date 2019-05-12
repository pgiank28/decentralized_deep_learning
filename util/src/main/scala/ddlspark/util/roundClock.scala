package ddlspark.util



trait roundClock{
	val Round:Int 		//Round T where a local learner observes a sample
	val time_period:Float   //Time period t in ms between two rounds 
}

