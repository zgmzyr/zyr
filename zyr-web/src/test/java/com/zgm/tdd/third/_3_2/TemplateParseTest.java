package com.zgm.tdd.third._3_2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TemplateParseTest {

	@Test
	public void emptyTemplateRendersAsEmptyString() {
		List<String> segments = parse("");
		
		assertSegments( segments, "" );
	}

	private List<String> parse(String template) {
		return new TemplateParse().parse(template);
		
	}
	
	@Test
	public void parseingTemplateIntoSegmentObjects() {
		TemplateParse tp = new TemplateParse();
		List<Segment> segments = tp.parseSegments("a ${b} c ${d}");
		
		assertSegments(segments, 
				new PlainText("a "), new VariableSegment("b"),
				new PlainText(" c "), new VariableSegment("d"));
	}
	
	@Test
	public void templateWithOnlyPlainText() {
		List<String> segments = parse( "plain text only" );
		
//		assertEquals("", 1, segments.size());
//		assertEquals("plain text only", segments.get(0));
		
		assertSegments( segments, "plain text only" );
	}

	@Test
	public void parsingMultipleVariables() throws Exception{
		List<String> segments = parse( "${a}:${b}:${c}" );
		assertSegments(segments,"${a}",":","${b}",":","${c}");
	}
	
	private void assertSegments(List<? extends Object> actual, Object... expected) {
		assertEquals( "数目不匹配", expected.length, actual.size() );
		assertEquals( "不相符", Arrays.asList( expected ), actual );
	}
	
	
}
