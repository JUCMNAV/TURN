*This is a version of Turn with validation and parsing tests for input files.*

This Tests folder contains a java file 'ParametrizedTestsFromcsv.java'.
The file retrieves a csv file in the tests directory called 'expectedresults.csv'.
The expectedresults.csv file is expected to have a column of filenames that contain tests that are expected to have a validation error (not parsing ones), and a corresponding column of the expected error message asscociated with that file.

The 'ParametrizedTestsFromcsv.java' runs as a junt test that goes through all the test files and tests them either just for parsabilty if they arent part of expectedresults.csv, or tests both for parsability and whether they return the correct validation error (if they are listed in expected results.csv).

-To add a new test file that has no validation errors, just simply place it in the root of the tests folder, with the other test files
-To add a new test file that has a validation error, place it in the root folder as well, and add a corresponding entry in expectedresults.csv, which is located in the same place.

Please note that currently the validation check tests can only assert one validation error in a file at a time, but this can be evolved further in the future to checking a larger file for a list of errors.
