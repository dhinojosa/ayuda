package com.evolutionnext.ayuda.parsing

import org.scalatest.{Matchers, FunSpec}
import scala.io.Source
import java.io.StringWriter

/**
 *
 * @author Daniel Hinojosa
 * @since 12/24/13 1:03 PM
 *        url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 *        email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 *        tel: 505.363.5832
 */
class ParsingWithIndexSpec extends FunSpec with Matchers {
  describe("testing a basic parsing with indexes") {
    it("should render some content from the parsing") {
      import org.asciidoctor.Asciidoctor.Factory._
      import scala.collection.JavaConverters._
      val asciidoctor = create
      val rendered = asciidoctor.render("*This* is it.", Map[String, AnyRef]().asJava)
      println(rendered)
    }

    it("should render some content with indexes from a document with indexes") {
      import org.asciidoctor.Asciidoctor.Factory._
      import scala.collection.JavaConverters._
      val asciidoctor = create

      println(Source.fromURL(this.getClass.getResource("/document_with_indexes.asc")))
      val out = Source.fromURL(this.getClass.getResource("/document_with_indexes.asc")).bufferedReader()
      val writer = new StringWriter()
      asciidoctor.render(out, writer, Map[String, AnyRef]().asJava)
      println(writer.toString)
    }
  }
}
