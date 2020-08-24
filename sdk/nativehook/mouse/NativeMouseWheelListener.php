<?php


namespace nativehook\mouse;


interface NativeMouseWheelListener{
    public function nativeMouseWheelMoved(NativeMouseWheelEvent $event);
}