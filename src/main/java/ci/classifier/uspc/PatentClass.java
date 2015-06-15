/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.classifier.uspc;

import java.util.Collections;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="class", strict=false)
public class PatentClass {
    
    @Attribute(name="classnum", required=false)
    private String classnum;
    
    @Attribute(name="id", required=false)
    private String id;
    
    @Element(name="title", required=false)
    private String title;
    
    @ElementList(name="sclasses", required=false)
    private List<SubClass> sclass; 
    
    public List<SubClass> getSubClasses() {
        return Collections.unmodifiableList(sclass);
    }
    
}
