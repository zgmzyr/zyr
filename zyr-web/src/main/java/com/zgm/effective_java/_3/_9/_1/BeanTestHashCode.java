package com.zgm.effective_java._3._9._1;

import java.util.Arrays;

public class BeanTestHashCode {

	private short shortField;
	private int intField;
	private long longField;
	private float floatField;
	private double doubleField;
	private String stringField;
	private int[] intArrayField;
	
	public BeanTestHashCode(int intField, float floatField, double doubleField, String stringField) {
		this.intField = intField;
		this.floatField = floatField;
		this.doubleField = doubleField;
		this.stringField = stringField;
		
				
	}

	public BeanTestHashCode(short shortField, int intField, long longField,
			float floatField, double doubleField, String stringField,
			int[] intArrayField) {
		super();
		this.shortField = shortField;
		this.intField = intField;
		this.longField = longField;
		this.floatField = floatField;
		this.doubleField = doubleField;
		this.stringField = stringField;
		this.intArrayField = intArrayField;
	}

	/**
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof BeanTestHashCode)) {
			return false;
		}
		
		BeanTestHashCode beanTestHashCode = (BeanTestHashCode) obj;
		
		return compareFields(beanTestHashCode);
	}
	
	
	@Override
	public int hashCode() {
		int result = 17;
		
		int intFieldHashCode;
		
		return 0;
	}
	*/

	private boolean compareFields(BeanTestHashCode beanTestHashCode) {
		return compareIntField(beanTestHashCode) &&
				compareFloatField(beanTestHashCode) &&
				compareDoubleField(beanTestHashCode) &&
				compareStrigField(beanTestHashCode);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(doubleField);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(floatField);
		result = prime * result + Arrays.hashCode(intArrayField);
		result = prime * result + intField;
		result = prime * result + (int) (longField ^ (longField >>> 32));
		result = prime * result + shortField;
		result = prime * result
				+ ((stringField == null) ? 0 : stringField.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeanTestHashCode other = (BeanTestHashCode) obj;
		if (Double.doubleToLongBits(doubleField) != Double
				.doubleToLongBits(other.doubleField))
			return false;
		if (Float.floatToIntBits(floatField) != Float
				.floatToIntBits(other.floatField))
			return false;
		if (!Arrays.equals(intArrayField, other.intArrayField))
			return false;
		if (intField != other.intField)
			return false;
		if (longField != other.longField)
			return false;
		if (shortField != other.shortField)
			return false;
		if (stringField == null) {
			if (other.stringField != null)
				return false;
		} else if (!stringField.equals(other.stringField))
			return false;
		return true;
	}

	private boolean compareStrigField(BeanTestHashCode beanTestHashCode) {
		return beanTestHashCode.stringField == this.stringField ||
			(beanTestHashCode.stringField != null && beanTestHashCode.stringField.equals(this.stringField));
	}

	private boolean compareDoubleField(BeanTestHashCode beanTestHashCode) {
		return Double.compare(beanTestHashCode.doubleField, this.doubleField) == 0 ? true : false;
	}

	private boolean compareFloatField(BeanTestHashCode beanTestHashCode) {
//		System.out.println(beanTestHashCode.floatField - this.floatField);
//		return beanTestHashCode.floatField == this.floatField;
		
		return Float.compare(beanTestHashCode.floatField, this.floatField) == 0 ? true : false;
	}

	private boolean compareIntField(BeanTestHashCode beanTestHashCode) {
		return beanTestHashCode.intField == this.intField;
	}
	
}
