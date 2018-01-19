package net.technearts.javapom;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
enum DistributionType {
    Repo, Manual
}
@Retention(RUNTIME)
@Target({ FIELD, LOCAL_VARIABLE })
public @interface LicenseDistribution {
    public DistributionType value();
}
