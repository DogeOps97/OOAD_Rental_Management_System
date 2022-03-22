/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 


import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class FileReaderIO{

	FileReaderIO(){
		// do nothing apparently
	}

	// A simple csv file reader. Returns 2d arraylist of string (row rows, format)
	// Skips enmpty line, and line that starts with #
	// Do you want something that can skip first row? I could make it an option or you can skip it yourself
	// It doesn't return anything meaningful, so a void should've worked here
	//		- but I'm thinking on adding error codes there instead of exceptions, not sure
	// Note : This is not quite a true CSV reader, as some character doesn't escape properly
	// 			- double quotes
	// 				- 	if there's double quotes, it would be replaced with empty space
	//			- commas
	//				-	replaced with space
	//			- first row
	//				- 	instead of giving option to read first row as data, or column specifier,
	//					it will read all of the column as data
	//			- ignore line char
	//				- 	this char would be used to ignore lines. 
	//					Column names can add this in front of the line for file reader to ignore
	int readDataFromFile(ArrayList<ArrayList<String>> aList, String fileName){
		aList.clear();
		try {
			Scanner sc = new Scanner(new File(fileName));
		
			sc.useDelimiter(",");
			int countrow = 0;
			// For the whole list
		
			while (sc.hasNextLine()){
				// ------------------
				// Single line/entry
				// ------------------
				String toSplit = sc.nextLine();

				// skip if it's an empty line
				if (toSplit.length() == 0){
					continue;
				}
				// ignore lines with # at the start
				if (toSplit.charAt(0) == '#'){
					// if (sc.hasNextLine()){
					// 	sc.nextLine();
					// 	continue;
					// }
					// else
					continue;
				}




				String[] row = toSplit.split(",");

				// Print (debug) -----
				// for (int i = 0; i < row.length; i++){
				// 	System.out.print("\"" + row[i] + "\"");
				// }
				// System.out.println();
				// ends here ---------

				ArrayList<String> singleEntry = new ArrayList<String>();
		
				for (int i = 0; i < row.length; i++){
					row[i] = row[i].trim();
					// if (row[i] == "\"\""){
					// 	row[i] = "";
					// }
					row[i] = row[i].replaceAll("\"*\"", "");
					escapeSpecialCharacters(row[i]);
					//System.out.print(row[i] + ",");
					singleEntry.add(row[i].trim());
				}
				//System.out.println();
		
				// Once done, add it to aList
				aList.add(singleEntry);
				countrow++;
			}
		
			System.out.println(countrow + " row found");
			sc.close();
			
		} catch (FileNotFoundException e){
			System.out.println("File " + fileName + " not found");
			e.printStackTrace();
		}
		return 0;
	}

	// A simple csv file writer. Given 2d arraylist of string, it's write it to the csv file,
	// with fields separated by comma, and new file separated by new line
	//
	// Any strings with double quotes, commas and single quotes would be stripped away and replaced with blank space
	//
	// Possibly an option for adding first line or not, but I figured it's better for whatever wanting to write to file
	// adding to that on first line, with appropriate delimiter or whatever char to ignore the whole line
	// Reference
	// https://stackabuse.com/reading-and-writing-csvs-in-java/ <--- a shitty stackoverflow knockoff maybe, but it works
	int writeDataToFile(ArrayList<ArrayList<String>> aList, String fileName){
		try{
			PrintWriter writer = new PrintWriter(new File(fileName));
			for (ArrayList<String> row : aList){
				for (String singleEntry : row){

					// A bit of data cleaning - remove doubles quotes and commas
					singleEntry = escapeSpecialCharacters(singleEntry);
					singleEntry = singleEntry.replaceAll("^\\s*$", "\"\"");
					// if (singleEntry == ""){
					// 	singleEntry = "\"\"";

					System.out.print(singleEntry + ",");
					writer.append(singleEntry + ",");
					// }
				}
				System.out.println();
				//writer.append(String.join(",", row));
				writer.append("\n");
			}
			//writer.append("Some trash here");

			writer.flush();
			writer.close();


		} catch (FileNotFoundException e){
			System.out.println("File " + fileName + " not found");
			e.printStackTrace();
		}


		return 0;
	}

	// Copied from https://www.baeldung.com/java-csv
	// Strips away special characters so it doesn't ruin the data file
	// 
	private String escapeSpecialCharacters(String data) {
    	String escapedData = data.replaceAll("\\R", " ");
    	if (data.contains(",") || data.contains("\"") || data.contains("'")) {
        	data = data.replace("\"", "");
        	data = data.replace(",", " ");
        	//data = data.replace("")
        	//escapedData = "\"" + data + "\"";

    	}
    	return escapedData;
	}	
}

// ORIGINAL CODE PERHAPS
	// private String escapeSpecialCharacters(String data) {
 //    	String escapedData = data.replaceAll("\\R", " ");
 //    	if (data.contains(",") || data.contains("\"") || data.contains("'")) {
 //        	data = data.replace("\"", "\"\"");
 //        	escapedData = "\"" + data + "\"";
 //    	}
 //    	return escapedData;
	// }