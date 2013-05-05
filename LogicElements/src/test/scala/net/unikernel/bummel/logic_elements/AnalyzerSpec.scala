package net.unikernel.bummel.logic_elements;
import java.util
import net.unikernel.bummel.logic_elements.Analyzer.Analyzer;
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, FlatSpec}
import scala.collection.JavaConverters._

class AnalyzerSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {

 type Signals = util.TreeMap[String, java.lang.Double]

 var analyzer: Analyzer = _

  before {
    analyzer = new Analyzer();
  }

  after {
    analyzer = null;
  }
  
  "Analyzer element" should "return 0 state for 0 input" in {
   val valuesOnPorts = new Signals {
      put("input", 0)
    }
    
    val result = analyzer.process(valuesOnPorts).asScala

    result("input") should equal (0)
    analyzer.getState() should equal (0)
  }
  
  it should "return 1 state for 1 input" in {
    val valuesOnPorts = new Signals {
      put("input", 1)
    }

    val result = analyzer.process(valuesOnPorts).asScala

    result("input") should equal (0)
    analyzer.getState() should equal (1)
  }

}

