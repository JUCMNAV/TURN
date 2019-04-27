## This is a version of Turn with validation and parsing tests for input files.

The input test files are retrieved from the OneValidationErrorFiles branch of the TURNTestInput repository. 
This Tests folder contains a java file 'ParametrizedTestsFromcsv.java'. The file retrieves a csv file in the tests directory called 'expectedresults.csv'. The expectedresults.csv file is expected to have a column of  filenames of the input test files that contain tests that are have a validation error (not a parsing one), and a corresponding column of the expected error message associated with that file.
The 'ParametrizedTestsFromcsv.java' is  a JUnt test file that runs a test for each of the test files and tests them either just for parsabilty (if they are not listed in expectedresults.csv), or tests both for parsability and whether they return the correct validation error (if they are listed in expectedresults.csv).

### To test a new file:

**_To add a new test file that has no validation errors:_**
1) add the file to the OneValidationErrorFiles branch of the TURNTestInput repository
2) run ‘git submodule update –remote’ in our current TURN repository to update the referenced TURNTestInput.

**_To add a new test file that has a validation error:_**
1) add the corresponding entry in expectedresults.csv
2) add the file to the OneValidationErrorFiles branch of the TURNTestInput repository
3) run ‘git submodule update –remote’ in our current TURN repository to update the referenced TURNTestInput.

*Please note that currently the validation check tests can only assert one validation error in a file at a time, but this can be evolved further in the future to checking a larger file for a list of errors.*
