import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class compute_a_posteriori {
	public static void main(String[] args) throws IOException {	

		String queryString = args[0];
		double prior[]= {10, 20, 40, 20, 10};
		int cherry[]= {100, 75, 50, 25, 0};
		int lime[]= {0, 25, 50, 75, 100};
		

		//To store the output in the result text file
		String outputFile = "result.txt";
		BufferedWriter output = new BufferedWriter(new FileWriter( outputFile ));

		//Show the user the Observation sequence:
		System.out.println("Observation sequence Q: " +queryString);
		output.write("Observation sequence Q: " +queryString+"\n");
		System.out.println("Length of Q: " +queryString.length());
		output.write("Length of Q: " +queryString.length()+"\n");

		// double value1 = 0.0, value2=0.0;
		// System.out.println("After Observation "+(x1+1)+" = "+queryString.charAt(x2));
		// output.write("After Observation "+(x1+1)+" = "+queryString.charAt(x2)+"\n");

		for(int x=0; x<queryString.length(); x++) {
			double value1 = 0.0, value2=0.0;
			System.out.println("After Observation "+(x+1)+" = "+queryString.charAt(x));
			output.write("After Observation "+(x+1)+" = "+queryString.charAt(x)+"\n");				

			for(int i=0; i<5; i++) {
				value1+= cherry[i]*prior[i]/10000.0;
				value2+= lime[i]*prior[i]/10000.0;
			}

			if (queryString.charAt(x)=='C') {
				for (int j=0;j<5;j++) {
					prior[j]= cherry[j]*prior[j]/(value1*100); // to calculate Pt(h(i))

					//Round value with 5 decimal places
					System.out.println("P(h"+(j+1)+"| Q) = "+String.format("%.15f",(prior[j]/100.00 )));
					output.write("P(h"+(j+1)+"| Q) = "+String.format("%.15f", (prior[j])/100.00) +"\n");
				}
			} else {
				for (int j=0;j<5;j++) {
					prior[j]= lime[j]*prior[j]/(value2*100);
					System.out.println("P(h"+(j+1)+"| Q) = "+String.format("%.15f",(prior[j]/100.0)));
					//output.write("P(h"+(h+1)+"| Q) = "+String.format("%.15f", (prior[j])/100.00)+"\n");					
					//output.write("P(h"+(h+2)+"| Q) = "+String.format("%.15f", (prior[j])/100.00)+"\n");
					output.write("P(h"+(j+1)+"| Q) = "+String.format("%.15f", (prior[j])/100.00)+"\n");
				}
			}
			
			value1 = 0.0; 
			value2 = 0.0;

			for(int i=0;i<5;i++) {
				value1 += cherry[i]*prior[i]/10000.0;
				value2 += lime[i]*prior[i]/10000.0;
			}			
			
			System.out.println("Probability that the next candy we pick will be C, given Q: "+String.format("%.15f", (value1))+"\n");
			output.write("Probability that the next candy we pick will be C, given Q: "+String.format("%.15f", (value1))+"\n");
			System.out.println("Probability that the next candy we pick will be L, given Q: "+String.format("%.15f", (value2))+"\n");
			output.write("Probability that the next candy we pick will be C, given Q: "+String.format("%.15f", (value2))+"\n");
			System.out.println();
			output.write("\n");

		}

		output.close();
	}
}