package org.develnext.jphp.ext.nativehook;

import org.develnext.jphp.ext.nativehook.classes.WrapGlobalScreen;
import org.develnext.jphp.ext.nativehook.classes.event.*;
import org.develnext.jphp.ext.nativehook.classes.keyboard.NativeKeyEventWrapper;
import org.develnext.jphp.ext.nativehook.classes.keyboard.NativeKeyListenerInterface;
import org.develnext.jphp.ext.nativehook.classes.mouse.NativeMouseEventWrapper;
import org.develnext.jphp.ext.nativehook.classes.mouse.NativeMouseListenerInterface;
import org.develnext.jphp.ext.nativehook.classes.mouse.NativeMouseMotionListenerInterface;
import org.develnext.jphp.ext.nativehook.classes.mouse.NativeMouseWheelListenerInterface;
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
		registerWrapperClass(scope, NativeInputEvent.class, NativeInputEventWrapper.class);
		registerWrapperClass(scope, NativeKeyEvent.class, NativeKeyEventWrapper.class);
		registerWrapperClass(scope, NativeMouseEvent.class, NativeMouseEventWrapper.class);
		registerWrapperClass(scope, NativeMouseWheelEvent.class, NativeMouseWheelEventWrapper.class);

		registerClass(scope, NativeKeyListenerInterface.class);
		registerClass(scope, NativeMouseListenerInterface.class);
		registerClass(scope, NativeMouseMotionListenerInterface.class);
		registerClass(scope, NativeMouseWheelListenerInterface.class);

		registerClass(scope, WrapGlobalScreen.class);
	}
}