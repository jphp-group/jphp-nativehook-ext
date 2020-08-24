package org.develnext.jphp.ext.nativehook.classes.mouse;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.develnext.jphp.ext.nativehook.classes.event.NativeInputEventWrapper;
import org.jnativehook.mouse.NativeMouseEvent;
import php.runtime.annotation.Reflection.Getter;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Namespace(NativeHookExtension.NS+"\\mouse")
@Name("NativeMouseEvent")
public class NativeMouseEventWrapper<C extends NativeMouseEvent> extends NativeInputEventWrapper<NativeMouseEvent>{
    public static final int BUTTON1 = NativeMouseEvent.BUTTON1;
    public static final int BUTTON2 = NativeMouseEvent.BUTTON2;
    public static final int BUTTON3 = NativeMouseEvent.BUTTON3;
    public static final int BUTTON4 = NativeMouseEvent.BUTTON4;
    public static final int BUTTON5 = NativeMouseEvent.BUTTON5;

    public static final int NATIVE_MOUSE_CLICKED = NativeMouseEvent.NATIVE_MOUSE_CLICKED;
    public static final int NATIVE_MOUSE_PRESSED = NativeMouseEvent.NATIVE_MOUSE_PRESSED;
    public static final int NATIVE_MOUSE_RELEASED = NativeMouseEvent.NATIVE_MOUSE_RELEASED;
    public static final int NATIVE_MOUSE_MOVED = NativeMouseEvent.NATIVE_MOUSE_MOVED;
    public static final int NATIVE_MOUSE_DRAGGED = NativeMouseEvent.NATIVE_MOUSE_DRAGGED;
    public static final int NATIVE_MOUSE_WHEEL = NativeMouseEvent.NATIVE_MOUSE_WHEEL;


    public NativeMouseEventWrapper(Environment env, NativeMouseEvent wrappedObject){
        super(env, wrappedObject);
    }

    public NativeMouseEventWrapper(Environment env, ClassEntity clazz){
        super(env, clazz);
    }

    @Signature
    public void __construct(int id, long when, int modifiers, int x, int y, int clickCount){
        __wrappedObject = new NativeMouseEvent(id, when, modifiers, x, y, clickCount);
    }

    @Signature
    public void __construct(int id, long when, int modifiers, int x, int y, int clickCount, int button){
        __wrappedObject = new NativeMouseEvent(id, when, modifiers, x, y, clickCount, button);
    }

    @Signature
    public boolean isPrimaryButtonDown(){
        return getWrappedObject().getButton() == NativeMouseEvent.BUTTON1;
    }

    @Signature
    public boolean isSecondaryButtonDown(){
        return getWrappedObject().getButton() == NativeMouseEvent.BUTTON2;
    }

    @Signature
    public boolean isMiddleButtonDown(){
        return getWrappedObject().getButton() == NativeMouseEvent.BUTTON3;
    }

    // TODO implement check modifiers methods(like isControlDown(), isShiftDown(), etc.)

    interface WrappedInterface{
        @Getter
        int getButton();

        @Getter
        int getClickCount();

        @Getter
        int getX();

        @Getter
        int getY();
    }
}