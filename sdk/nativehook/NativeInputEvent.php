<?php


namespace nativehook;


class NativeInputEvent{
    /**
     * @var int
     * @readonly
     */
    public $type;
    /**
     * @var int
     */
    public $modifiers;
    /**
     * @var int
     * @readonly
     */
    public $when;

    public function __construct(int $type, int $when, int $modifiers){

    }

    /**
     * @return string
     */
    public function paramString(){

    }
}