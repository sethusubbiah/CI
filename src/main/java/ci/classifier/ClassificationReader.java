/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ci.classifier;


import ci.classifier.entity.ClassScheme;
import java.io.File;
import java.io.IOException;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gokuls
 */
public class ClassificationReader {
    
    public static final Logger LOG = LoggerFactory.getLogger(ClassificationReader.class);
    
    public ClassificationReader(String filename) throws IOException {
    
        try {
            Serializer serializer = new Persister();
            File file = new File(filename);
            ClassScheme scheme = serializer.read(ClassScheme.class, file);
            
        } catch(Exception exception) {
            LOG.error("Could not open XML file " + filename);
            exception.printStackTrace();
        }
        
    }
    
}
