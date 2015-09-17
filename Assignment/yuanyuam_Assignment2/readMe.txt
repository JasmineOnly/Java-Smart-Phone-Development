Assignmemt2

/ Yuanyuan Ma
/ Andrew ID: yuanyuan

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
A quick overview of your submission folder:

- Folder”yuanyuam_Assignment2”: the whole Eclipse project
- “Output.txt”: the output of the tests
- “StudentData.txt”: Student input with title and 15 records
- “StudentData1.txt”: Student input with title and 0 record
- “StudentData2.txt”: Student input with title and 45 records 
- “StudentData3.txt”: Student input with title and 40 records 
- “ClassDiagram.png”: The class diagram for this project

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
How to run this project:

- 1 Unzip the .zip file, import the Folder “yuanyuan_Assignment2” into Eclipse.
- 2 Open the package "indi.yuanyuam.assign2.driver", then run the class "Run" see the output. 
- 3 Open the package “indi.yuanyuam.assign2.test”, run the class “TestStatistic” to the output for test class “Statistic”.
- 4 Open the package “indi.yuanyuam.assign2.test”, run the class “TestStudent” to the output for test class “Student”.
- 5 Open the package “indi.yuanyuam.assign2.test”, run the class “TestUtil” to the output for test class “Utiil”.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
Project Organization 

-(package) indi.yuanyuam.assign2.abstractclass : all abstract class
	+ (abstract class) People : abstract of student, this class has no instance field and method ( If we extend this project, we can add more objects, such as teacher.They all can extend from abstract class People)
	+ (abstract class) Stats : abstract of statistics. This class includes abstract method : findHigh(Student[]s), findLow(Student[]s) and findAvg(Student[]s).

————————————————————————————————————————————————————————————————————————————————————
-(package) indi.yuanyuam.assign2.driver : run the project
	+ (class) Run : put all the requirements together in driver class. 

————————————————————————————————————————————————————————————————————————————————————
-(package) indi.yuanyuam.assign2.exception : all custom exceptions
	+ (class) StudentNumExceedBoundException: handle the exception whose input student number above 40
	+ (class) StudentScoreNumException : handle the exception that number of input scores is not 5

————————————————————————————————————————————————————————————————————————————————————
-(package) indi.yuanyuam.assign2.interfaces : the custom interface		
	+ (interface) Printer: interface for classes which need to print information

————————————————————————————————————————————————————————————————————————————————————
-(package) indi.yuanyuam.assign2.statistics: package for statistics
	+ (class) Statistics: extends abstract class Stats and implement Printer interface. In this class, I have overrode the findHigh, findLow and findAvg and toPring() methods.

————————————————————————————————————————————————————————————————————————————————————
-(package) indi.yuanyuam.assign2.student: package for student
	+ (class) Student: extends abstract class People and implement Printer interface. In this class, I have overrode toPring() methods. This class includes the student ID number, scores and the corresponding getter and setter methods.

———————————————————————————————————————————————————————————————————————————————————
-(package) indi.yuanyuam.assign2.test: all the test classes
	+ (class) TestStatistics: test the Statistics class. Particularly, test the case that some terms of the input Student[] are equal to null.
	+ (class) TestStudent: test the Student class. Initially, test all the methods in class Student, including getters, setters and toPrint(); Then test the case that the input student ID number is below 4 digits. Last test the cases that the number of input scores is not equal to 5 (more than 5 or less than 5).
	+ (class) TestUtil: test the Util class. There are 4 cases needed to be test: Input has less than 40 records, input has 0 record, input has more than 40 records and input has 40 records.

————————————————————————————————————————————————————————————————————————————————————
- (package) indi.yuanyuam.assign2.util: package for Until
	+ (class) Util: includes the method readFile





