name := """saltwater"""
organization := "com.example"

version := "latest"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.5.17" % Test

// Fix docker PID issue
javaOptions in Universal ++= Seq(
  "-Dpidfile.path=/dev/null"
)

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

maintainer := "wisatong wisa.pow@gmail.com"
dockerRepository := Some("wisatong")
