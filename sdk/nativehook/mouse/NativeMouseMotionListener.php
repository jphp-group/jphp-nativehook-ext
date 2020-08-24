<?php


namespace nativehook\mouse;


interface NativeMouseMotionListener{
    public function nativeMouseMoved(NativeMouseEvent $event);

    public function nativeMouseDragged(NativeMouseEvent $event);
}