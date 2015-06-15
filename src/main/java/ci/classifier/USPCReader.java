package ci.classifier;


import ci.classifier.entity.ClassScheme;
import ci.classifier.uspc.PatentClass;
import java.io.File;
import java.io.IOException;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class USPCReader {
    
    final String filename;
    
    public static final Logger LOG = LoggerFactory.getLogger(USPCReader.class);
    
    public USPCReader(String filename) throws IOException {
        this.filename = filename;        
    }
    
    public PatentClass getPatentClass() throws Exception {
        Serializer serializer = new Persister();
        File file = new File(filename);
        PatentClass clazz = serializer.read(PatentClass.class, file);
        return clazz;
    }
    
}
