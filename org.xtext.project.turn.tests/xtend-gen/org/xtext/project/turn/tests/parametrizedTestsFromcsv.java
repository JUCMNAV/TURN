package org.xtext.project.turn.tests;

import com.google.inject.Inject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.xtext.project.turn.tests.TurnInjectorProvider;
//import org.xtext.project.turn.tests.XtextParametersRunnerFactory1;
import org.xtext.project.turn.turn.URNspec;

@RunWith(Parameterized.class)
@InjectWith(TurnInjectorProvider.class)


//use created Runner factory instead of default 
@Parameterized.UseParametersRunnerFactory(XtextParametersRunnerFactory.class)
@SuppressWarnings("all")
public class parametrizedTestsFromcsv {
	
	
	  @Inject
	  public  ParseHelper<URNspec> parseHelper;
	  @Inject 
	  public ValidationTestHelper valhelp;
	
	
//initialize parameter
	  public List<String> i = new ArrayList<String>();
	
	
	  
	@Parameters
  public static List<String>[] data() throws IOException {
	  ArrayList<String> entry= new ArrayList<String>();
	  List<ArrayList<String>> entries= new ArrayList<ArrayList<String>>();
	  //first,check for validation checks
	  try (BufferedReader br = Files.newBufferedReader(Paths.get("expectedresults.csv"),
              StandardCharsets.US_ASCII)) {
		  
		  String line = br.readLine();
		  line=br.readLine();
		  while (line != null) { // use string.split to load a string array with the values from // each line of // the file, using a comma as the delimiter
			 
			 ArrayList<String> list = new ArrayList<String>( Arrays.asList(line.split(","))); 
			 entry=list;
			//add each record in the csv as an entry(filename,errorMessage)
			 entries.add( entry);
			  line = br.readLine(); }
		  }

	  
	  //if a file in the directory was a turn file but not in the csv, add its entry with an empty message
	  File dir = new File("..\\TURNTestInput\\src");
	  File[] files = dir.listFiles((d, name) -> name.endsWith(".turn"));
	 // ArrayList<String> list= new ArrayList<String>();
	  for (File i : files) {
		  ArrayList<String> list= new ArrayList<String>();
		  int found=0;
		  for(List l : entries) {
			 
			  if (l.get(0).equals(i.getName())) {
				  found=1;
				
				 
			  }
		  }
		  if (found==0) {
		  list.add(i.getName());
		
		  list.add("");
		 
		  
		  entries.add(list);}
		  
	  }
	  
	  
	return entries.toArray((List<String>[])new List[0])		 ;
	  }
  
  

	
 public parametrizedTestsFromcsv(List<String> parameter){
	  this.i=  parameter;
	
  }
  

  

 
 
 
  @Test
  public void loadModel() throws Exception {
	  System.out.println(i.get(0));
	  
	  File f = new File("..\\TURNTestInput\\src\\"+i.get(0));
	  Assert.assertEquals("file in csv doesn't exist in directory"+i.get(0),true,f.exists());
	  URNspec result
	     = this.parseHelper.parse(readFileAsString(("..\\TURNTestInput\\src\\"+i.get(0)).toString()));
	
	  if(i.get(1)!="") {//if there is an error message
		
	  List<Issue> valresult=valhelp.validate(result);
	//if there are no errors then we have a problem since we know there is a validation error with this file
	  Assert.assertNotEquals("found no validation errors for"+i.get(0),0, valresult.size());
	  String l= valresult.get(0).getMessage();
	//asserting the error message is the same as the one in the csv
	  Assert.assertEquals(i.get(0).toString(),i.get(1), l);
	  }
   
     //checking file is not null and is parsable, for all files(since validation  files should also be parsable)
	 Assert.assertNotNull(i.get(0).toString()+" file is null",result);
	      Assert.assertTrue(i.get(0).toString()+" parsing error in file",result.eResource().getErrors().isEmpty());}
	 
	  
	   
  

public static String readFileAsString(String fileName) { 
	  String text = "";
	  try { 
		
		  text = new String(Files.readAllBytes(Paths.get(fileName)));
		
		  } 
	  catch (IOException e) { e.printStackTrace(); }
 return text; }


}
