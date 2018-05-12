package org.develnext.jphp.ext.nativehook;

import org.develnext.jphp.ext.nativehook.classes.*;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class NativeHookExtension extends Extension{
	public static final String NS = "nativehook";


	@Override
	public Status getStatus(){
		return Status.EXPERIMENTAL;
	}

	@Override
	public void onRegister(CompileScope scope){
		registerClass(scope, WrapNativeHook.class);
		registerWrapperClass(scope, NativeInputEvent.class, NativeInputEventWrapper.class);
		registerWrapperClass(scope, NativeKeyEvent.class, NativeKeyEventWrapper.class);
		registerWrapperClass(scope, NativeMouseEvent.class, NativeMouseEventWrapper.class);
		registerWrapperClass(scope, NativeMouseWheelEvent.class, NativeMouseWheelEventWrapper.class);
	}
}
