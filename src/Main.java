import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Instant start = Instant.now();
		//Thread.sleep(200);


		
/*
//		TTC-Route DataSet
// 		Delete existing output file
		Path ttcRouteOutputFile= Paths.get("C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/TTC-Routes-Answer.txt");
		deleteFile(ttcRouteOutputFile);
//		Reading the file and running algorithm
		List<List> dataset = new ArrayList<List>();
		readFile("C:/Users/Andrew/Documents/University/Fourth Year/Full Years/MIE490 Thesis/Prototype/TTC-Routes.txt",dataset, "TTC-Routes", ",");
		String[] columnTypes={"1","2","3","4","5","6","7","8","9","10"};

		for (int i = 0; i<dataset.size();i++){
			System.out.println(i+" : "+dataset.get(i).size());
			System.out.println(dataset.get(i));
			}
			
		List<List> TTCList = runAlgorithm(dataset,columnTypes);
		
//		Save Results to logFile
		writeStringToFile(TTCList,"C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/TTC-Routes-Answer.txt");

*/
		
		


		

		// MSFC_44 Wards_Complete_Final DataSet
		// Delete existing output file
						Path MSFCWardsPath = Paths.get("C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/MSFC_44_Wards_Results.txt");
						deleteFile(MSFCWardsPath);
//						Reading the file and running algorithm
						List<List> dataset1 = new ArrayList<List>();
						readFile("C:/Users/Andrew/Documents/University/Fourth Year/Full Years/MIE490 Thesis/Prototype/MSFC_44 Wards_Complete_Final.csv",dataset1, "MSFC_44 Wards_Complete_Final","~");
						String[] columnTypes1={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
						for (int i = 0; i<dataset1.size();i++){
							if (dataset1.get(i).size()!=17){
							System.out.println(i+" : "+dataset1.get(i).size());
							System.out.println(dataset1.get(i));
							}
							}
//						System.out.println(dataset1);

						List<List> MSFCList = runAlgorithm(dataset1,columnTypes1);
//						Save Results to logFile
						writeStringToFile(MSFCList,"C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/MSFC_44_Wards_Results.csv");
						

		
/*
		// Health_and_Hospitals_Corporation_HHC_Facilities DataSet
						// Delete existing output file
						Path HHC_Facilities_Results = Paths.get("C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/HHC_Facilities_Results.csv");
						deleteFile(HHC_Facilities_Results);
						Path HHC_Facilities_Results_DMAL = Paths.get("C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/HHC_Facilities_Results_DMALOnly.csv");
						deleteFile(HHC_Facilities_Results_DMAL);
						Path HHC_Facilities_Results_JaccardOnly = Paths.get("C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/HHC_Facilities_Results_JaccardOnly.csv");
						deleteFile(HHC_Facilities_Results_JaccardOnly);
//						Reading the file and running algorithm
						List<List> dataset3 = new ArrayList<List>();
						readFile("C:/Users/Andrew/Documents/University/Fourth Year/Full Years/MIE490 Thesis/Prototype/Health_and_Hospitals_Corporation__HHC__Facilities.csv",dataset3, "HHC__Facilities","~");
						String[] columnTypes3={"1","2","3","4","5","6","7"};
						for (int i = 0; i<dataset3.size();i++){
							if (dataset3.get(i).size()!=7){
							System.out.println(i+" : "+dataset3.get(i).size());
							System.out.println(dataset3.get(i));
							}
						}
//						System.out.println(dataset1);

						List<List> HHCList = runAlgorithm(dataset3,columnTypes3);
						
						
//						Save Results to logFile
						writeStringToFile(HHCList,"C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/HHC_Facilities_Results.csv");	
						
		
//						DMAL Only
						List<List> HHCdataset3DMALOnly = DLOnlyAlg(dataset3,columnTypes3);
						writeStringToFile(HHCdataset3DMALOnly,"C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/HHC_Facilities_Results_DMALOnly.csv");
						
//						Jaccard Only
						List<List> HHCdataset3JaccardOnly = JaccardOnlyAlg(dataset3,columnTypes3);
						writeStringToFile(HHCdataset3JaccardOnly,"C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/HHC_Facilities_Results_JaccardOnly.csv");	
		*/
/*
		// NYC_Jobs DataSet
						// Delete existing output file
							Path NYC_Jobs_Results = Paths.get("C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/NYC_Jobs_Results.csv");
							deleteFile(NYC_Jobs_Results);
//							Reading the file and running algorithm
							List<List> dataset4 = new ArrayList<List>();
							readFile("C:/Users/Andrew/Documents/University/Fourth Year/Full Years/MIE490 Thesis/Prototype/NYC_Jobs.csv",dataset4, "NYC Jobs","~");
							String[] columnTypes4={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27"};
							for (int i = 0; i<dataset4.size();i++){
								if (dataset4.get(i).size()!=27){
								System.out.println(i+" : "+dataset4.get(i).size());
								System.out.println(dataset4.get(i));
								}
								}
//							System.out.println(dataset1);

							List<List> NYCJobsList = runAlgorithm(dataset4,columnTypes4);
//							Save Results to logFile
							writeStringToFile(NYCJobsList,"C:/Users/Andrew/EclipseJavaWorkspace/Thesis/src/NYC_Jobs_Results.csv");						
*/

		//Calculating Time
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).toString());
	}
	
	//file read and store into memory dataset
	public static void readFile(String fileLocation, List<List> dataset, String fileName, String cvsSplitBy) {
		 
		String csvFile = fileLocation;
		BufferedReader br = null;
		String line = "";
	
		System.out.println("Reading File: "+fileName);
		int count=1;
		try {
			
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
			        // use comma as separator
				
				String[] tuple = line.split(cvsSplitBy);
				List<String> tupleList = new ArrayList<String>();
				tupleList.add(Integer.toString(count));
				Collections.addAll(tupleList,tuple);
				dataset.add(tupleList);
				count++;
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Dataset Read Complete");
	  }


	public static List<List> runAlgorithm(List<List> inData, String[] colType) throws InterruptedException, ExecutionException{
		int numOfRows = inData.size();
		List<Double> distPerRow = new ArrayList<Double>();
		List<List> finalDistPairs = new ArrayList<List>();
			//for each row
		for (int i=0;i<numOfRows;i++){
				//for each pairing
			for (int j=i+1;j<numOfRows;j++){
					//for each column
				distPerRow = new ArrayList<Double>();
				
				
				
				for (int k=0;k<colType.length;k++){
					//determine type
				
					//Calculate distance for each column
				//	System.out.println((String)inData.get(i).get(k)+"   and   "+(String)inData.get(j).get(k));
				
					
					
				distPerRow.add(myAlgorithm((String)inData.get(i).get(k),(String)inData.get(j).get(k)));
					
				}
				
				System.out.println(i+" : "+j);
				
				
				//Calculate the final distance between row(i) and row(j)
				double distance=0;
				for (int x=0;x<distPerRow.size();x++){
					//Calculate the final distance between row(i) and row(j)
					distance+=distPerRow.get(x)*distPerRow.get(x);
				}
				//Add the calculated distance between row(i) and row(j) into final matrix
				List<Double> tempList = new ArrayList<Double>();
				tempList.add((double) i);
				tempList.add((double) j);
				tempList.add(distance);
				finalDistPairs.add(tempList);
			}
		}
		return finalDistPairs;
	}
	
	
	public static double myAlgorithm(String base, String compare){
		List<String> baseWords = new ArrayList<String>();
		List<String> compareWords = new ArrayList<String>();
		Collections.addAll(baseWords,base.split(" "));
		Collections.addAll(compareWords,compare.split(" "));
		DamerauLevenshteinAlgorithm  DMAL=new DamerauLevenshteinAlgorithm(1,1,1,1);
		int baseWordNum=baseWords.size();
		int compareWordsNum=compareWords.size();
		int step1Count=0;
		float totalDmalNum=0;
		float dmalNum = 0;
		for (int i=0;i<baseWords.size();i++){
			String currBaseWord=baseWords.get(i);
			String currCompareWord = null;
			for (int k=0;k<compareWords.size();k++){
				currCompareWord=compareWords.get(k);
				if (currBaseWord.equals(currCompareWord)){

					step1Count+=2;
					compareWords.remove(k);
					k-=1;
					break;
				}
				
				
			}
			if (currBaseWord.equals(currCompareWord)){
				baseWords.remove(i);
				i-=1;
			}
		}
		
		for (int i=0;i<baseWords.size();i++){
			int countOfMatching=0;
			for (int k=0;k<compareWords.size();k++){
				dmalNum=0;
				
				dmalNum = DMAL.execute(baseWords.get(i),compareWords.get(k));
				if (dmalNum==1){
						step1Count+=2;
						compareWords.remove(k);
						k-=1;
						break;
					}
					else{
						totalDmalNum+=1/dmalNum;
					}
			}
			if (dmalNum==1){
				baseWords.remove(i);
				i-=1;
			}
		
		}
		
		
		double finalReturn = 1-(step1Count+(totalDmalNum/(baseWordNum+compareWordsNum-step1Count)))/(baseWordNum+compareWordsNum);
		
		if (Double.isNaN(finalReturn)){ 
		     return 0;
		}
		   else{
		     return finalReturn;
		   }
	}
	
	
	public static List<List> DLOnlyAlg(List<List> inData, String[] colType){
		int numOfRows = inData.size();
		List<Double> distPerRow = new ArrayList<Double>();
		List<List> finalDistPairs = new ArrayList<List>();
		DamerauLevenshteinAlgorithm  DMAL=new DamerauLevenshteinAlgorithm(1,1,1,1);
			//for each row
		for (int i=0;i<numOfRows;i++){
				//for each pairing
			for (int j=i+1;j<numOfRows;j++){
					//for each column
				distPerRow = new ArrayList<Double>();
				
				
				
				for (int k=0;k<colType.length;k++){
					//determine type
				
					//Calculate distance for each column
				//	System.out.println((String)inData.get(i).get(k)+"   and   "+(String)inData.get(j).get(k));
				
					
					
				distPerRow.add((double)DMAL.execute((String)inData.get(i).get(k),(String)inData.get(j).get(k)));
					
				}
				
				
				//Calculate the final distance between row(i) and row(j)
				double distance=0;
				for (int x=0;x<distPerRow.size();x++){
					//Calculate the final distance between row(i) and row(j)
					distance+=distPerRow.get(x);
				}
				//Add the calculated distance between row(i) and row(j) into final matrix
				List<Double> tempList = new ArrayList<Double>();
				
				tempList.add((double) i);
				tempList.add((double) j);
				tempList.add(distance);
				finalDistPairs.add(tempList);
			}
		}
		return finalDistPairs;
	}
	
	public static List<List> JaccardOnlyAlg(List<List> inData, String[] colType){
		int numOfRows = inData.size();
		List<Double> distPerRow = new ArrayList<Double>();
		List<List> finalDistPairs = new ArrayList<List>();
		for (int i=0;i<numOfRows;i++){
			for (int j=i+1;j<numOfRows;j++){
				distPerRow = new ArrayList<Double>();
				for (int k=0;k<colType.length;k++){
					List<String> baseWords = new ArrayList<String>();
					List<String> compareWords = new ArrayList<String>();
					Collections.addAll(baseWords,((String) inData.get(i).get(k)).split(" "));
					Collections.addAll(compareWords,((String) inData.get(j).get(k)).split(" "));
					int step1Count=0;
					int totalWords=baseWords.size()+compareWords.size();
					for (int x=0;x<baseWords.size();x++){
						String currBaseWord=baseWords.get(x);
						String currCompareWord = null;
						for (int y=0;y<compareWords.size();y++){
							currCompareWord=compareWords.get(y);
							if (currBaseWord.equals(currCompareWord)){

								step1Count+=2;
								compareWords.remove(y);
								y-=1;
								break;
							}
							
							
						}
						if (currBaseWord.equals(currCompareWord)){
							baseWords.remove(x);
							x-=1;
						}
					}
					distPerRow.add((double) (totalWords-step1Count));
					
				}
			
			
			double distance=0;
				for (int x=0;x<distPerRow.size();x++){
					//Calculate the final distance between row(i) and row(j)
					distance+=distPerRow.get(x)*distPerRow.get(x);
				}
			List<Double> tempList = new ArrayList<Double>();
			tempList.add((double) i);
			tempList.add((double) j);
			tempList.add(distance);
			finalDistPairs.add(tempList);
			
			}
		}
			
			
			
			return finalDistPairs;
			
	}
	
	
	
	public static void writeStringToFile( List<List> input,String fileLocation){
		try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileLocation,true));
            out.write("Base Row~Compare Row~Distance"+System.lineSeparator());
            for (int i = 0; i<input.size();i++){
            	String text=input.get(i).get(0).toString();
            	for (int k=1;k<input.get(i).size();k++){
            		text+="~"+input.get(i).get(k).toString();
            	}
            	text+=System.lineSeparator();
				out.write(text);
			}		
            out.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception ");       
        }
		
	}
	
	public static void deleteFile(Path path){
		try {
		    Files.delete(path);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
	}

	
}