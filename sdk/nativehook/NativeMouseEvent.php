<?php
namespace nativehook;


class NativeMouseEvent extends NativeInputEvent{
    /**
    * @var int
    */
    public $button;
    /**
    * @var int
    */
    public $clickCount;
    /**
    * @var int
    */
    public $x;
    /**
    * @var int
    */
    public $y;
}