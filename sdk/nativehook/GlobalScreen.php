<?php


namespace nativehook;


use nativehook\keyboard\NativeKeyListener;
use nativehook\mouse\NativeMouseListener;
use nativehook\mouse\NativeMouseWheelListener;

class GlobalScreen{
    public static function registerNativeHook(){}
    public static function unregisterNativeHook(){}
    public static function isNativeHookRegistered(): bool{}

    public static function addNativeKeyListener(NativeKeyListener $keyListener){}
    public static function addNativeMouseListener(NativeMouseListener $mouseListener){}
    public static function addNativeMouseMotionListener(NativeMouseListener $mouseMotionListener){}
    public static function addNativeMouseWheelListener(NativeMouseWheelListener $mouseWheelListener){}

    public static function removeNativeKeyListener(NativeKeyListener $keyListener){}
    public static function removeNativeMouseListener(NativeMouseListener $mouseListener){}
    public static function removeNativeMouseMotionListener(NativeMouseListener $mouseMotionListener){}
    public static function removeNativeMouseWheelListener(NativeMouseWheelListener $mouseWheelListener){}

    public static function dispatchEvent(NativeInputEvent $e){}
    public static function postNativeEvent(NativeInputEvent $e){}
}