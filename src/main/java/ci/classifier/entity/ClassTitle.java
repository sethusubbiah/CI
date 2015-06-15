package ci.classifier.entity;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="class-title")
public class ClassTitle {
    
    @Attribute(name="date-revised", required=false)
    private String dateRevised;
    
    @ElementList(name="title-part", inline=true, required=false, empty=true)
    private List<TitlePart> titleParts;
    
}
