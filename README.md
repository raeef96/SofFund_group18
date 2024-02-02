# DECIDE: Launch Interceptor Program

## Description
Program for an anti-ballistic missile system that gives True or False signals for intercept based on radar data. 

This project is based on the development of a function called DECIDE() as part of a hypothetical anti-ballistic missile system. The function generates a True or False signal to determine whether an interceptor should be launched based on input radar tracking information. It evaluates a set of Launch Interceptor Conditions (LICs) using inputs like planar data points, a Logical Connector Matrix (LCM), and a Preliminary Unlocking Vector (PUV), to produce a Final Unlocking Vector (FUV) for the launch decision.

## Technologies
- Java 17.0.9
- Junit 4.13.2
- Maven 3.9.6

## Installation & usage
git clone [https://github.com/raeef96/SofFund_group18.git](https://github.com/raeef96/SofFund_group18.git)

To run the program normally from CLI simply run the commands below in your terminal.
```bash
cd SofFund_group18/1-DECIDE
javac src/Missilesystem.java
java src/Missilesystem
```

To run the JUnit tests, you first need to install Maven
> [Maven](https://maven.apache.org/download.cgi)

Then simply navigate to "1-DECIDE" and run it with the following maven command:
```bash
mvn clean test
```

## Essence
The team is currently in the "In place" stage. The team is currently close to finishing the first assignment and has agreed upon several practices that are used by all members to complete their respective work. However, the team has agreed that there still is a lot of room for improvement in the methods and practices. For example, writing test cases when committing new code. The team is planning on having a retrospective meeting after the assignment to gather concrete solutions to issues such as improved methods for reviewing pull requests. Some of the points in the checklist are not really relevant for this exercise, the points in state "Principles Established" that use the word stakeholders are not really relevant for this type of project since there is not really any external party that has an interest on the performance of this project. We assessed that we are in the state "In place" since the previous stages are completed. We have completed the "Principles Established" state since we have addressed the principles and constraints of way-of-working. The team has addressed the "Foundation Established" stage and decided on the basic methods for working such as communication methods, meeting times, and tools. In addition, the team has identified that there is a gap in testing knowledge. We have also started to use these practices and tools to start working and made significant progress in the first assignment. This leaves us in the state "In place" where the team is mainly waiting for the opportunity to gather our feedback and adapt the way-of-working for the next assignment. 


## Contributions
**Rafael**
- Lic 7-14
- CMV helper functions
- Wrote tests to decide
- Added documentation for CMV functions

**Gustaf**
- Implemented Points, Parameters, and skeleton
- implemented launch & decide
- Wrote tests for PUM & decide
- Added documentation for CMV functions
- Wrote tests for decide & PUM
  
**André**
- Implemented Points, Parameters, and skeleton
- Created the test suite
- Created test cases for lic conditions 0-10
- Wrote tests for decide & FUV

**Samuel**
- Implemented PUM
- Implemented FUV
- Created test cases for lic conditions 11-14
- Wrote tests to decide

**Noel**
- Lic 0-6
- CMV helper functions
- Made contributions to the Read me
- Added documentation for CMV functions
- Wrote tests to decide


