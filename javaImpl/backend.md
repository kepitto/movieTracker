When AOT? -  
In general AOT compilation leads to faster startup times since it compiles and optimizes the application already before  
the program runs. When the program starts the OS just loads the precompiled code into memory and the applications starts  
executing. We also have  In comparison to JIT we have smaller memory usage since everything is compiled aot and jit  
not only need to store compiled code in memory while running but also the JIT compiler itself need to be loaded and  
maintained in memory. Also JIT can generate more code than AOT due to the fact that the JIT compiler can generate  
specialized code based on the execution behavior of the application.


When JIT? - 
In general JIT compilation leads to overall better performance since we compile and optimize the codebase on runtime.  
This means if an application has a high level of dynamic behavior we are more performant. JIT compiler analyzes the code  
as it is being executed and optimizes it based on the current execution context.  


What should we use? -  
It makes sense to use JIT compilation in our application since we have a more dynamic behavior, meaning the code  
needs to be flexible and adaptable to handle different data formats, processing requirements, and performance needs.  
We also do not really need a fast application startup since our application will run continuously or for a long time.  
Also memory won't be an issue as we want to process large amounts of real time data anyway.  


We use Java Spring Boot which uses JIT by default.  
(With GraalVM it is also possible to use AOT)