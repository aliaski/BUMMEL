package net.unikernel.bummel.latches;
import java.util
import net.unikernel.bummel.latches.RS.RS;
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, FlatSpec}
import scala.collection.JavaConverters._

class RSSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {

 type Signals = util.TreeMap[String, java.lang.Double]

 var rs: RS = _

  before {
    rs = new RS()
  }

  after {
    rs = null;
  }
  
 "RS element" should "have 0(0) on Q(not Q) when it receives 0 on Set, 0 on Reset and has state: 1"  in{
    rs.state = 1;
    val valuesOnPorts = new Signals {
      put("reset", 0)
      put("set", 0)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (0)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 0 on Set, 0 on Reset and has state: 2"  in{
    rs.state = 2;
    val valuesOnPorts = new Signals {
      put("reset", 0)
      put("set", 0)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
  }
  
  it should "have 0(1) on Q(not Q) when it receives 0 on Set, 0 on Reset and has state: 3"  in{
    rs.state = 3;
    val valuesOnPorts = new Signals {
      put("reset", 0)
      put("set", 0)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
  
  it should "have 0(1) on Q(not Q) when it receives 0 on Set, 1 on Reset and has state: 1"  in{
    rs.state = 1;
    val valuesOnPorts = new Signals {
      put("reset", 1)
      put("set", 0)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
  
  it should "have 0(1) on Q(not Q) when it receives 0 on Set, 1 on Reset and has state: 2"  in{
    rs.state = 2;
    val valuesOnPorts = new Signals {
      put("reset", 1)
      put("set", 0)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
  
  it should "have 0(1) on Q(not Q) when it receives 0 on Set, 1 on Reset and has state: 3"  in{
    rs.state = 3;
    val valuesOnPorts = new Signals {
      put("reset", 1)
      put("set", 0)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 1 on Set, 0 on Reset and has state: 1"  in{
    rs.state = 1;
    val valuesOnPorts = new Signals {
      put("reset", 0)
      put("set", 1)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 1 on Set, 0 on Reset and has state: 2"  in{
    rs.state = 2;
    val valuesOnPorts = new Signals {
      put("reset", 0)
      put("set", 1)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 1 on Set, 0 on Reset and has state: 3"  in{
    rs.state = 3;
    val valuesOnPorts = new Signals {
      put("reset", 0)
      put("set", 1)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
  }
  
  it should "have 0(0) on Q(not Q) when it receives 1 on Set, 1 on Reset and has state: 1"  in{
    rs.state = 1;
    val valuesOnPorts = new Signals {
      put("reset", 1)
      put("set", 1)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (0)
  }
  
  it should "have 0(0) on Q(not Q) when it receives 1 on Set, 1 on Reset and has state: 2"  in{
    rs.state = 2;
    val valuesOnPorts = new Signals {
      put("reset", 1)
      put("set", 1)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (0)
  }
  
  it should "have 0(0) on Q(not Q) when it receives 1 on Set, 1 on Reset and has state: 3"  in{
    rs.state = 3;
    val valuesOnPorts = new Signals {
      put("reset", 1)
      put("set", 1)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = rs.process(valuesOnPorts).asScala

    result("reset") should equal (0)
    result("set") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (0)
  }
  
}