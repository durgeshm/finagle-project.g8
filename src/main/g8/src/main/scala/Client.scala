package com.example

import org.jboss.netty.handler.codec.http.{HttpRequest, HttpResponse, DefaultHttpRequest}
import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.http.{Http, Request, Version, Method}
import com.twitter.finagle.Service
import com.twitter.util.Future
import java.net.InetSocketAddress

object Client {

  val client = ClientBuilder()
    .codec(Http())
    .hosts("localhost:10000")
    .hostConnectionLimit(1)
    .build()

  def main(args: Array[String]){
    println("Sending GET request to http://localhost:10000")    
    
    val request = new DefaultHttpRequest(Version.Http11, Method.Get, "/")                      
    val responseFuture = client(request)                                 
    
    responseFuture onSuccess { 
      response => println("Received response: " + response)                        
    }

    client.release()
  }
}
