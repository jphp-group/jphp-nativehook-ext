package org.develnext.jphp.ext.nativehook.classes.mouse;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseMotionListener;
import php.runtime.Memory;
import php.runtime.annotation.Reflection.Arg;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.lang.IObject;
import php.runtime.memory.ObjectMemory;

@Namespace(NativeHookExtension.NS+"\\mouse")
@Name("NativeMouseMotionListener")
public interface NativeMouseMotionListenerInterface extends IObject, NativeMouseMotionListener{
    @Signature({@Arg(value = "event", nativeType = NativeMouseEventWrapper.class)})
    Memory nativeMouseMoved(Environment environment, Memory ...args);

    @Signature({@Arg(value = "event", nativeType = NativeMouseEventWrapper.class)})
    Memory nativeMouseDragged(Environment environment, Memory ...args);

    @Override
    default void nativeMouseMoved(NativeMouseEvent event){
        nativeMouseMoved(getEnvironment(), new ObjectMemory(new NativeMouseEventWrapper<>(getEnvironment(), event)));
    }

    @Override
    default void nativeMouseDragged(NativeMouseEvent event){
        nativeMouseDragged(getEnvironment(), new ObjectMemory(new NativeMouseEventWrapper<>(getEnvironment(), event)));
    }
}
