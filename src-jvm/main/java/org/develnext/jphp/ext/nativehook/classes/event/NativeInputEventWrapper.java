package org.develnext.jphp.ext.nativehook.classes.event;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.lang.BaseWrapper;
import php.runtime.reflection.ClassEntity;

@Namespace(NativeHookExtension.NS)
@Name("NativeInputEvent")
public class NativeInputEventWrapper<C extends NativeInputEvent> extends BaseWrapper<NativeInputEvent>{
    public NativeInputEventWrapper(Environment env, C wrappedObject){
        super(env, wrappedObject);
    }
    public NativeInputEventWrapper(Environment env, ClassEntity clazz){
        super(env, clazz);
    }

    @Signature
    public void __construct(int type, long when, int modifiers){
        __wrappedObject = new NativeInputEvent(GlobalScreen.class, type, when, modifiers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public C getWrappedObject(){
        return (C) super.getWrappedObject();
    }

    interface WrappedInterface{
        @Getter("type") int getID();

        @Getter int getModifiers();
        @Setter void setModifiers(int modifiers);

        @Getter long getWhen();

        // @Getter("paramString")
        String paramString();
    }
}