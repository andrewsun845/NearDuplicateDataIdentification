import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;


public class CallableMyAlgorithm implements Callable<Double> {
	String base;
	String compare;
	public CallableMyAlgorithm(String a,String b){
	        this.base=a;
	        this.compare=b;
    }
	
	
	public Double call() throws Exception {
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
		     return 0.0;
		}
		   else{
		     return finalReturn;
		   }
}

	}

