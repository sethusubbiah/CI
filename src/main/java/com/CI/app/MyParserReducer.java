package com.CI.app;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.IntWritable;

public class MyParserReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
	private IntWritable result = new IntWritable();

	@Override
	//reduce method accepts the Key Value pairs from mappers, do the aggregation based on keys and produce the final out put
      protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
      {
            int sum = 0;
            /*iterates through all the values available with a key and add them together and give the
            final result as the key and sum of its values*/
          IntWritable val;
          for( Iterator<IntWritable> i=values.iterator(); i.hasNext(); )
          {
        	   val = i.next();
               sum += val.get();
          }
          result.set(sum);
          context.write(key, result);
      }
}