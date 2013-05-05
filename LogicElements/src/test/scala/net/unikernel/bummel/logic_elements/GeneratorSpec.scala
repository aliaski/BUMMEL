package net.unikernel.bummel.logic_elements;
import java.util
import net.unikernel.bummel.logic_elements.Generator.Generator;
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, FlatSpec}
import scala.collection.JavaConverters._

class GeneratorSpec extends FlatSpec with ShouldMatchers with BeforeAndAfter {

 type Signals = util.TreeMap[String, java.lang.Double]

 var generator: Generator = _

  before {
    generator = new Generator()
  }

  after {
    generator = null;
  }
  
  "Generator element" should "return 0 for 00 input" in {
   val valuesOnPorts = new Signals {
      put("output", 0)
    } 
    generator.setState(0);
    
    val result = generator.process(valuesOnPorts).asScala
    
    result("output") should equal (0)
  }
  
  it should "return 1 for 01 input" in { 
   val valuesOnPorts = new Signals {
      put("output", 0)
    } 
    generator.setState(1);
    
    val result = generator.process(valuesOnPorts).asScala
    
    result("output") should equal (1)
  }
  
  it should "return 1 for 10 input" in { 
   val valuesOnPorts = new Signals {
      put("output", 1)
    } 
    generator.setState(0);
    
    val result = generator.process(valuesOnPorts).asScala
    
    result("output") should equal (0)
  }
  
  it should "return 1 for 11 input" in { 
   val valuesOnPorts = new Signals {
      put("output", 1)
    } 
    generator.setState(1);
    
    val result = generator.process(valuesOnPorts).asScala
    
    result("output") should equal (1)
  }
}

