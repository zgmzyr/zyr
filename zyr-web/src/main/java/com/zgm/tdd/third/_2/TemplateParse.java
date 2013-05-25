package com.zgm.tdd.third._2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateParse {

	/*public List<String> parse(String template) {
		
		return Collections.singletonList(template);
	}*/
	
	public List<String> parse(String template) {
		List<String> segments = new ArrayList<String>();
		
//		String regx = "([^\\{]*[^\\}]s)(\\$\\{.*\\})*";
		String regx = "";
		Matcher matcher = Pattern.compile( regx ).matcher( template );
		
		while ( matcher.find() ) {
			String plainText = matcher.group( 1 );
			if ( !"".equals( plainText ) ) {
				segments.add( plainText );
			}
			
			segments.add( matcher.group( 2 ) );
			
		}
		
		
		return segments;
	}

}
