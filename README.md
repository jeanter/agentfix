quickly replace a method of a 3rd-party library

example :
      see com.json.agentfix.TargerFix

add dependent 3rd-party library path to MANIFEST.MF

the api-client-1.1.2-SNAPSHOT.jar is my test jar  
the root.jar is a springboot jar for test
the floder like :
- folder
  - root.jar
  - agentfix-0.0.1-SNAPSHOT.jar
  - lib
      - api-client-1.1.2-SNAPSHOT
      - javassist-3.22.0-GA.jar


run :
    java -javaagent:./agentfix-0.0.1-SNAPSHOT.jar  -jar root.jar







