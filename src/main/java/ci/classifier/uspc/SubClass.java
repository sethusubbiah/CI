/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.classifier.uspc;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="subclass", strict=false)
public class SubClass {
    
    @Attribute(name="subnum", required=false)
    private String subnum;
    
    @Attribute(name="id", required=false)
    private String id;
        
    @Element(name="sctitle", required=false)
    private String title;
    
    @Element(name="scdesc", required=false)
    private String desc;
        
    @Element(name="parent", required=false)
    private Parent parent;
  
    
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public Parent getParent() {
        return parent;
    }

    public String getDescription() {
        return desc;
    }
    
}
