/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.classifier.uspc;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name="subnum")
public class SubNum {
    
    @Attribute(name="range", required=false)
    private String range;
    
    @Attribute(name="ref", required=false)
    private String ref;
    
    @Attribute(name="doc", required=false)
    private String doc;
    
    private String num;
  
}
