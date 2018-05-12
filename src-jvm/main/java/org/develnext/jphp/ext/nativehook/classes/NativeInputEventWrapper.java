package org.develnext.jphp.ext.nativehook.classes;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.jnativehook.NativeInputEvent;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.lang.BaseObject;
import php.runtime.lang.BaseWrapper;
import php.runtime.memory.LongMemory;
import php.runtime.reflection.ClassEntity;

@Reflection.Namespace(NativeHookExtension.NS)
@Reflection.Name("NativeInputEvent")
@Reflection.Abstract
public class NativeInputEventWrapper<T extends NativeInputEvent> extends BaseWrapper<T>{
	public NativeInputEventWrapper(Environment env, T wrappedObject){
		super(env, wrappedObject);
	}
	public NativeInputEventWrapper(Environment env, ClassEntity clazz){
		super(env, clazz);
	}

	@Reflection.Getter
	public Memory getId(){
		return LongMemory.valueOf(getWrappedObject().getID());
	}
	@Reflection.Getter
	public Memory getWhen(){
		return LongMemory.valueOf(getWrappedObject().getWhen());
	}
}