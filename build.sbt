lazy val commonSettings = Seq(
  version := "0.0.1",
  scalaVersion := "2.11.7"
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .enablePlugins(play.sbt.PlayScala)

libraryDependencies ++= Seq(
  "com.softwaremill.macwire" %% "macros" % "2.2.2" % "provided",
  "com.softwaremill.macwire" %% "util"   % "2.2.2",
  "com.h2database"  %  "h2"                               % "1.4.189",
  "org.scalikejdbc" %% "scalikejdbc"                      % "2.2.9",
  "org.scalikejdbc" %% "scalikejdbc-config"               % "2.2.9",
  "org.scalikejdbc" %% "scalikejdbc-syntax-support-macro" % "2.2.9",
  "org.scalikejdbc" %% "scalikejdbc-play-initializer"     % "2.4.3",
  "org.flywaydb"    %% "flyway-play"                      % "2.2.1"
)

routesGenerator := InjectedRoutesGenerator
