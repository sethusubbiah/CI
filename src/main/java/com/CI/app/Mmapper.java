package com.CI.app;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author root
 */
public class Mmapper extends Mapper<Object, Text, IntWritable, Text>
{
	@Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException 
    {
        String line = value.toString();
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        {
            int number = -1; 
            String word = "empty";

            if(stringTokenizer.hasMoreTokens())
            {
                String str0= stringTokenizer.nextToken();
                word = str0.trim();
            }

            if(stringTokenizer.hasMoreElements())
            {
                String str1 = stringTokenizer.nextToken();
                number = Integer.parseInt(str1.trim());
            }

            context.write(new IntWritable(number), new Text(word));
        }

    }

}
