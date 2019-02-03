package com.test.src;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileFilterTest {

	public static void main(String[] args) {
		List<String> paths=new ArrayList<>();
		File dir=new File("D:\\Important");
		File ar[]=null;
		if(dir.isDirectory()) {
			ar=dir.listFiles();
		}
		Arrays.asList(ar).sort((file1,file2)->sortMe(file1, file2)); 
		Arrays.asList(ar).forEach((file)->System.out.println(file.getName()));
		//List<String> fileName=new ArrayList<>();
//		if(dir.isDirectory()) {
//			ar=dir.listFiles((file)->file.getAbsolutePath().endsWith(".pdf"));
//		}
//		paths.add("/a/b/c.txt");
//		paths.add("/a/b");
		
		//Arrays.asList(ar).forEach((file)->System.out.println(file.getName()));
		//Arrays.asList(ar).forEach((file)->fileName.add(file.getAbsolutePath()));
		//fileName.forEach(System.out::println);
		
	}
	
	public static int sortMe(File file1, File file2) {
		if(file1.isDirectory() && file2.isDirectory()) {
			return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
		}else if(file1.isDirectory() && !file2.isDirectory()) {
			return -1;
		}else if(!file1.isDirectory() && file2.isDirectory()) {
			return 1;
		}else{
			return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
		}
	}

}
