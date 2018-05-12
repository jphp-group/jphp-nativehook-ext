package org.develnext.jphp.ext.nativehook.classes;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.jnativehook.mouse.NativeMouseEvent;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.memory.LongMemory;
import php.runtime.reflection.ClassEntity;

@Reflection.Namespace(NativeHookExtension.NS)
@Reflection.Name("NativeMouseEvent")
@Reflection.Abstract
public class NativeMouseEventWrapper<T extends NativeMouseEvent> extends NativeInputEventWrapper<T>{
	public NativeMouseEventWrapper(Environment env, T wrappedObject){
		super(env, wrappedObject);
	}
	public NativeMouseEventWrapper(Environment env, ClassEntity clazz){
		super(env, clazz);
	}
	@Reflection.Getter
	public Memory getClickCount(){
		return LongMemory.valueOf(getWrappedObject().getClickCount());
	}
	@Reflection.Getter
	public Memory getButton(){
		return LongMemory.valueOf(getWrappedObject().getButton());
	}
	@Reflection.Getter
	public Memory getX(){
		return LongMemory.valueOf(getWrappedObject().getX());
	}
	@Reflection.Getter
	public Memory getY(){
		return LongMemory.valueOf(getWrappedObject().getY());
	}
}
