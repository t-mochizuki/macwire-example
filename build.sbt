lazy val commonSettings = Seq(
  version := "0.0.1",
  scalaVersion := "2.11.7"
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .enablePlugins(play.sbt.PlayScala)

libraryDependencies ++= Seq(
  "com.softwaremill.macwire" %% "macros" % "2.2.2" % "provided",
  "com.softwaremill.macwire" %% "proxy" % "2.2.2",
  "com.softwaremill.macwire" %% "util"   % "2.2.2"
)

routesGenerator := InjectedRoutesGenerator
