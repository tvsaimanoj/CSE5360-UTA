Name: Venkata Sai Manoj Twarakavi
UTA ID: 1001637682

Programming language: Java 

Code Structure:

For Task 1-

compute_a_posteriori.java

1) Determines the posterior probability of different hypotheses, given the priors for hypotheses, and provided sequences of observations.

2) Determines the probability that next observation will be of the specific type, priors for various hypotheses and given with the  sequence of observations.

For Task 2-

bnet.java

The bnet.java file Computes and prints the probability of the combination of events given any other combination of events, given a Bayesian network.

1) compute(int bc, int ec, int ac, int jc, int mc, ArrayList<String> arrayString)
compute function calls computeProbability function to get the probability with different combinations of values from the missing elements in the numerator and denominator.

2) computeProbability(boolean burglaryBool, boolean earthquakeBool, boolean alarmBool, boolean JohnCallsBool, boolean MaryCallsBool)
computeProbability function has arguments which are boolean as specified from the assignment, relates to the events burglary, earthquake, alarm, john-calls, mary-calls -> true or false.


How to run the program:

Task1:
javac compute_a_posteriori.java
- it generates the compute_a_posteriori.class
java compute_a_posteriori observations
for ex: java compute_a_posteriori CLLCCLLLCCL

Task2:
javac bnet.java
- it generates the bnet.class
java  bnet Jt Af given Bt Ef
for ex: java  bnet Jt Af given Bt Ef