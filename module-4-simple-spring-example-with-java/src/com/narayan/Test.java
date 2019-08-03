package com.narayan;


import com.sun.xml.internal.ws.model.AbstractWrapperBeanGenerator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test{
	public static void main() {
		Resource resource=new ClassPathResource( "studentBean" );
		BeanFactory factory=new XmlBeanFactory( resource );
		
		Student student=(Student) factory.getBean( "studentBean" );
		
		student.toString();
	}
}


