package net.technearts.javapom;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
enum PackageType {
    JAR, WAR, POM, EAR
}
@Retention(RUNTIME)
@Target({ TYPE, FIELD, LOCAL_VARIABLE })
public @interface Packaging {
    public PackageType value();
}
