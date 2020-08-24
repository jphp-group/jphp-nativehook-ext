package org.develnext.jphp.ext.nativehook.classes.mouse;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.develnext.jphp.ext.nativehook.classes.keyboard.NativeKeyEventWrapper;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import php.runtime.Memory;
import php.runtime.annotation.Reflection.Arg;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.lang.IObject;
import php.runtime.memory.ObjectMemory;

@Namespace(NativeHookExtension.NS+"\\mouse")
@Name("NativeMouseListener")
public interface NativeMouseListenerInterface extends IObject, NativeMouseListener{
    @Signature({@Arg(value = "event", nativeType = NativeMouseEventWrapper.class)})
    Memory nativeMouseClicked(Environment environment, Memory ...args);

    @Signature({@Arg(value = "event", nativeType = NativeMouseEventWrapper.class)})
    Memory nativeMousePressed(Environment environment, Memory ...args);

    @Signature({@Arg(value = "event", nativeType = NativeMouseEventWrapper.class)})
    Memory nativeMouseReleased(Environment environment, Memory ...args);

    @Override
    default void nativeMouseClicked(NativeMouseEvent event){
        nativeMouseClicked(getEnvironment(), new ObjectMemory(new NativeMouseEventWrapper<>(getEnvironment(), event)));
    }

    @Override
    default void nativeMousePressed(NativeMouseEvent event){
        nativeMousePressed(getEnvironment(), new ObjectMemory(new NativeMouseEventWrapper<>(getEnvironment(), event)));
    }

    @Override
    default void nativeMouseReleased(NativeMouseEvent event){
        nativeMouseReleased(getEnvironment(), new ObjectMemory(new NativeMouseEventWrapper<>(getEnvironment(), event)));
    }
}
