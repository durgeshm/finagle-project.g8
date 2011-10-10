package com.example

import org.jboss.netty.handler.codec.http.{HttpRequest, HttpResponse, DefaultHttpResponse}
import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.http.{Http, Response, Version, Status}
import com.twitter.finagle.Service
import com.twitter.util.Future
import java.net.InetSocketAddress

object Server {

  val service = new Service[HttpRequest, HttpResponse] {
    def apply(request: HttpRequest) = {
      val response = Response()
      response.setContentString("Hello from Finagle\n")
      Future.value(response)
    }
  }

  val address = new InetSocketAddress(10000)
  
  def start() = ServerBuilder()
      .codec(Http())
      .name("HttpServer")
      .bindTo(address)
      .build(service)

  def main(args: Array[String]){
    println("Start HTTP server on port 10000")
    val server = start()

    // if/when you want to stop the server, you can use server.close()
  }
}
