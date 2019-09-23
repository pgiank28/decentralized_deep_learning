package org.apache.spark.rpc.netty

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

class ddlDispatcherTest(){
  val envField = ReflectUtil.getDeclaredField(classOf[SparkContext], "org$apache$spark$SparkContext$$_env")
  val sparkEnv: SparkEnv = envField.get(sparkContext).asInstanceOf[SparkEnv]
  val rpcEnvField = ReflectUtil.getDeclaredField(classOf[SparkEnv], "rpcEnv")
  val rpcEnv = rpcEnvField.get(sparkEnv).asInstanceOf[NettyRpcEnv]
  val dispatcherField = ReflectUtil.getDeclaredField(classOf[NettyRpcEnv], "dispatcher")
  val dispatcher = dispatcherField.get(rpcEnv).asInstanceOf[Dispatcher]ddl = new LoggingDispatcher(dispatcher, rpcEnv)
  // Finally override the dispatcher
  dispatcherField.set(rpddl)
 
  val numbersRdd = sparkContext.parallelize(1 to 100, 2)
  val sum = numbersRdd.sum()
  sparkContext.stop()
 
  sum shouldEqual 5050
  val endpointNames = ddlDispatcher.endpoints.map(endpoint => endpoint.name)
  endpointNames should contain allOf("HeartbeatReceiver", "MapOutputTracker", "BlockManagerEndpoint1",
    "BlockManagerMaster", "OutputCommitCoordinatddl.messageTypes should contain allOf(
    "class org.apache.spark.storage.BlockManagerMessages$UpdateBlockInfo",
    "class org.apache.spark.scheduler.local.ReviveOffers$", "class org.apache.spark.scheduler.local.StatusUpdate",
    "class org.apache.spark.scheduler.local.StopExecutor$",
    "class org.apache.spark.StopMapOutputTracker$",
    "class org.apache.spark.storage.BlockManagerMessages$StopBlockManagerMaster$",
    "class org.apache.spark.scheduler.StopCoordinator$")
}
 
// While the getDeclaredField method is a simple getter for Spark's private fields:
def getDeclaredField[T](fieldClass: Class[T], fieldName: String): Field = {
  val searchedField = fieldClass.getDeclaredField(fieldName)
  searchedField.setAccessible(true)
  searchedField
}