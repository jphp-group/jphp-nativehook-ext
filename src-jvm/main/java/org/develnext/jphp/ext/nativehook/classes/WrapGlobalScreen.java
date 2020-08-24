package org.develnext.jphp.ext.nativehook.classes;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.develnext.jphp.ext.nativehook.classes.keyboard.NativeKeyListenerInterface;
import org.develnext.jphp.ext.nativehook.classes.mouse.NativeMouseListenerInterface;
import org.develnext.jphp.ext.nativehook.classes.mouse.NativeMouseMotionListenerInterface;
import org.develnext.jphp.ext.nativehook.classes.mouse.NativeMouseWheelListenerInterface;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import php.runtime.annotation.Reflection.Name;
import php.runtime.annotation.Reflection.Namespace;
import php.runtime.annotation.Reflection.Signature;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

import java.util.logging.Level;
import java.util.logging.Logger;

@Namespace(NativeHookExtension.NS)
@Name("GlobalScreen")
public final class WrapGlobalScreen extends BaseObject{
    static{
        Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.OFF);
    }
    public WrapGlobalScreen(Environment env){
        super(env);
    }
    protected WrapGlobalScreen(ClassEntity entity){
        super(entity);
    }
    public WrapGlobalScreen(Environment env, ClassEntity clazz){
        super(env, clazz);
    }

    @Signature
    private void __construct(){
        throw new IllegalStateException("Do not attempt to board the helicopter");
    }

    @Signature
    public static void addNativeKeyListener(NativeKeyListenerInterface keyListener){
        GlobalScreen.addNativeKeyListener(keyListener);
    }

    @Signature
    public static void addNativeMouseListener(NativeMouseListenerInterface mouseListener){
        GlobalScreen.addNativeMouseListener(mouseListener);
    }

    @Signature
    public static void addNativeMouseMotionListener(NativeMouseMotionListenerInterface mouseMotionListener){
        GlobalScreen.addNativeMouseMotionListener(mouseMotionListener);
    }

    @Signature
    public static void addNativeMouseWheelListener(NativeMouseWheelListenerInterface mouseWheelListener){
        GlobalScreen.addNativeMouseWheelListener(mouseWheelListener);
    }

    @Signature
    public static void removeNativeKeyListener(NativeKeyListenerInterface keyListener){
        GlobalScreen.removeNativeKeyListener(keyListener);
    }

    @Signature
    public static void removeNativeMouseListener(NativeMouseListenerInterface mouseListener){
        GlobalScreen.removeNativeMouseListener(mouseListener);
    }

    @Signature
    public static void removeNativeMouseMotionListener(NativeMouseMotionListenerInterface mouseMotionListener){
        GlobalScreen.removeNativeMouseMotionListener(mouseMotionListener);
    }

    @Signature
    public static void removeNativeMouseWheelListener(NativeMouseWheelListenerInterface mouseWheelListener){
        GlobalScreen.removeNativeMouseWheelListener(mouseWheelListener);
    }


    @Signature
    public static void registerNativeHook() throws NativeHookException{
        GlobalScreen.registerNativeHook();
    }
    @Signature
    public static void unregisterNativeHook() throws NativeHookException{
        GlobalScreen.unregisterNativeHook();
    }
    @Signature
    public static boolean isNativeHookRegistered(){
        return GlobalScreen.isNativeHookRegistered();
    }

    @Signature
    public static void dispatchEvent(NativeInputEvent e){
        GlobalScreen.dispatchEvent(e);
    }
    @Signature
    public static void postNativeEvent(NativeInputEvent e){
        GlobalScreen.postNativeEvent(e);
    }
}