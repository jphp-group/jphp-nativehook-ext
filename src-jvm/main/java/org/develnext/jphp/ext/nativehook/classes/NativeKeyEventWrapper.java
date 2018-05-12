package org.develnext.jphp.ext.nativehook.classes;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.jnativehook.keyboard.NativeKeyEvent;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.memory.LongMemory;
import php.runtime.memory.StringMemory;
import php.runtime.reflection.ClassEntity;


@Reflection.Namespace(NativeHookExtension.NS)
@Reflection.Name("NativeKeyEvent")
@Reflection.Abstract
public class NativeKeyEventWrapper extends NativeInputEventWrapper<NativeKeyEvent>{
	public NativeKeyEventWrapper(Environment env, NativeKeyEvent wrappedObject){
		super(env, wrappedObject);
	}
	public NativeKeyEventWrapper(Environment env, ClassEntity clazz){
		super(env, clazz);
	}
	@Reflection.Getter
	public Memory getKey(){
		return StringMemory.valueOf(NativeKeyEvent.getKeyText(getWrappedObject().getKeyCode()));
	}
	@Reflection.Getter
	public Memory getCode(){
		return LongMemory.valueOf(getWrappedObject().getKeyCode());
	}
}