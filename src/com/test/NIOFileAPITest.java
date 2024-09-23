package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.employeePayroll_IO.FileUtils;

class NIOFileAPITest {
	private static String HOME = System.getProperty("user.home");
	//private static String HOME = "C:/Users/ashwi"; 
	//private static String HOME = System.getProperty("C.Users.ashwi.eclipse-workspace.EmployeePayrollService_FileHandling");
	private static String PLAY_WITH_NIO = "TempPlayGround";

	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException  {
		
		//Check file Exists
		Path homePath = Paths.get(HOME);
		
		assertFalse(Files.notExists(homePath));
		
		
		//Delete file and Check File not exist
		Path playPath = Paths.get(HOME + "/"+PLAY_WITH_NIO);
		if(Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
		
		// Create Directory
		Files.createDirectory(playPath);
		assertTrue(Files.exists(playPath));
		
		//Create File
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
		    assertTrue(Files.notExists(tempFile));
		try {Files.createFile(tempFile);}
		catch (IOException e) { }
		assertTrue(Files.exists(tempFile));
		});
		
		// List Files, Directories as well as Files with extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() &&
				                                   path.toString().startsWith("temp"))
		     .forEach(System.out::println);	
		
	}
      
}
