package Printer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Printer {
	
		// taking paper's height as 40
		private final static int height = 40;
		// taking paper's width as 36
		private final static int width = 36;

		public static void main(String[] args)  {
			// getting the text to be written into the file for printing.
			StringBuilder text = new StringBuilder();
			String str;
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the text to be printed. Please type $end at the end of the text.");
			//$end is given at the end to mark the end of the document. 
			try {
				while (!(str= br.readLine()).equalsIgnoreCase("$end"))
				{	 	
					text.append(str);
					text.append("\n");
				}
			} catch (IOException e1) {
				System.out.println("Error Reading Data");
				System.exit(0);
			}
			
			System.out.println();
			String[] para= text.toString().split("\n"); // split the document into paragraphs if any.

			try {
				int m = 1;
				/* below line creates the file PrintPage1.text; this will be the first page to be printed. */	
				File file = new File("PrintPage" + m + ".txt");
				System.out.println("Printing file "+ file.getName());
				file.createNewFile();
				FileWriter writer = new FileWriter(file);
				int pg_height = 1;
				int line_length = 0;
				StringBuilder line = new StringBuilder("");
				
				for (int j=0; j<para.length; j++) // loop over every paragraph
				{
					line_length=0;
					line=new StringBuilder("");
					String[] words= para[j].split(" "); // split the paragraph into separate words to print.
				for (int i = 0; i < words.length; i++) // loop over every word in the paragraph
				{
					line_length += words[i].length();
					
					if (line_length < width) {
						line.append(words[i]);
						line.append(" ");
						line_length++;// Incrementing to create space between strings
					}

						// to check if the text has come to the end of the line, then a new line is begun.
					else 
					{
						line_length = 0;
						pg_height++;
						/* to check if the text has come to the end of the page, 
						then the page is written to a text, and a new page is begun. */
						if (pg_height > height) 
						{
							writer.write(line.toString());
							writer.flush();
							m++;// incrementing m to create next page for printing
							file = new File("PrintPage" + m + ".txt");
							System.out.println("Printing file "+file.getName());
							writer = new FileWriter(file);
							pg_height = 1;
							line = new StringBuilder("");
							line.append(words[i]);
							line_length = words[i].length();
							if(line_length!=width)
							{
								line.append(" ");
								line_length++;// adding space between words
							}
						} 
						else 
						{
								line.append("\r\n");
								line.append(words[i]);
								line_length += words[i].length();
								if(line_length < width)
								{
									line.append(" ");
									line_length++;// adding space between words
								}
						}
					} 
				}
				writer.write(line.toString()+"\r\n");
				}
				writer.flush();
				writer.close();
				System.out.println("File writing is done");
			} catch (IOException e) {
				System.out.println("unexpected error in printing page.");
				System.exit(0);
			}
		}
	}

