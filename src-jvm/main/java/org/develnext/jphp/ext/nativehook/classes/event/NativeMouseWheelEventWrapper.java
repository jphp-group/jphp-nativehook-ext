package org.develnext.jphp.ext.nativehook.classes.event;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.develnext.jphp.ext.nativehook.classes.mouse.NativeMouseEventWrapper;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import php.runtime.annotation.Reflection.Getter;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Namespace(NativeHookExtension.NS+"\\mouse")
@Name("NativeMouseWheelEvent")
public class NativeMouseWheelEventWrapper extends NativeMouseEventWrapper<NativeMouseWheelEvent>{
    public static final int WHEEL_BLOCK_SCROLL = NativeMouseWheelEvent.WHEEL_BLOCK_SCROLL;
    public static final int WHEEL_UNIT_SCROLL = NativeMouseWheelEvent.WHEEL_UNIT_SCROLL;

    public NativeMouseWheelEventWrapper(Environment env, NativeMouseEvent wrappedObject){
        super(env, wrappedObject);
    }
    public NativeMouseWheelEventWrapper(Environment env, ClassEntity clazz){
        super(env, clazz);
    }

    @Signature
    public void __construct(int id, long when, int modifiers, int x, int y, int clickCount, int scrollType, int scrollAmount, int wheelRotation){
        __wrappedObject = new NativeMouseWheelEvent(id, when, modifiers, x, y, clickCount, scrollType, scrollAmount, wheelRotation);
    }

    interface WrappedInterface{
        @Getter int getScrollAmount();
        @Getter int getScrollType();
        @Getter int getWheelRotation();
    }
}