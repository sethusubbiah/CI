package com.CI.app;
import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.io.IntWritable;

class Mreducer extends Reducer<IntWritable, Text, IntWritable, Text>
{
	private Text result = new Text();
	@Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException
    {
	     StringBuilder sb = new StringBuilder();

		 for (Text value : values) {
		        sb.append(value + " ");
		    }

		    context.write(key, new Text(sb.toString()));

    }

}
