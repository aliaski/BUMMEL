package net.unikernel.bummel.latches;
import java.util
import net.unikernel.bummel.latches.JK.JK;
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, FlatSpec}
import scala.collection.JavaConverters._

class JKSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {

 type Signals = util.TreeMap[String, java.lang.Double]

 var jk: JK = _

  before {
    jk = new JK()
  }

  after {
    jk = null;
  }
  
 "JK element" should "have 0(1) on Q(not Q) when it receives 0 on J, 0 on K and has state: 0"  in{
    jk.state = 0;
    val valuesOnPorts = new Signals {
      put("j", 0)
      put("k", 0)
      put("q", 0)
      put("notq", 0)    
    }
    
    val result = jk.process(valuesOnPorts).asScala

    result("j") should equal (0)
    result("k") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 0 on J, 0 on K and has state: 1" in {
    jk.state = 1;
    val valuesOnPorts = new Signals {
      put("j", 0)
      put("k", 0)
      put("q", 0)
      put("notq", 0)     
    }
    
    val result = jk.process(valuesOnPorts).asScala

    result("j") should equal (0)
    result("k") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 1 on J, 0 on K and has state: 0" in {
    jk.state = 0;
    val valuesOnPorts = new Signals {
      put("j", 1)
      put("k", 0)
      put("q", 0)
      put("notq", 0)     
    }
    
    val result = jk.process(valuesOnPorts).asScala

    result("j") should equal (0)
    result("k") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 1 on J, 0 on K and has state: 1" in {
    jk.state = 1;
    val valuesOnPorts = new Signals {
      put("j", 1)
      put("k", 0)
      put("q", 0)
      put("notq", 0)     
    }
    
    val result = jk.process(valuesOnPorts).asScala

    result("j") should equal (0)
    result("k") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
  }
  
  it should "have 0(1) on Q(not Q) when it receives 0 on J, 1 on K and has state: 0" in {
    jk.state = 0;
    val valuesOnPorts = new Signals {
      put("j", 0)
      put("k", 1)
      put("q", 0)
      put("notq", 0)     
    }
    
    val result = jk.process(valuesOnPorts).asScala

    result("j") should equal (0)
    result("k") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
  
  it should "have 0(1) on Q(not Q) when it receives 0 on J, 1 on K and has state: 1" in {
    jk.state = 1;
    val valuesOnPorts = new Signals {
      put("j", 0)
      put("k", 1)
      put("q", 0)
      put("notq", 0)     
    }
    
    val result = jk.process(valuesOnPorts).asScala

    result("j") should equal (0)
    result("k") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
  
  it should "have 1(0) on Q(not Q) when it receives 1 on J, 1 on K and has state: 0" in {
    jk.state = 0;
    val valuesOnPorts = new Signals {
      put("j", 1)
      put("k", 1)
      put("q", 0)
      put("notq", 0)     
    }
    
    val result = jk.process(valuesOnPorts).asScala

    result("j") should equal (0)
    result("k") should equal (0)
    result("q") should equal (1)
    result("notq") should equal (0)
}

  it should "have 0(1) on Q(not Q) when it receives 1 on J, 1 on K and has state: 1" in {
    jk.state = 1;
    val valuesOnPorts = new Signals {
      put("j", 1)
      put("k", 1)
      put("q", 1)
      put("notq", 0)     
    }
    
    val result = jk.process(valuesOnPorts).asScala

    result("j") should equal (0)
    result("k") should equal (0)
    result("q") should equal (0)
    result("notq") should equal (1)
  }
}