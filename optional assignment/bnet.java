import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class bnet {
	static ArrayList<String> arrayString1 = new ArrayList<String>();
	static ArrayList<String> arrayString2 = new ArrayList<String>();

	//Given from diagram
	static double burglary=0.001;
	static double earthquake=0.002;
	
	static double alarm[]= {0.95,0.94,0.29,0.001};
	static double JohnCalls[]= {0.90,0.05};
	static double MaryCalls[]= {0.70,0.01};

	public static void main(String[] args) {				
		int burglaryCounter=0, earthquakeCounter=0, alarmCounter=0, JohnCallsCounter=0, MaryCallsCounter=0;
		if (args.length <1 || args.length > 6) { 
			System.exit(0);
		}

		int index =-1;
		for(int i=0;i<args.length;i++) {
			if(args[i].equals("given")){
				index=0;
				continue;
			}
			if(index==-1) {
				arrayString1.add(args[i]);
			} else{
				arrayString2.add(args[i]);
			}
		}	
		if (arrayString1.size() <1 || arrayString1.size() > 6) { 
			System.exit(0);
		}
		if(index==0) {
			if (arrayString2.size() <1 || arrayString2.size() > 4) {
				System.exit(0);
			}		
		}

		System.out.println(arrayString1 + "given" + arrayString2);
		arrayString1.addAll(arrayString2); //arrayString1 elements appending to arrayString2 elements

		//Numerator and Denominator added by the missing variables, appending them with True and False values
		for(int i=0;i< arrayString1.size();i++) {  			
			if (!arrayString1.contains("Bt")&&!arrayString1.contains("Bf")) {
				arrayString1.add("Bt");
				arrayString1.add("Bf");
				burglaryCounter=1;
			}
			if (!arrayString1.contains("Et")&&!arrayString1.contains("Ef")) {
				arrayString1.add("Et");
				arrayString1.add("Ef");
				earthquakeCounter=1;
			}
			if (!arrayString1.contains("At")&&!arrayString1.contains("Af")) {
				arrayString1.add("At");
				arrayString1.add("Af");
				alarmCounter=1;}
			if (!(arrayString1.contains("Jt"))&&!arrayString1.contains("Jf")) {
				arrayString1.add("Jt");
				arrayString1.add("Jf");
				JohnCallsCounter=1;
			}
			if (!arrayString1.contains("Mt")&&!arrayString1.contains("Mf")) {
				arrayString1.add("Mt");
				arrayString1.add("Mf");
				MaryCallsCounter=1;
			}
		}

		double numeratorVal = compute(burglaryCounter, earthquakeCounter, alarmCounter, JohnCallsCounter, MaryCallsCounter, arrayString1);

		if(arrayString2.size()==0) {
			System.out.println("Probability: "+ numeratorVal);
		}

		burglaryCounter = earthquakeCounter = alarmCounter = JohnCallsCounter = MaryCallsCounter=0;

		for(int j=0;j< arrayString2.size();j++) {		
			// if (!arrayString1.contains("Bt")&&!arrayString1.contains("Bf")) {
			// 	arrayString1.add("Bt");
			// 	arrayString1.add("Bf");
			// 	burglaryCounter=1;
			// }
			if (!arrayString2.contains("Bt") && !arrayString2.contains("Bf")) {
				arrayString2.add("Bt");
				arrayString2.add("Bf");
				burglaryCounter=1;
			}
			if (!arrayString2.contains("Et") && !arrayString2.contains("Ef")) {
				arrayString2.add("Et");
				arrayString2.add("Ef");
				earthquakeCounter=1;
			}
			if (!arrayString2.contains("At") && !arrayString2.contains("Af")) {
				arrayString2.add("At");
				arrayString2.add("Af");
				alarmCounter=1;
			}
			if (!arrayString2.contains("Jt") && !arrayString2.contains("Jf")) {
				arrayString2.add("Jt");
				arrayString2.add("Jf");
				JohnCallsCounter=1;
			}
			if (!arrayString2.contains("Mt") && !arrayString2.contains("Mf")) {
				arrayString2.add("Mt");
				arrayString2.add("Mf");
				MaryCallsCounter=1;
			}
		}

		double denominatorVal = compute(burglaryCounter, earthquakeCounter, alarmCounter, JohnCallsCounter, MaryCallsCounter, arrayString2);

		if(arrayString2.size()>0) {
			System.out.println("Probability: " + numeratorVal / denominatorVal);
		}		
	}
	
	public static double computeProbability(boolean burglaryBool, boolean earthquakeBool, boolean alarmBool, boolean JohnCallsBool, boolean MaryCallsBool) {
		double burglaryval = 0.0;

		if(burglaryBool) {
			burglaryval = burglary;
		} else {
			burglaryval = 1 - burglary;
		}

		double earthquakeval;
		if(earthquakeBool) {
			earthquakeval=  earthquake;
		}
		else {
			earthquakeval = 1-earthquake;
		}

		double alarmval = 0.0;

		if(alarmBool) {
			if(burglaryBool==true && earthquakeBool==true)
				alarmval = alarm[0];
			else if(burglaryBool==true && earthquakeBool==false)
				alarmval = alarm[1];
			else if(burglaryBool==false && earthquakeBool==true)
				alarmval = alarm[2];
			else if(burglaryBool==false && earthquakeBool==false)
				alarmval = alarm[3];
		} else {
			if(burglaryBool==true && earthquakeBool==true )
				alarmval = 1-alarm[0];
			else if(burglaryBool==true && earthquakeBool==false )
				alarmval = 1-alarm[1];
			else if(burglaryBool==false && earthquakeBool==true )
				alarmval = 1-alarm[2];
			else if(burglaryBool==false && earthquakeBool==false )
				alarmval = 1-alarm[3];
		}

		double JohnCallsval = 0.0;
		if(JohnCallsBool) {
			if(alarmBool == true)
				JohnCallsval = JohnCalls[0];
			else if(alarmBool==false )
				JohnCallsval = JohnCalls[1];
		} else {
			if(alarmBool == true)
				JohnCallsval =1-JohnCalls[0];
			else if(alarmBool==false )
				JohnCallsval =1-JohnCalls[1];
		}

		double MaryCallsval = 0.0;
		if(MaryCallsBool) {
			if(alarmBool == true)
				MaryCallsval = MaryCalls[0];
			else if(alarmBool==false )
				MaryCallsval = MaryCalls[1];
		} else {
			if(alarmBool == true)
				MaryCallsval =1-MaryCalls[0];
			else if(alarmBool==false)
				MaryCallsval =1-MaryCalls[1];
		}

		return (burglaryval) * (earthquakeval) * (alarmval) * (JohnCallsval) * (MaryCallsval); 
	}

	public static double compute(int bc, int ec, int ac, int jc, int mc, ArrayList<String> arrayString) {				
		Boolean burglary_bool=false, earthquake_bool=false, alarm_bool=false, JohnCalls_bool=false, MaryCalls_bool=false;

		if(bc==0) {
			if(arrayString.contains("Bt")) {
				burglary_bool=true;
			}
			else burglary_bool=false;
		}
		if(ec==0) {
			if(arrayString.contains("Et")) {
				earthquake_bool=true;
			}
			else earthquake_bool=false;
		}
		if(ac==0) {
			if(arrayString.contains("At")) {
				alarm_bool=true;
			}
			else alarm_bool=false;
		}
		if(jc==0) {
			if(arrayString.contains("Jt")) {
				JohnCalls_bool=true;
			}
			else JohnCalls_bool=false;
		}
		if(mc==0) {
			if(arrayString.contains("Mt")) {
				MaryCalls_bool=true;
			}
			else MaryCalls_bool=false;
		}

		double probValue = 0.0;

		for(int iter1=0; iter1<=bc; iter1++) {

			for(int iter2=0; iter2<=ec; iter2++) {

				for(int iter3=0; iter3<=ac; iter3++) {

					for(int iter4=0; iter4<=jc; iter4++) {

						for(int iter5=0; iter5<=mc; iter5++) {
							probValue += computeProbability(burglary_bool, earthquake_bool, alarm_bool, JohnCalls_bool, MaryCalls_bool);

							if(mc==1 && MaryCalls_bool==false) {
								MaryCalls_bool=true;
							} else if(mc==1 && MaryCalls_bool==true) {
								MaryCalls_bool=false;
							}
						}

						if(jc==1 && JohnCalls_bool==false) {
							JohnCalls_bool=true;
						} else if(jc==1 && JohnCalls_bool==true) {
							JohnCalls_bool=false;
						}
					} // in the iteration 4

					if(ac==1 && alarm_bool==false){
						alarm_bool=true;	
					} else if(ac==1 && alarm_bool==true) {
						alarm_bool=false;
					}
				} // in the iteration 3
				if(ec==1 && earthquake_bool==false){ 
					earthquake_bool=true;
				} else if(ec==1 && earthquake_bool==true){ 
					earthquake_bool=false;
				}
			}// in the iteration 2
			if(bc==1 && burglary_bool==false){
				 burglary_bool=true;
			} else if(bc==1 && burglary_bool==true) {
				burglary_bool=false;
			}
		}// in the iteration 1

		return probValue;
	}
}