package com.CI.app;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


/**
 *
 * @author root
 */
public class MyParserMapper   extends
    Mapper<LongWritable, Text, Text, IntWritable> {

	private final static IntWritable one = new IntWritable(1);
	private final static IntWritable zero = new IntWritable(0);

	@SuppressWarnings("unchecked")
	@Override
    protected void map(LongWritable key, Text value1, Context context )
throws IOException, InterruptedException {

            String xmlString = value1.toString();
            Configuration conf =  context.getConfiguration();
            String Company = conf.get("company");
             
             SAXBuilder builder = new SAXBuilder();
            Reader in = new StringReader(xmlString);
        try {
            
            Document doc = builder.build(in);
            Element root = doc.getRootElement();
            
            String tag1 =root.getChild("us-bibliographic-data-grant").getChild("invention-title").getTextTrim() ;
             
            String tag2 =root.getChild("us-bibliographic-data-grant").getChild("classification-national").getChild("main-classification").getTextTrim();
            
            //String company = root.getChild("us-bibliographic-data-grant").getChild("us-parties").getChild("us-applicants").getChild("us-applicant").getChild("addressbook").getChild("orgname").getTextTrim();
            String company = null;
            Element a = root.getChild("us-bibliographic-data-grant");
            if (a != null)
            {
            	a = a.getChild("us-parties");
            	if (a != null)
            	{
            		a= a.getChild("us-applicants");
            		if (a!=null)
            			{
            				a= a.getChild("us-applicant");
            					if(a!=null)
            					{
            						a = a.getChild("addressbook");
            						if(a!=null)
            						{
            							a =a.getChild("orgname");
            							if (a !=null)
            								company = a.getTextTrim();
            						}
            					}
            			}
            	}
            }
            
            tag2 = org.apache.commons.lang.StringUtils.deleteWhitespace(tag2);
            if(company == null)
            	context.write(new Text(tag2),zero);
            
            if (company != null && company.indexOf(Company) > -1)
            {
            	context.write(new Text(tag2), one);
            }
            else
            	context.write(new Text(tag2), zero);

        } catch (JDOMException ex) {
            Logger.getLogger(MyParserMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyParserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

}