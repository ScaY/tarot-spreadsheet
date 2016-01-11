package fr.isen.m2.jee.tarotspreadsheet.jpa.guice;

import com.google.inject.Module;

import java.lang.annotation.*;

@Inherited
@Retention ( RetentionPolicy.RUNTIME )
@Target ( {ElementType.TYPE , ElementType.METHOD} )
public @interface Modules {
    Class<? extends Module>[] value();
}
