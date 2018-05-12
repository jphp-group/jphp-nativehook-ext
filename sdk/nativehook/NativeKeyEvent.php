<?php
namespace nativehook;


class NativeKeyEvent extends NativeInputEvent{
    /**
    * Имя клавиши
    * @var string
    */
    public $key;
    /**
    * Код клавиши
    * @var int
    */
    public $code;
}