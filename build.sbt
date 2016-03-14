name := "uap-scala"

organization := "io.findify"

version := "1.1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.yaml" % "snakeyaml" % "1.17",
  "org.specs2" %% "specs2-core" % "2.4.16" % "test",
  "com.google.guava" % "guava" % "19.0"
)

unmanagedResourceDirectories in Compile += baseDirectory.value / "core"

includeFilter in (Compile, unmanagedResources) := "regexes.yaml"

unmanagedResourceDirectories in Test += baseDirectory.value / "core"

includeFilter in (Test, unmanagedResources) := "*.yaml"

licenses += ("WTFPL", url("http://www.wtfpl.net/txt/copying/"))

bintrayOrganization := Some("findify")
