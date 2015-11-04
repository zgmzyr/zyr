package javax.script;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ScriptEngineTest {

	public static void main(String[] args) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		String jsFileName = "./encrypt.js"; 
		InputStream resourceAsStream = ScriptEngineTest.class.getResourceAsStream(jsFileName);
		InputStreamReader reader = new InputStreamReader(resourceAsStream);
//		FileReader reader = new FileReader(resourceAsStream); 
		engine.eval(reader);

		if (engine instanceof Invocable) {
			Invocable invoke = (Invocable) engine; 


			String c = (String) invoke.invokeFunction("encryptCont", "111111");

			System.out.println("c = " + c);
		}

		reader.close();

	}
	
	public static String getPass() throws ScriptException, NoSuchMethodException, IOException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		String jsFileName = "./encrypt.js"; 
		InputStream resourceAsStream = ScriptEngineTest.class.getResourceAsStream(jsFileName);
		InputStreamReader reader = new InputStreamReader(resourceAsStream);
//		FileReader reader = new FileReader(resourceAsStream); 
		engine.eval(reader);

		if (engine instanceof Invocable) {
			Invocable invoke = (Invocable) engine; 


			String c = (String) invoke.invokeFunction("encryptCont", "xxxxx");

			System.out.println("c = " + c);
			
			return c;
		}

		reader.close();

		return "";
	}
}
