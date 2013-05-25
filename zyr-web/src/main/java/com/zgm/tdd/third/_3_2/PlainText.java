package com.zgm.tdd.third._3_2;

import java.util.Map;

public class PlainText implements Segment {
	private String text;
	
	public PlainText(String text) {
		this.text = text;
	}
	
	@Override
	public boolean equals(Object obj) {
		/*if (obj == null) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof PlainText) {
			PlainText plainText = (PlainText) obj;
			
			if (plainText.text.equals(this.text)) {
				return true;
			} else {
				return false;
			}
		}
		
		return false;*/
		
		if (obj == this) {
			return true;
		}
		
		if (!(obj instanceof PlainText)) {
			return false;
		}
		
		PlainText plainText = (PlainText) obj;
		
		return plainText.text == this.text || 
				(plainText.text != null && plainText.text.equals(this.text));
		
	}

	@Override
	public void appendTo(StringBuilder result, Map<String, String> variables) {
		
	}

	@Override
	public String evaluate(Map<String, String> variables) {
		
		return this.text;
	}

}
