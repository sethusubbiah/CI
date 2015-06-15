package com.CI.app;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
*
* @author root
*/
public class ParserDriver {

/**
* @param args the command line arguments
*/
public static void main(String[] args) {

try {
	runJob(args[0], args[1], args[2], args[3]);

	} catch (IOException ex) {
		Logger.getLogger(ParserDriver.class.getName()).log(Level.SEVERE, null, ex);
	}
}


public static void runJob(String type, String input, String output, String company) throws IOException {

Configuration conf = new Configuration();

conf.set("xmlinput.start", "<us-patent-grant");
conf.set("xmlinput.end", "</us-patent-grant>");
conf.set("io.serializations","org.apache.hadoop.io.serializer.JavaSerialization,org.apache.hadoop.io.serializer.WritableSerialization");
conf.set("company", company);

Job job = new Job(conf, "testJob");


FileInputFormat.setInputPaths(job, input);
job.setJarByClass(ParserDriver.class);
if (type.equals("filter"))
{
	job.setMapperClass(MyParserMapper.class);
	job.setReducerClass(MyParserReducer.class);
	job.setInputFormatClass(XmlInputFormat.class);
	job.setOutputKeyClass(Text.class);
	job.setOutputValueClass(IntWritable.class);
}
else if(type.equals("sort"))
{
	job.setMapperClass(Mmapper.class);
	job.setReducerClass(Mreducer.class);
	job.setOutputKeyClass(IntWritable.class);
	job.setOutputValueClass(Text.class);
}
Path outPath = new Path(output);
FileOutputFormat.setOutputPath(job, outPath);


try {
	job.waitForCompletion(true);
} 
catch (InterruptedException ex) {
	Logger.getLogger(ParserDriver.class.getName()).log(Level.SEVERE, null, ex);
} 
catch (ClassNotFoundException ex) {
	Logger.getLogger(ParserDriver.class.getName()).log(Level.SEVERE, null, ex);
}

}

}
