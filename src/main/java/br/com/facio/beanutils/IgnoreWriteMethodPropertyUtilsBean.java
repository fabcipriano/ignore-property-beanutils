package br.com.facio.beanutils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtilsBean;

/**
 *
 * @author fabianocp
 */
public class IgnoreWriteMethodPropertyUtilsBean  extends PropertyUtilsBean {
    private Set<String> methodsToIgnore = new HashSet<>();

    public IgnoreWriteMethodPropertyUtilsBean( Set<String> methods ) {
        methodsToIgnore.addAll(methods);
    }
    
    public PropertyDescriptor getPropertyDescriptor(Object bean, String name)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        PropertyDescriptor pd = super.getPropertyDescriptor(bean, name);

        if (pd != null 
                && pd.getWriteMethod() != null 
                && methodsToIgnore.contains(pd.getWriteMethod().toString())) {
            System.out.println("IGNORED: " + pd.getWriteMethod());
            //ignore method, skip copy of this property
            return null;
        }

        return pd;
    }
    
}
