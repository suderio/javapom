package net.technearts.javapom;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.TYPE;

@Target({ TYPE, FIELD, LOCAL_VARIABLE })
public @interface Properties {
    public String[] value();
}
