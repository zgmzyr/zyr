package com.zgm.spark;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

/**
 * spark Demo程序
 * @author hailong.luo
 * 主要应用 spark rdd操作相关的文本信息做统计出来;
 * spark 对应的 rdd操作  map,mapValues,flatMap,reduce,reduceByKey等方法
 * 
 */
public class SparkDemo {
	private static final Pattern SPACE = Pattern.compile(" ");

	public static void main(String[] args) throws Exception {
		
		/********spark相关的参数配置***********/
		SparkConf conf = new SparkConf();
		conf.setAppName("sparkDemo");
		conf.setMaster("local[3]");
		JavaSparkContext ctx = new JavaSparkContext(conf);
		/*********RDD可以从普通数组创建出来，也可以从文件系统或者HDFS中的文件创建出来*********/
		String logFile = "D:/1.txt";
		JavaRDD<String> lines = ctx.textFile(logFile, 3);
		
		/**********把文件内容拆分**********/
		JavaRDD<String> words = lines
				.flatMap(new FlatMapFunction<String, String>() {
					private static final long serialVersionUID = 798116789172225252L;
					@Override
					public Iterable<String> call(String s) {
						return Arrays.asList(SPACE.split(s));
					}
				});

		/***********生成数组对*************/
		JavaPairRDD<String, Integer> ones = words
				.mapToPair(new PairFunction<String, String, Integer>() {
					private static final long serialVersionUID = -1169278897736750251L;
					@Override
					public Tuple2<String, Integer> call(String s) {
						System.out.println(s);
						return new Tuple2<String, Integer>(s, 1);
					}
				});
		/***********对相同KEY值的数据进行计算*************/
		JavaPairRDD<String, Integer> counts = ones
				.reduceByKey(new Function2<Integer, Integer, Integer>() {
					private static final long serialVersionUID = 3567078042140683283L;

					@Override
					public Integer call(Integer i1, Integer i2) {
						return i1 + i2;
					}
				});
		
		/*******对分布式在各个node的数据归并*******/
		Map<String,Integer> map = counts.collectAsMap();
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			Object key = it.next();
			System.out.println(key + "--" + map.get(key));
		}
		
		/*****对计算的结果保持*******/
		counts.saveAsTextFile("d:/test1/");
		ctx.close();
	}

}
