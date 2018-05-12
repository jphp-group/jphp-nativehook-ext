package org.develnext.jphp.ext.nativehook.classes;

import org.jnativehook.NativeInputEvent;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.memory.LongMemory;
import php.runtime.reflection.ClassEntity;
import php.runtime.annotation.Reflection;
import org.develnext.jphp.ext.nativehook.NativeHookExtension;

@Reflection.Namespace(NativeHookExtension.NS)
@Reflection.Name("NativeMouseWheelEvent")
@Reflection.Abstract
public class NativeMouseWheelEventWrapper extends NativeMouseEventWrapper<NativeMouseWheelEvent>{
	public NativeMouseWheelEventWrapper(Environment env, NativeMouseWheelEvent wrappedObject){
		super(env, wrappedObject);
	}
	public NativeMouseWheelEventWrapper(Environment env, ClassEntity clazz){
		super(env, clazz);
	}
	@Reflection.Getter
	public Memory getScrollAmount(){
		return LongMemory.valueOf(getWrappedObject().getScrollAmount());
	}
	@Reflection.Getter
	public Memory getScrollType(){
		return LongMemory.valueOf(getWrappedObject().getScrollType());
	}
	@Reflection.Getter
	public Memory getWheelRotation(){
		return LongMemory.valueOf(getWrappedObject().getWheelRotation());
	}
}