package temp;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class setEnt {
	int myvar;
	public void set(Map<String, String> newenv) throws Exception {
	    Class[] classes = Collections.class.getDeclaredClasses();
	    Map<String, String> env = System.getenv();
	    for(Class cl : classes) {
	        if("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
	            Field field = cl.getDeclaredField("m");
	            field.setAccessible(true);
	            Object obj = field.get(env);
	            Map<String, String> map = (Map<String, String>) obj;
	            map.clear();
	            map.putAll(newenv);
	        }
	    }
	    
	}
	public static void main(String[] args) throws Throwable, Exception {
		setEnt testObj = new setEnt();
		Map<String, String> newEnv = new HashMap<String, String>();
		newEnv.put("SANDEEP_TEST", "TESTVALUE");
		testObj.set(newEnv);
		System.out.println("working: " + System.getenv().get("SANDEEP_TEST"));
		System.out.println("System.getenv(SANDEEP_TEST)--"+System.getenv("SANDEEP_TEST"));
		System.out.println("System.getenv(USERPROFILE)--"+System.getenv("USERPROFILE"));
		System.out.println(System.getProperties());
		System.out.println(System.getProperty("env.SANDEEP_TEST"));
		
		Runtime run = Runtime.getRuntime();
		try {
		run.exec("cmd start /c C:/batfile.bat");
		} catch (Exception e) {
		e.printStackTrace();
		}
		System.out.println("System.getenv(ABC)--"+System.getenv("ABC"));
		System.out.println("FINISHED");
		
	}
}