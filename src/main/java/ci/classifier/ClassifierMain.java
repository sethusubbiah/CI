package ci.classifier;

import ci.classifier.uspc.PatentClass;
import ci.classifier.uspc.SubClass;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ClassifierMain {
    
    public static final Logger LOG = LoggerFactory.getLogger(ClassifierMain.class);
            
    public static void main(String args[]) throws Exception {

        /*
        if(args.length != 1) {
            LOG.error("USAGE: <filename>\n");
            System.exit(1);
        }
        
        String filename = args[0];
        */
        Map<String,SubClass> database = new HashMap<String, SubClass>();
        String directory = "/Users/gokuls/Downloads/classdefs201410/";
        File dir = new File(directory);
        String[] files = dir.list(new FilenameFilter() {

            public boolean accept(File dir, String name) {
                if(name.endsWith(".xml")) {
                    return true;
                }
                return false;
            }
            
        });
        
        for(String file : files) {
            try {
                System.out.println("Opening file " + file);
                USPCReader reader = new USPCReader(directory + file);
                PatentClass clazz = reader.getPatentClass();
                
                // Go through the subclasses
                for(SubClass sc : clazz.getSubClasses()) {
                    database.put(sc.getId(), sc);
                    //System.out.println("ID: " + sc.getId() + " has title: " + sc.getTitle() + " and desc: " + sc.getDescription());
                }
                
            } catch(Exception e) {
                //System.exit(-1);
            }
        }
        
        // Look up some sample entries
        SubClass sc = database.get("C709S224000");
        System.out.println("ID: " + sc.getId() + " has title: " + sc.getTitle() + " and desc: " + sc.getDescription());
    }
    
}
