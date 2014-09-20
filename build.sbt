name := """Test"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"
 
resolvers += "Sedis Repo" at "http://pk11-scratch.googlecode.com/svn/trunk"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "com.typesafe" % "play-plugins-redis_2.10" % "2.1.1"
)
