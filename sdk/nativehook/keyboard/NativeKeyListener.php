<?php


namespace nativehook\keyboard;


interface NativeKeyListener{
    /**
     * @param NativeKeyEvent $event
     * @return void
     */
    public function nativeKeyPressed($event);
    /**
     * @param NativeKeyEvent $event
     * @return void
     */
    public function nativeKeyReleased(NativeKeyEvent $event);
    /**
     * @param NativeKeyEvent $event
     * @return void
     */
    public function nativeKeyTyped(NativeKeyEvent $event);
}