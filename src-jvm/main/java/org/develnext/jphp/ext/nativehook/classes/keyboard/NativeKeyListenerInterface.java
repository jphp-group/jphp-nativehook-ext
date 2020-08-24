package org.develnext.jphp.ext.nativehook.classes.keyboard;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import php.runtime.Memory;
import php.runtime.annotation.Reflection.Arg;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.lang.IObject;
import php.runtime.memory.ObjectMemory;

@Namespace(NativeHookExtension.NS+"\\keyboard")
@Name("NativeKeyListener")
public interface NativeKeyListenerInterface extends IObject, NativeKeyListener{
    @Signature({@Arg(value = "event", nativeType = NativeKeyEventWrapper.class)})
    Memory nativeKeyPressed(Environment environment, Memory ...args);

    @Signature({@Arg(value = "event", nativeType = NativeKeyEventWrapper.class)})
    Memory nativeKeyReleased(Environment environment, Memory ...args);

    @Signature({@Arg(value = "event", nativeType = NativeKeyEventWrapper.class)})
    Memory nativeKeyTyped(Environment environment, Memory ...args);


    @Override
    default void nativeKeyPressed(NativeKeyEvent nativeKeyEvent){
        nativeKeyPressed(getEnvironment(), new ObjectMemory(new NativeKeyEventWrapper(getEnvironment(), nativeKeyEvent)));
    }

    @Override
    default void nativeKeyReleased(NativeKeyEvent nativeKeyEvent){
        nativeKeyReleased(getEnvironment(), new ObjectMemory(new NativeKeyEventWrapper(getEnvironment(), nativeKeyEvent)));
    }

    @Override
    default void nativeKeyTyped(NativeKeyEvent nativeKeyEvent){
        nativeKeyTyped(getEnvironment(), new ObjectMemory(new NativeKeyEventWrapper(getEnvironment(), nativeKeyEvent)));
    }
}
