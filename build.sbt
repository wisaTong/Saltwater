name := """saltwater"""
organization := "com.example"

version := "0.4.2-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  guice
  , ws
  , "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
  , "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.6"
  , "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.9.7"
  , "com.google.firebase" % "firebase-admin" % "6.5.0"
)

excludeDependencies ++= Seq(
  ExclusionRule("com.typesafe.play", "play-java")
  , ExclusionRule("com.typesafe.play", "play-json")
)

coverageExcludedPackages := "<empty>;Reverse.*;router\\.*"

// Fix docker PID issue
javaOptions in Universal ++= Seq(
  "-Dpidfile.path=/dev/null"
)

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

maintainer := "wisatong wisa.pow@gmail.com"
dockerRepository := Some("wisatong")
