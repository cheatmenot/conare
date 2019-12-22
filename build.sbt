lazy val commonSettings = Seq(
  scalaVersion := "2.12.9",
  organization := "com.melvic",
  resolvers += Resolver.sonatypeRepo("releases"),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
)

lazy val scalaReflect = Def.setting { "org.scala-lang" % "scala-reflect" % scalaVersion.value }

lazy val core = (project in file("core"))
  .dependsOn(macros)
  .settings(
    commonSettings,
  )

lazy val macros = (project in file("macros"))
  .settings(
    commonSettings,
    libraryDependencies += scalaReflect.value
  )
