organization := "com.example"

name := "$name$"

version := "$version$"

scalaVersion := "$scala_version$"

resolvers += "twitter-repo" at "http://maven.twttr.com"

libraryDependencies ++= Seq( "com.twitter" % "finagle-core" % "$finagle_version$", 
		             "com.twitter" % "finagle-http" % "$finagle_version$")