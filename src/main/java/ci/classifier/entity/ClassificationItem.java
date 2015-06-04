package ci.classifier.entity;

import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="classification-item")
public class ClassificationItem {
    
    @Attribute(name="breakdown-code", required=false)
    private String breakdownCode;
    
    @Attribute(name="not-allocatable", required=false)
    private Boolean notAllocatable;
    
    @Attribute(name="level", required=false)
    private Integer level;
    
    @Attribute(name="additional-only", required=false)
    private Boolean additionalOnly;
    
    @Attribute(name="sort-key", required=false)
    private String sortKey;
    
    @Attribute(name="definition-exists", required=false)
    private String definitionExists;
    
    @Attribute(name="ipc-concordant", required=false)
    private String ipcConcordant;
    
    @Attribute(name="date-revised", required=false)
    private String dateRevised;
    
    @Attribute(name="status", required=false)
    private String status;
        
    @Element(name="classification-symbol", required=false)
    private String symbol;
    
    @Element(name="class-title", required=false)
    private ClassTitle title;
    
    @ElementList(name="classification-item", inline=true, required=false)
    private List<ClassificationItem> children;
    
    @Attribute(name="link-file", required=false)
    private String linkFile;
    
    @Element(name="notes-and-warnings", required=false)
    private String notesAndWarnings;
    
    @Element(name="note", required=false)
    private String note;
    
    @ElementList(name="note-paragraph", inline=true, required=false)
    private List<String> noteParagraph;
    
    @Element(name="CPC-specific-text", required=false)
    private String cpcSpecificText;
    
    @ElementList(name="class-ref", inline=true, required=false)
    private List<ClassRef> classRef;
    
    @Element(name="subnote", required=false)
    private String subNote;
    
    public String getSymbol() {
        return symbol;
    }
    
    public ClassTitle getTitle() {
        return title;
    }
    
}
