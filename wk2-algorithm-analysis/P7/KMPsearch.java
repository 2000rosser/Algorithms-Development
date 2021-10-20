package P7;


// JAVA program for implementation of KMP pattern
	// searching algorithm 
	  
	public class KMPsearch {
	    public void KMPSearch(String pat, String txt)
	    { 
	        int M = pat.length(); 
	        int N = txt.length(); 
	  
	        // create lps[] that will hold the longest 
	        // prefix suffix values for pattern 
	        int lps[] = new int[M]; 
	        int j = 0; // index for pat[] 
	  
	        // Preprocess the pattern (calculate lps[] 
	        // array) 
	        computeLPSArray(pat, M, lps); 
	  
	       //insert your code here
			int i = 0;
			while (i < N) {
				if (pat.charAt(j) == txt.charAt(i)) {
					j++;
					i++;
				}
				if (j == M) {
					System.out.println("found the pattern "
							+ "at the index " + (i - j));
					j = lps[j - 1];
				}

				else if (i < N && pat.charAt(j) != txt.charAt(i)) {

					if (j != 0)
						j = lps[j - 1];
					else
						i = i + 1;
				}
			}
	    } 
	  
	    void computeLPSArray(String pat, int M, int lps[]) 
	    {
	        int len = 0; 
	        int i = 1; 
	        lps[0] = 0;

	        while (i < M) { 
	            if (pat.charAt(i) == pat.charAt(len)) { 
	                len++; 
	                lps[i] = len; 
	                i++; 
	            } 
	            else
	            {
	                if (len != 0) { 
	                    len = lps[len - 1];
	                } 
	                else
	                { 
	                    lps[i] = len; 
	                    i++; 
	                } 
	            } 
	        } 
	    }


	    public static void main(String args[]) 
	    { 
	        String txt = "AAAAABBBBB";
	        String pat = "AB";
	        new KMPsearch().KMPSearch(pat, txt);
	    } 
	} 