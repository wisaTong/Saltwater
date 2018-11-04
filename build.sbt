name := """saltwater"""
organization := "com.example"

version := "latest"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  guice
  , "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
  , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.6"
  , "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.9.7"
)

excludeDependencies ++= Seq(
  ExclusionRule("com.typesafe.play", "play-java")
  , ExclusionRule("com.typesafe.play", "play-json")
)


// Fix docker PID issue
javaOptions in Universal ++= Seq(
  "-Dpidfile.path=/dev/null"
)

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

maintainer := "wisatong wisa.pow@gmail.com"
dockerRepository := Some("wisatong")
