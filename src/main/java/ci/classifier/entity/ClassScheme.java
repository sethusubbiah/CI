
package ci.classifier.entity;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="class-scheme")
public class ClassScheme {

    @Attribute(name="publication-date")
    private String date;
    
    @Attribute(name="scheme-type")
    private String schemeType;
    
    @Attribute(name="publication-type")
    private String publicationType;
        
    @ElementList(inline=true)
    private List<ClassificationItem> items;
    
    private List<ClassificationItem> getItems() {
        return items;
    }
    
}
