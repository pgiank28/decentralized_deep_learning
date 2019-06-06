package ddlspark.core

import org.apache.spark.rpc.netty._
import org.apache.spark._
import org.apache.spark.network.client._
import org.apache.spark.rpc._
import org.apache.spark.SparkFunSuite


object rpcMainTest{

	val addr = new RpcEndpointAddress("localhost", 12345, "test")
    	assert(addr.toString === "spark://test@localhost:12345") //Test end point address is consistent


	val envField = ReflectUtil.getDeclaredField(classOf[SparkContext], "org$apache$spark$SparkContext$$_env")
  	val sparkEnv: SparkEnv = envField.get(sparkContext).asInstanceOf[SparkEnv]
  	val rpcEnvField = ReflectUtil.getDeclaredField(classOf[SparkEnv], "rpcEnv")
  	val rpcEnv = rpcEnvField.get(sparkEnv).asInstanceOf[NettyRpcEnv]
  	val dispatcherField = ReflectUtil.getDeclaredField(classOf[NettyRpcEnv], "dispatcher")
  	val dispatcher = dispatcherField.get(rpcEnv).asInstanceOf[Dispatcher]
  	val loggingDispatcher = new LoggingDispatcher(dispatcher, rpcEnv)
}


class ddlSparkSuite extends SparkFunSuite{

	val endpoint = 
}
