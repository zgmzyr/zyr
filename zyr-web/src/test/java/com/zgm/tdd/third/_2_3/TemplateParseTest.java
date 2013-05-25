package com.zgm.tdd.third._2_3;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TemplateParseTest {

	@Test
	public void emptyTemplateRendersAsEmptyString() {
		List<String> segments = parse("");
		
//		assertEquals("", 1, segments.size());
//		assertEquals("", segments.get(0));
		
		assertSegments( segments, "" );
	}

	private List<String> parse(String template) {
		return new TemplateParse().parse(template);
		
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
