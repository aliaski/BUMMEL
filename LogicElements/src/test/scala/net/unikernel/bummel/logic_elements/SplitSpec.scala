package net.unikernel.bummel.logic_elements;
import java.util
import net.unikernel.bummel.logic_elements.Split.Split;
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, FlatSpec}
import scala.collection.JavaConverters._

class SplitSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {

 type Signals = util.TreeMap[String, java.lang.Double]

 var split_instance: Split = _

  before {
    split_instance = new Split()
  }

  after {
    split_instance = null;
  }
  
  "Split element" should "return 00 for 000 input" in {
   val valuesOnPorts = new Signals {
      put("input", 0)
      put("output1", 0)
      put("output2", 0)
    }
    
    val result = split_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output1") should equal (0)
    result("output2") should equal (0)
  }
  
  it should "return 00 for 001 input" in {
    val valuesOnPorts = new Signals {
      put("input", 0)
      put("output1", 0)
      put("output2", 1)
    }
    
    val result = split_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output1") should equal (0)
    result("output2") should equal (0)
  }
  
  it should "return 00 for 010 input" in {
    val valuesOnPorts = new Signals {
      put("input", 0)
      put("output1", 1)
      put("output2", 0)
    }
    
    val result = split_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output1") should equal (0)
    result("output2") should equal (0)
  }
  
  it should "return 00 for 011 input" in {
     val valuesOnPorts = new Signals {
      put("input", 0)
      put("output1", 1)
      put("output2", 1)
    }
    
    val result = split_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output1") should equal (0)
    result("output2") should equal (0)
  }
  
  it should "return 11 for 100 input" in {
    val valuesOnPorts = new Signals {
      put("input", 1)
      put("output1", 0)
      put("output2", 0)
    }
    
    val result = split_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output1") should equal (1)
    result("output2") should equal (1)
  }
  
  it should "return 11 for 101 input" in {
    val valuesOnPorts = new Signals {
      put("input", 1)
      put("output1", 0)
      put("output2", 1)
    }
    
    val result = split_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output1") should equal (1)
    result("output2") should equal (1)
  }
  
  it should "return 11 for 110 input" in {
    val valuesOnPorts = new Signals {
      put("input", 1)
      put("output1", 1)
      put("output2", 0)
    }
    
    val result = split_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output1") should equal (1)
    result("output2") should equal (1)
  }
  
  it should "return 11 for 111 input" in {
    val valuesOnPorts = new Signals {
      put("input", 1)
      put("output1", 1)
      put("output2", 1)
    }
    
    val result = split_instance.process(valuesOnPorts).asScala

    result("input") should equal (0)
    result("output1") should equal (1)
    result("output2") should equal (1)
  }
}

