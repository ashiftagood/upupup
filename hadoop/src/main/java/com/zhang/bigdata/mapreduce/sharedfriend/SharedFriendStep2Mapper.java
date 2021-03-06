package com.zhang.bigdata.mapreduce.sharedfriend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SharedFriendStep2Mapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text outKey = new Text();
    private Text outValue = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //super.map(key, value, context);
        String line = value.toString();
        String[] split = line.split("\t");
        outKey.set(split[0]);
        outValue.set(split[1]);
        context.write(outKey, outValue);
    }
}
