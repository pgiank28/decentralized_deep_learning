package ddlspark.util

/** Class for transforming models data types to Spark data types **/

trait IOSpace{
	def sample_size:Int
	def input(in:Int)
}
