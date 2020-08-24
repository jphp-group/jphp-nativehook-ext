package org.develnext.jphp.ext.nativehook.classes.mouse;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.develnext.jphp.ext.nativehook.classes.event.NativeMouseWheelEventWrapper;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;
import php.runtime.Memory;
import php.runtime.annotation.Reflection.Arg;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.lang.IObject;
import php.runtime.memory.ObjectMemory;

@Namespace(NativeHookExtension.NS+"\\mouse")
@Name("NativeMouseWheelListener")
public interface NativeMouseWheelListenerInterface extends IObject, NativeMouseWheelListener{
    @Signature({@Arg(value = "event", nativeType = NativeMouseWheelEventWrapper.class)})
    Memory nativeMouseWheelMoved(Environment environment, Memory ...args);

    @Override
    default void nativeMouseWheelMoved(NativeMouseWheelEvent event){
        nativeMouseWheelMoved(getEnvironment(), new ObjectMemory(new NativeMouseWheelEventWrapper(getEnvironment(), event)));
    }
}
