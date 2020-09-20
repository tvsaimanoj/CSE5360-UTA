Name : Venkata Sai Manoj Twarakavi 
Net ID: 1001637682

Programming Language: JAVA



There are 4 java files in the directory, along with WUMPUS_RULES.txt, Readme.txt and the input files that will give outputs
as specified. 

Each File is explained in the following:


check_true_false.java
This file contains the main function and should be executed in order to run the assignment. 

This takes in three arguments:
WUMPUS_RULES.txt KnowledgeBase.txt [Statement.txt(StatementDefTrue.txt, StatementDefFalse.txt, PossiblityTF.txt)] or you can use
a.txt b.txt c.txt.
The output is different for each text file. 

The output will be displayed on the screen and then will be saved in result.txt
Structure:
On Executing, This program will call LogicalExpression.java and will put the 
KnowledgeBase and Wumpus Rules. A hashMap is made that keeps the record of true and false of the wumpus rules, whether there is a pit
or Monster if mentioned in the Knowledge Base. 

Then it keeps the record of the statement file and then calls the check_entailment.java
and tells the output accordingly which are Definitely True, Definitely False, Possibly True or False, Both true and false.


The Two classes are explained in the further lines.

LogicalExpression.java
Structure:
It has a Vector and LinkedList that keeps the record of all the Symbols that will be extracted.
It has a function of setUniqueSymbol that tells whether the symbol that is given is valid or false, and then add them to the Vector or 
LinkedList.


This function reads the rules and knowledge base accordingly, and gives an exception if not obeying the mentioned rules. 


The comment section will also explain the process in details as mentioned in the comment section.

Entailed.java
This program contains a model. 

It takes symbols from the knowledge base, and if it is present, it is not added to the HashMap.

It has a function of TT_Entails that takes KnowledgeBase, statement and model.
Then it calls check_all that checks the availability of the statement to be present in the model, by considering the Knowledge Base.


The PL_true function is called that first checks the uniqueness of the symbol. If it is unique symbol then true is returned else false.



In Order to run the code, It should be compiled first using javac *.java, This will create the class file of every java file. 


Then use the command java check_true_false wumpus_rules.txt KnowledgeBase.txt [StatementDefFalse.txt, StatementDefTrue.txt, PossiblityTF.txt] or 
		     java check_true_false a.txt b.txt c.txt