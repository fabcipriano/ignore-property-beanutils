/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facio.beanutils;

import java.util.Collections;
import java.util.Set;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fabianocp
 */
public class IgnoreWriteMethodPropertyUtilsBeanTest {
    
    public IgnoreWriteMethodPropertyUtilsBeanTest() {
    }
    
    /**
     * Test of getPropertyDescriptor method, of class IgnoreWriteMethodPropertyUtilsBean.
     */
    @Test
    public void test_copyProperties_UseIgnoreWriteMethodProperty_SkipCopy() throws Exception {
        DummyObject dest = new DummyObject();
        DummyObject src = new DummyObject();
        src.setValue("666");
        src.setHello("Hello World!!!");
        
        assertEquals(new Double("666.0"), src.getValue());
        
        assertNull(dest.getValue()); 
        assertNull(dest.getHello()); 
        BeanUtilsBean.getInstance().getConvertUtils().register( false, true, 0 );
        Set<String> ignore = Collections.singleton("public void br.com.facio.beanutils.DummyObject.setValue(java.lang.String)" );
        BeanUtilsBean b = 
                new BeanUtilsBean(BeanUtilsBean.getInstance().getConvertUtils(), 
                new IgnoreWriteMethodPropertyUtilsBean( ignore ));

        b.copyProperties(dest, src);
        //BeanUtils.copyProperties(dest, src);

        assertNull(dest.getValue()); //ignored
        assertEquals("Hello World!!!", dest.getHello());
        
    }    
}
