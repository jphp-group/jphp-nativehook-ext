<?php

use nativehook\GlobalScreen;
use nativehook\keyboard\NativeKeyEvent;
use nativehook\keyboard\NativeKeyListener;
use nativehook\mouse\NativeMouseEvent;
use nativehook\mouse\NativeMouseListener;
use nativehook\mouse\NativeMouseMotionListener;
use nativehook\mouse\NativeMouseWheelEvent;
use nativehook\mouse\NativeMouseWheelListener;
use php\lang\System;

class EventListener implements NativeKeyListener, NativeMouseListener, NativeMouseMotionListener, NativeMouseWheelListener{
    public function nativeKeyReleased(NativeKeyEvent $event){
        var_dump(__FUNCTION__."- {$event->keyText}");
    }

    public function nativeKeyPressed(NativeKeyEvent $event){
        var_dump(__FUNCTION__."- {$event->keyText}");
    }

    public function nativeKeyTyped(NativeKeyEvent $event){
        var_dump(__FUNCTION__."- {$event->keyChar}");
    }

    public function nativeMouseClicked(NativeMouseEvent $event){
        var_dump(__FUNCTION__." - x: {$event->x}, y: {$event->x}, button: {$event->button}");
    }

    public function nativeMousePressed(NativeMouseEvent $event){
        var_dump(__FUNCTION__." - x: {$event->x}, y: {$event->x}, button: {$event->button}");
    }

    public function nativeMouseReleased(NativeMouseEvent $event){
        var_dump(__FUNCTION__." - x: {$event->x}, y: {$event->x}, button: {$event->button}");
    }

    public function nativeMouseMoved(NativeMouseEvent $event){
        var_dump(__FUNCTION__." - x: {$event->x}, y: {$event->x}, button: {$event->button}");
    }

    public function nativeMouseDragged(NativeMouseEvent $event){
        var_dump(__FUNCTION__." - x: {$event->x}, y: {$event->x}, button: {$event->button}");
    }

    public function nativeMouseWheelMoved(NativeMouseWheelEvent $event){
        var_dump(__FUNCTION__." - scrollType: {$event->scrollType}, scrollAmount: {$event->scrollAmount}, wheelRotation: {$event->wheelRotation}");
    }
}

class ExitListener implements NativeKeyListener{
    public function nativeKeyPressed(NativeKeyEvent $event){
        if($event->keyText == 'Escape'){
            GlobalScreen::unregisterNativeHook();
            System::halt(0);
        }
    }

    public function nativeKeyReleased(NativeKeyEvent $event){

    }

    public function nativeKeyTyped(NativeKeyEvent $event){

    }
}

$listener = new EventListener();
GlobalScreen::addNativeKeyListener($listener);
GlobalScreen::addNativeMouseListener($listener);
GlobalScreen::addNativeMouseMotionListener($listener);
GlobalScreen::addNativeMouseWheelListener($listener);

GlobalScreen::addNativeKeyListener(new ExitListener());

GlobalScreen::registerNativeHook();

echo "Press Escape to exit\n";