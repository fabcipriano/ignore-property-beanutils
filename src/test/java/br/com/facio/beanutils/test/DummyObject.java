package br.com.facio.beanutils.test;

/**
 *
 * @author fabianocp
 */
public class DummyObject {
    Double value = null;

    String hello = null;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public Object getValue() {
        if (value == null) {
            return null;
        }

        return value;
    }

    public void setValue(String value) {
        if (value == null) {
            return;
        }

        this.value = Double.parseDouble(value);
    }            
}
