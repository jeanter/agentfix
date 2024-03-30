quickly replace a method of a 3rd-party library

example :
      see com.json.agentfix.TargerFix

the replacements.txt  containing a list of classes that contain @ReplaceMethod      

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

TargerFix,java is


用agent快速修改第三方包的指定方法 
代码示例 看 TargerFix.java

用MethodReplac注解指定目标class和目标方法,被添加注解的方法就是目标方法的替换方法，依赖的第三方包需加在MANIFEST.MF中,目录结构看上面的tree结构

可以在replacements.txt中添加修改的方法定义类











