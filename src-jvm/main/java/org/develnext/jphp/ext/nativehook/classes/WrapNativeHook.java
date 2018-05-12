package org.develnext.jphp.ext.nativehook.classes;

import org.develnext.jphp.ext.nativehook.NativeHookExtension;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.*;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseObject;
import php.runtime.reflection.ClassEntity;

import java.awt.event.KeyListener;
import java.lang.annotation.Native;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Reflection.Namespace(NativeHookExtension.NS)
@Reflection.Name("NativeHook")
public class WrapNativeHook extends BaseObject{
	static{
		Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.OFF);
	}
	private Map<String,Invoker> handlers = new HashMap<>();
	private KeyListener keyListener = new KeyListener();
	private MouseListener mouseListener = new MouseListener();
	private MouseMotionListener mouseMotionListener = new MouseMotionListener();

	public WrapNativeHook(Environment env, ClassEntity clazz){
		super(env, clazz);
	}
	@Reflection.Signature
	public void __construct(){

	}
	@Reflection.Signature
	public void start(Environment env){
		try{
			if(!GlobalScreen.isNativeHookRegistered()){
				GlobalScreen.registerNativeHook();
			}
			GlobalScreen.addNativeKeyListener(keyListener);
			GlobalScreen.addNativeMouseListener(mouseListener);
			GlobalScreen.addNativeMouseMotionListener(mouseMotionListener);
		}
		catch(NativeHookException e){
			env.exception(e.getMessage());
		}
	}
	@Reflection.Signature
	public void stop(Environment env){
		try{
			GlobalScreen.removeNativeKeyListener(keyListener);
			GlobalScreen.removeNativeMouseListener(mouseListener);
			GlobalScreen.removeNativeMouseMotionListener(mouseMotionListener);
			GlobalScreen.unregisterNativeHook();
		}
		catch(NativeHookException e){
			env.exception(e.getMessage());
		}
	}
	@Reflection.Signature
	public void on(String event, Invoker handler){
		handlers.put(event, handler);
	}
	@Reflection.Signature
	public void off(String event){
		handlers.remove(event);
	}
	private void trigger(String event, Object... args){
		if(handlers.containsKey(event)){
			handlers.get(event).callAny(args);
		}
	}

	class KeyListener implements NativeKeyListener{
		@Override
		public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent){
			trigger("keyDown", nativeKeyEvent);
		}
		@Override
		public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent){
			trigger("keyUp", nativeKeyEvent);
		}
		@Override
		public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent){
			trigger("keyPress", nativeKeyEvent);
		}
	}
	class MouseListener implements NativeMouseListener{
		public void nativeMousePressed(NativeMouseEvent e) {
			trigger("mouseDown", e);
		}
		public void nativeMouseReleased(NativeMouseEvent e) {
			trigger("mouseUp", e);
		}
		public void nativeMouseClicked(NativeMouseEvent e) {
			trigger("mouseClick", e);
		}
	}
	class MouseMotionListener implements NativeMouseMotionListener{
		public void nativeMouseMoved(NativeMouseEvent e){
			trigger("mouseMove", e);
		}
		public void nativeMouseDragged(NativeMouseEvent e) {
			trigger("mouseDrag", e);
		}
	}
	class MouseWheelListener implements NativeMouseWheelListener{
		@Override
		public void nativeMouseWheelMoved(NativeMouseWheelEvent nativeMouseWheelEvent){
			trigger("mouseWheel", nativeMouseWheelEvent);
		}
	}
}
