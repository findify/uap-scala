package ua.parser

import java.io.InputStream

import com.google.common.cache.{Cache, CacheBuilder}

case class CachingParser(parser: Parser, size: Int) extends UserAgentStringParser {
  lazy val clients:Cache[String,Client] = CacheBuilder.newBuilder().concurrencyLevel(10).initialCapacity(size).build()
  def parse(agent: String) = Option(clients.getIfPresent(agent)).getOrElse {
    val client = parser.parse(agent)
    clients.put(agent, client)
    client
  }
}

object CachingParser {
  val defaultCacheSize = 1000
  def create(source: InputStream, size: Int = defaultCacheSize) = CachingParser(Parser.create(source), size)
  def get(size: Int = defaultCacheSize) = CachingParser(Parser.get, size)
}
