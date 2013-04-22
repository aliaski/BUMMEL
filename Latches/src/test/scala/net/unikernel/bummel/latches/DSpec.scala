package net.unikernel.bummel.latches;
import java.util
import net.unikernel.bummel.latches.D.D;
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, FlatSpec}
import scala.collection.JavaConverters._

class DSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {

 type Signals = util.TreeMap[String, java.lang.Double]

 var d: D = _

  before {
    d = new D()
  }

  after {
    d = null;
  }
  
  "D element" should "have 0 on T when it receives 0 on D, 0 on C and has state: 0" in {
    d.state = 0;
   val valuesOnPorts = new Signals {
      put("d", 0)
      put("c", 0)
      put("t", 0)
    }
    
    val result = d.process(valuesOnPorts).asScala

    result("d") should equal (0)
    result("c") should equal (0)
    result("t") should equal (0)
  }
  
  it should "have 1 on T when it receives 0 on D, 0 on C and has state: 1" in {
    d.state = 1;
   val valuesOnPorts = new Signals {
      put("d", 0)
      put("c", 0)
      put("t", 0)
    }

    val result = d.process(valuesOnPorts).asScala

    result("d") should equal (0)
    result("c") should equal (0)
    result("t") should equal (1)
  }
  
  it should "have 0 on T when it receives 0 on D and 1 on C" in {
   val valuesOnPorts = new Signals {
      put("d", 0)
      put("c", 1)
      put("t", 0)
    }

    val result = d.process(valuesOnPorts).asScala

    result("d") should equal (0)
    result("c") should equal (0)
    result("t") should equal (0)
  }
  
  it should "have 1 on T when it receives 1 on D and 1 on C" in {
   val valuesOnPorts = new Signals {
      put("d", 1)
      put("c", 1)
      put("t", 0)
    }

    val result = d.process(valuesOnPorts).asScala

    result("d") should equal (0)
    result("c") should equal (0)
    result("t") should equal (1)
  }
}

