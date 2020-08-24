<?php


namespace nativehook\mouse;


interface NativeMouseListener{
    public function nativeMouseClicked(NativeMouseEvent $event);

    public function nativeMousePressed(NativeMouseEvent $event);

    public function nativeMouseReleased(NativeMouseEvent $event);
}