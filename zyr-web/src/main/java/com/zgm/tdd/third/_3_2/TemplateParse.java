package com.zgm.tdd.third._3_2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateParse {

	/*public List<String> parse(String template) {
		
		return Collections.singletonList(template);
	}*/
	
	/*public List<String> parse(String template) {
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
*/
	public List<String> parse(String template) {
		List<String> segments = new ArrayList<String>();
		int index = collectSegments(segments, template);
		addTail(segments, template, index);
		addEmptyStringIfTemplateWasEmpty(segments);
		
		return segments;
	}

	private void addEmptyStringIfTemplateWasEmpty(List<String> segments) {
		if (segments.size() == 0) {
			segments.add("");
		}
	}

	private void addTail(List<String> segments, String template, int index) {
		if (index < template.length()) {
			String tail = template.substring(index);
			segments.add(tail);
		}
		
	}

	private int collectSegments(List<String> segments, String template) {
		Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
		Matcher matcher = pattern.matcher(template);
		int index = 0;
		
		while (matcher.find()) {
			addPrecedingPlainText(segments, template, matcher, index);
			addVariable(segments,template, matcher);
			index = matcher.end();
		}
		
		return index;
	}

	private void addVariable(List<String> segments, String template,
			Matcher matcher) {

		String variable = template.substring(matcher.start(), matcher.end());
		segments.add(variable);
	}

	private void addPrecedingPlainText(List<String> segments, String template,
			Matcher matcher, int index) {
		if (matcher.start() != index) {
			String plainText = template.substring(index, matcher.start());
			segments.add(plainText);
		}
		
	}

	public List<Segment> parseSegments(String template) {
		List<Segment> segments = new ArrayList<Segment>();
		List<String> strings = this.parse(template);
		
		for(String s : strings) {
			if (Template.isVariable(s)) {
				String name = s.substring(2, s.length() - 1);
				segments.add(new VariableSegment(name));
			} else {
				segments.add(new PlainText(s));
			}
		}
		
		return segments;
	}
}
