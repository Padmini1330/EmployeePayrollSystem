package EmployeePayrollSystem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest 
{
	private static String HOME=System.getProperty("user.home");
	private static String PLAY_WITH_NIO="TempPlayGround";
	
	@Test
	public void givenPath_WhenChecked_ThenConfirm() throws IOException 

	{
		//check whether file exists
		Path homePath=Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));
		
		//delete file and check file not exists
		Path playPath=Paths.get(HOME + "/"+ PLAY_WITH_NIO);
		if(Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));
		
		//create directory
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));
		
		//create file
		IntStream.range(1, 10).forEach(cntr->
		{
			Path tempFile=Paths.get(playPath+"/temp"+cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try 
			{
				Files.createFile(tempFile);
			}
			catch(IOException e) {}
			Assert.assertTrue(Files.exists(tempFile));
		});
		
		//list files, directories as well as files with extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath,path->path.toFile().isFile() && path.toString().startsWith("temp")).forEach((System.out::println));
	}
	

	@Test
	public void givenDirectory_WhenWatched_ReturnsAllActivities() throws IOException
	{
		Path dir = Paths.get(HOME+"/"+PLAY_WITH_NIO);
		Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
		new Java8WatchService(dir).processEvents();
	}

}