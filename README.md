# About

This project enables commit-level coverage reporting.

# Why you would use this


[Workplace with a million line codebase and 100s of developers working on it.]

Tech Lead: "We really want to get the coverage up on this codebase - more tests will give us more feedback about the code."
Developer: "Well that's lovely, but I really need to ship my feature - I'll make sure my stuff is covered as best I can."
Tech Lead: "Ok - how much coverage are you aiming for?"
Developer: "I'll make sure the lines I touch have coverage."
Tech Lead: "Ok - how will you measure that?"
....

Now obviously (a) this codebase is a candidate for modularisation and (b) sonar does give you feedback on coverage at a commit level - but sonar doesn't give you a way to know what the commit-level coverage is prior to pushing your changes. ie - if you've missed some coverage on the lines you've changed - there isn't a way to know before pushing.

This change is trying to solve the problem of knowing "for the lines I have touched - what coverage have I got? What lines have I missed?"


# How to setup and use in your project

Add the following into your `pom.xml`

    <project>
        <build>
            <plugins>
                <plugin>
                    <groupId>com.github.juliangamble</groupId>
                    <artifactId>commit-level-coverage-report</artifactId>
                    <version>1.0</version>
                    <executions>
                        <execution>
                            <id>post-unit-test2</id>
                            <phase>test</phase>
                            <goals>
                                <goal>report-on-commit-coverage</goal>
                            </goals>
                            <configuration>
                                <!-- Optional - sets the path to the file which contains the execution data. -->
                                <!-- <dataFile>${project.build.directory}/coverage-reports/jacoco.exec</dataFile> -->
                                <!-- Sets the output directory for the code coverage report. -->
                                <outputDirectory>${project.reporting.outputDirectory}/</outputDirectory>
                                <daysBackToCheck>100</daysBackToCheck>
                            </configuration>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>
    </project>


Then run this:

    mvn clean test

# Example Result

    ----
    Commit: caaa32f8c8eff580b4760f60dbf021d6e03935c3 - Sun Jul 16 20:48:50 AEST 2017 - Julian Gamble - [dev] first drop

    source file name: /com/machiavellian/MyApplication.java
    Intersection of line changes with coverage (lines we care about): 4
    covered lines: 3
    Coverage for commit: 75%
    Lines not covered: 1
    src/main/java/com/machiavellian/MyApplication.java:11         return firstArg - secondArg;

    ----
    Commit: 57bfb7956b501afca5fc101753d6e284d448f4ce - Sun Jul 16 20:53:59 AEST 2017 - Julian Gamble - [dev] adding new method

    Intersection of line changes with coverage (lines we care about): 1
    covered lines: 1
    Coverage for commit: 100%
    Lines not covered: 0
    ----
    Commit: acf35680891d1f853a226035981c1ac18d9f50a2 - Sun Jul 16 20:55:58 AEST 2017 - Julian Gamble - [dev] adding coverage

    Intersection of line changes with coverage (lines we care about): 0
    covered lines: 0
    Coverage for commit: 0%
    Lines not covered: 0
    ----
    Commit: 9c42a1ab1e8db57e31e17837120da6dc257dbb72 - Sun Jul 16 20:56:23 AEST 2017 - Julian Gamble - [dev] adding divide method

    Intersection of line changes with coverage (lines we care about): 1
    covered lines: 0
    Coverage for commit: 0%
    Lines not covered: 1
    src/main/java/com/machiavellian/MyApplication.java:19         return firstArg / secondArg;

    ----

# Result File Location

    target/site/jacoco-ut/coverage-per-commit.txt



# Example Project

Please see the example project here: https://github.com/juliangamble/jacoco-example-project



