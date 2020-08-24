package org.develnext.jphp.ext.nativehook.classes.keyboard;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.develnext.jphp.ext.nativehook.classes.event.NativeInputEventWrapper;
import org.jnativehook.keyboard.NativeKeyEvent;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Namespace(NativeHookExtension.NS+"\\keyboard")
@Name("NativeKeyEvent")
public class NativeKeyEventWrapper extends NativeInputEventWrapper<NativeKeyEvent>{
    public static final int NATIVE_KEY_PRESSED = NativeKeyEvent.NATIVE_KEY_PRESSED;
    public static final int NATIVE_KEY_RELEASED = NativeKeyEvent.NATIVE_KEY_RELEASED;
    public static final int NATIVE_KEY_TYPED = NativeKeyEvent.NATIVE_KEY_TYPED;

    public NativeKeyEventWrapper(Environment env, NativeKeyEvent wrappedObject){
        super(env, wrappedObject);
    }
    public NativeKeyEventWrapper(Environment env, ClassEntity clazz){
        super(env, clazz);
    }

    @Signature
    public void __construct(int id, long when, int modifiers, int rawCode, int keyCode, char keyChar){
        __wrappedObject = new NativeKeyEvent(id, when, modifiers, rawCode, keyCode, keyChar);
    }

    @Signature
    public void __construct(int id, long when, int modifiers, int rawCode, int keyCode, char keyChar, int keyLocation){
        __wrappedObject = new NativeKeyEvent(id, when, modifiers, rawCode, keyCode, keyChar, keyLocation);
    }

    @Getter
    public String getKeyText(){
        return NativeKeyEvent.getKeyText(getWrappedObject().getKeyCode());
    }

    @Signature
    public static String getKeyText(int keyCode){
        return NativeKeyEvent.getKeyText(keyCode);
    }

    interface WrappedInterface{
        @Getter char getKeyChar();
        @Setter void setKeyChar(char keyChar);

        @Getter int getKeyCode();
        @Setter void setKeyCode(int keyCode);

        @Getter int getRawCode();
        @Getter void setRawCode(int rawCode);

        @Getter int getKeyLocation();

        @Getter("isActionKey") boolean isActionKey();
    }
}