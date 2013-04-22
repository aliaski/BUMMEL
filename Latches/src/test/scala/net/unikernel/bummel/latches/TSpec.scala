package net.unikernel.bummel.latches;
import java.util
import net.unikernel.bummel.latches.T.T;
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, FlatSpec}
import scala.collection.JavaConverters._

class TSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {

 type Signals = util.TreeMap[String, java.lang.Double]

 var t: T = _

  before {
    t = new T()
  }

  after {
    t = null;
  }
 
  "T element" should "have 0(1) on Q(not Q) when it receives 0 on T and has state: 0"  in{
    t.state = 0;
    val valuesOnPorts = new Signals {
      put("t", 0)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = t.process(valuesOnPorts).asScala

    result("t") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 0 on T and has state: 1"  in{
    t.state = 1;
    val valuesOnPorts = new Signals {
      put("t", 0)
      put("q", 1)
      put("notq", 0)    
    }
    
    val result = t.process(valuesOnPorts).asScala

    result("t") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 1 on T and has state: 0"  in{
    t.state = 0;
    val valuesOnPorts = new Signals {
      put("t", 1)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = t.process(valuesOnPorts).asScala

    result("t") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
  }
  
  it should "have 0(1) on Q(not Q) when it receives 1 on T and has state: 1"  in{
    t.state = 1;
    val valuesOnPorts = new Signals {
      put("t", 1)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = t.process(valuesOnPorts).asScala

    result("t") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
  
}
  