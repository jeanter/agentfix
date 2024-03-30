package com.json.agentfix;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.List;

public class MethodReplacementAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        try {
            InputStream in = MethodReplacementAgent.class.getClassLoader().getResourceAsStream("replacements.txt");
            if (in == null) {
                throw new Exception("/method-replacements.txt is missing. Include it and list all classes that define method replacements");
            }
            BufferedReader r = new BufferedReader(new InputStreamReader(in));
            String line = null;
            List<Class<?>> loadedClasses = new ArrayList<Class<?>>();
            while ((line = r.readLine()) != null) {
                loadedClasses.add(Class.forName(line));
            }
            r.close();
            for (Class<?> c : loadedClasses) {
                MethodTransformer.setupMethodRedefinition(c);
            }

            Class<?>[] classes = new Class<?>[MethodTransformer.replacementMethods.size()];
            int i = 0;
            for (String c : MethodTransformer.replacementMethods.keySet()) {
                classes[i++] = Class.forName(c);
            }

            instrumentation.addTransformer(new MethodTransformer(), true);
            instrumentation.retransformClasses(classes);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
