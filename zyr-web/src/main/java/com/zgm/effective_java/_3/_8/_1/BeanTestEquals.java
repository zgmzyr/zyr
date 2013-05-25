package com.zgm.effective_java._3._8._1;

public class BeanTestEquals {

	private String stringField;
	private int intField;
	private float floatField;
	private double doubleField;
	
	public BeanTestEquals(int intField, float floatField, double doubleField, String stringField) {
		this.intField = intField;
		this.floatField = floatField;
		this.doubleField = doubleField;
		this.stringField = stringField;
				
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof BeanTestEquals)) {
			return false;
		}
		
		BeanTestEquals beanTestEquals = (BeanTestEquals) obj;
		return compareFields(beanTestEquals);
	}

	private boolean compareFields(BeanTestEquals beanTestEquals) {
		return compareIntField(beanTestEquals) &&
				compareFloatField(beanTestEquals) &&
				compareDoubleField(beanTestEquals) &&
				compareStrigField(beanTestEquals);
	}

	private boolean compareStrigField(BeanTestEquals beanTestEquals) {
		return beanTestEquals.stringField == this.stringField ||
			(beanTestEquals.stringField != null && beanTestEquals.stringField.equals(this.stringField));
	}

	private boolean compareDoubleField(BeanTestEquals beanTestEquals) {
		return Double.compare(beanTestEquals.doubleField, this.doubleField) == 0 ? true : false;
	}

	private boolean compareFloatField(BeanTestEquals beanTestEquals) {
//		System.out.println(beanTestEquals.floatField - this.floatField);
//		return beanTestEquals.floatField == this.floatField;
		
		return Float.compare(beanTestEquals.floatField, this.floatField) == 0 ? true : false;
	}

	private boolean compareIntField(BeanTestEquals beanTestEquals) {
		return beanTestEquals.intField == this.intField;
	}
	
}
