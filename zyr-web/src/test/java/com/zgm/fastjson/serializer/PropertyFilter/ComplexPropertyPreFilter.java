package com.zgm.fastjson.serializer.PropertyFilter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.serializer.PropertyFilter;

public class ComplexPropertyPreFilter implements PropertyFilter {
	//需要序列化的
	private Map<Class<?>, Set<String>> includeMap = new HashMap<Class<?>, Set<String>>();

	@Override
	public boolean apply(Object source, String name, Object value) {
		for (Entry<Class<?>, Set<String>> entry : includeMap.entrySet()) {
			Class<?> class1 = entry.getKey();
			if (source.getClass() == class1) {
				Set<String> fields = entry.getValue();
				for (String field : fields) {
					if (field.equals(name)) {
						 return false;
//						return true;
					}
				}
			}
		}
		 return true;
//		return false;
	}

	public ComplexPropertyPreFilter(Map<Class<?>, Set<String>> includeMap) {
		this.includeMap = includeMap;
	}
}
