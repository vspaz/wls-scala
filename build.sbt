ThisBuild / organization := "org.vspaz"
ThisBuild / version := "0.2.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.10"

val scalaDependencies = Seq(
  // Test dependencies
  "org.scalatest" %% "scalatest" % "3.2.15" % Test,
  "org.junit.jupiter" % "junit-jupiter-api" % "5.9.2",
  "com.novocode" % "junit-interface" % "0.11"
)

libraryDependencies ++= scalaDependencies

lazy val root = (project in file(".")).settings(
  name := "wls-scala",
  assembly / mainClass := Some("org.vspaz.Main"),
  ThisBuild / assemblyMergeStrategy := {
    case PathList("META-INF", _*) => MergeStrategy.discard
    case _                        => MergeStrategy.first
  }
)