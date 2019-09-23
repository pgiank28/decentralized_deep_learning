package org.apache.spark.rpc.netty;
import org.apache.spark.network.client.RpcResponseCallback
import org.apache.spark.rpc.{RpcEndpoint, RpcEndpointRef}
 
import scala.concurrent.Promise
 
class ddlDispatcher(delegate: Dispatcher, nettyEnv: NettyRpcEnv) extends Dispatcher(nettyEnv,1) {
 
  var endpoints: Seq[RpcEndpointRef] = Seq.empty
 
  var messageTypes: Seq[String] = Seq.empty
 
  override def registerRpcEndpoint(name: String, endpoint: RpcEndpoint): NettyRpcEndpointRef =
    delegate.registerRpcEndpoint(name, endpoint)
 
  override def getRpcEndpointRef(endpoint: RpcEndpoint): RpcEndpointRef = delegate.getRpcEndpointRef(endpoint)
 
  override def removeRpcEndpointRef(endpoint: RpcEndpoint): Unit = delegate.removeRpcEndpointRef(endpoint)
 
  override def stop(rpcEndpointRef: RpcEndpointRef): Unit = {
    endpoints = endpoints :+ rpcEndpointRef
    delegate.stop(rpcEndpointRef)
  }
 
  override def postToAll(message: InboxMessage): Unit = delegate.postToAll(message)
 
  override def postRemoteMessage(message: RequestMessage, callback: RpcResponseCallback): Unit = {
    delegate.postRemoteMessage(message, callback)
    handleMessage(message)
  }
 
  override def postLocalMessage(message: RequestMessage, p: Promise[Any]): Unit = {
    delegate.postLocalMessage(message, p)
    handleMessage(message)
  }
 
  override def postOneWayMessage(message: RequestMessage): Unit = {
    handleMessage(message)
    delegate.postOneWayMessage(message)
  }
 
  private def handleMessage(message: RequestMessage) = messageTypes = messageTypes :+ message.content.getClass.toString
 
  override def stop(): Unit = delegate.stop()
 
  override def awaitTermination(): Unit = delegate.awaitTermination()
 
  override def verify(name: String): Boolean = delegate.verify(name)
 
}