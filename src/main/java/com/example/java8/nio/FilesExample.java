package com.example.java8.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FilesExample {
	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("D:\\temp.txt"));
		lines.stream().filter(line -> line.contains("Java")).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("=============================================");
		lines.stream().filter(line -> !line.equals("")).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("=============================================");
		lines.stream().filter(line -> !line.equals("")).collect(Collectors.toMap(x -> x.length(), y -> y))
				.forEach((key, value) -> System.out.println(key + "=" + value));
		System.out.println("=============================================");
		Files.copy(Paths.get("D:\\temp.txt"), Paths.get("D:\\temp_cp.txt"), StandardCopyOption.REPLACE_EXISTING);
		OutputStream outputStream = Files.newOutputStream(Paths.get("D:\\temp_cp2.txt"), StandardOpenOption.CREATE);
		Files.copy(Paths.get("D:\\temp.txt"), outputStream);
		System.out.println("=============================================");
		BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("D:\\temp.txt"));
		bufferedReader.lines().forEach(System.out::println);
		System.out.println("=============================================");
		bufferedReader = Files.newBufferedReader(Paths.get("D:\\temp.txt"));
		bufferedReader.skip(100);
		bufferedReader.lines().forEach(System.out::println);
		for (Path path : Files.newDirectoryStream(Paths.get("D:\\Work"))) {
			path = path.normalize();
			System.out.println(path.getFileName());
		}

		System.out.println("=============================================");
		List<File> files = Files.list(Paths.get("D:\\Work")).map(Path::toFile).collect(Collectors.toList());

		files.forEach(System.out::println);
		
		Files.readAllLines(Paths.get("D:\\temp_ch.txt"), StandardCharsets.UTF_16).forEach(System.out::println);;
	}
}
