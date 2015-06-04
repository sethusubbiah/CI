package ci.classifier.entity;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="title-part")
public class TitlePart {
    
    @ElementList(name="text", inline=true, required=false)
    private List<Text> text;
    
    @Element(name="reference", required=false)
    private String reference;
    
    @Element(name="CPC-specific-text", required=false)
    private String cpcSpecificText;
    
}
