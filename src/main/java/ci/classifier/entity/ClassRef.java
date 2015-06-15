
package ci.classifier.entity;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="class-ref")
public class ClassRef {
    
    @Attribute(name="scheme", required=false)
    private String scheme;
    
    
    private String text;
    
}
