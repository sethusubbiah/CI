
package ci.classifier.entity;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="text")
public class Text {
    
    @Attribute(name="scheme", required=false)
    private String scheme;
    
    @ElementList(name="class-ref", inline=true, required=false)
    private List<ClassRef> classRef;
    
    private String text;
    
}
