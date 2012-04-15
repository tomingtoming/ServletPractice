name := "jetty-servlet"

version := "0.0.1"

scalaVersion := "2.9.1"

seq(webSettings :_*)

libraryDependencies += "org.mortbay.jetty" % "jetty" % "6.1.22" % "container"

libraryDependencies += "javax.servlet" % "servlet-api" % "2.5"

