UA Parser Scala Library (findify fork)
======================

This is the Scala implementation of [ua-parser](https://github.com/tobie/ua-parser).
The implementation uses the shared regex patterns and overrides from regexes.yaml.
Maintained by findify, as the original author seems dead.

How to use with sbt:
------

    resolvers += Resolver.bintrayRepo("findify", "maven")
    libraryDependencies += "io.findify" %% "uap-scala" % "1.0.0"

Usage:
--------
```scala
import ua.parser.Parser

  val ua = "Mozilla/5.0 (iPhone; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3"
  val client = Parser.get.parse(ua) // you can also use CachingParser
  println(client) // Client(UserAgent(Mobile Safari,Some(5),Some(1),None),OS(iOS,Some(5),Some(1),Some(1),None),Device(iPhone))
}
```

Author:
-------

  * Piotr Adamski [@mcveat](https://twitter.com/mcveat), original author
  * [André Cardoso](https://github.com/belerophon), updating for the latest spec
  * [Roman Grebennikov](https://github.com/shuttie), maven/bintray packaging

  Based on the java implementation by Steve Jiang [@sjiang](https://twitter.com/sjiang) and using agent data from BrowserScope
