<?php


namespace nativehook\keyboard;


use nativehook\NativeInputEvent;

class NativeKeyEvent extends NativeInputEvent{
    /**
     * @var string
     * @readonly
     */
    public $keyText;
    /**
     * @var string
     */
    public $keyChar;
    /**
     * @var int
     */
    public $keyCode;
    /**
     * @var int
     */
    public $rawCode;
    /**
     * @var int
     */
    public $keyLocation;
    /**
     * @var bool
     */
    public $isActionKey;

    const NATIVE_KEY_PRESSED = 2401;
    const NATIVE_KEY_RELEASED = 2402;
    const NATIVE_KEY_TYPED = 2400;

    public function __construct(int $id, int $when, int $modifiers, int $rawCode, int $keyCode, string $keyChar, int $keyLocation = 0){

    }

    /**
     * @return string
     */
    public static function getKeyText(int $keyCode){

    }
}