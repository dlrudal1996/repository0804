package sp4.sp4_test01;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.sun.jndi.toolkit.url.GenericURLDirContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//gr을 불러오기위해 파일부터 불러온다.
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
    	//객체를 불러오려면 선언을 해야한다.
    	Greeter gr1 = ctx.getBean("gr",Greeter.class);
//    	18줄과 같은 의미
//    	Greeter gr = new Greeter();
//    	gr.setFormat("%s,하이!");
//    	Greeter gr1 = gr;
    	
    	String msg = gr1.greet("이경미");
    	System.out.println(msg);
    }
}
