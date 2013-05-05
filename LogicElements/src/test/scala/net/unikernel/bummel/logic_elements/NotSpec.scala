package net.unikernel.bummel.logic_elements;
import java.util
import net.unikernel.bummel.logic_elements.Not.Not;
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, FlatSpec}
import scala.collection.JavaConverters._

class NotSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {

 type Signals = util.TreeMap[String, java.lang.Double]

 var not_instance: Not = _

  before {
    not_instance = new Not()
  }

  after {
    not_instance = null;
  }
  
  "Not element" should "return 1 for 00 input" in {
   val valuesOnPorts = new Signals {
      put("input", 0)
      put("output", 0)
    }
    
    val result = not_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output") should equal (1)

  }
  
  it should "return 1 for 01 input" in {
    val valuesOnPorts = new Signals {
      put("input", 0)
      put("output", 1)
    }
    
    val result = not_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output") should equal (1)
  }
  
  it should "return 0 for 10 input" in {
    val valuesOnPorts = new Signals {
      put("input", 1)
      put("output", 0)
    }
    
    val result = not_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output") should equal (0)
  }
  
  it should "return 0 for 11 input" in {
    val valuesOnPorts = new Signals {
      put("input", 1)
      put("output", 1)
    }
    
    val result = not_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output") should equal (0)
  }
}

