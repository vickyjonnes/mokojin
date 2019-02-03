package com.test.src;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

public class ExcelExporter {

	public static void main(String[] args){
		List<Person> persons=new ArrayList<>();
		persons.add(new Person("Faizan",25));
		persons.add(new Person("Noman",27));
		persons.add(new Person("Firoz",29));
		persons.add(new Person("Shahroz",32));
		persons.add(new Person("Sarfaraz",75));
		
		File f=new File("D:/Important/projects/template.xls");
		System.out.println(f.exists());
		try(InputStream is = ExcelExporter.class.getResourceAsStream("template.xls")) {
	        try (OutputStream os = new FileOutputStream("D:/Important/projects/data.xls")) {
	            Context context = new Context();
	            context.putVar("person", persons);
	            JxlsHelper.getInstance().processTemplateAtCell(is, os, context,"Result!A1");
	        }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }

	}

}
