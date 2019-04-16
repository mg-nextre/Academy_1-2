package it.nextre.academy.esercizi.es_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Caller {

    static List<String> classiNonPermesse = new ArrayList<>(Arrays.asList("Object","Byte","Short","int","long","String","char","Character","boolean","Boolean"));

    public static List qualcosa(Class classe, Object obj) throws InvocationTargetException, IllegalAccessException {
        List ritorniMetodi = new ArrayList();
        Method[] methods = classe.getDeclaredMethods();
        for(Method m : methods){
            Parameter[] params = m.getParameters();
            String inputInMethod = params.length == 1 ? params[0].getType().getSimpleName() : "";
            //if(params.length == 1 && (inputInMethod.equalsIgnoreCase("Object") || inputInMethod.equalsIgnoreCase("String") || inputInMethod.equalsIgnoreCase("int"))){
                if(classiNonPermesse.contains(inputInMethod)){
                    continue;
                }
                //continue;
            //}
            System.out.println(m.getName());
            ritorniMetodi.add(m.invoke(obj));
        }
        ritorniMetodi.removeIf(Objects::isNull);
        return ritorniMetodi;
    }
}//end class
