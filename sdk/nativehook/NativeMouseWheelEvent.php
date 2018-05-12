<?php
namespace nativehook;


class NativeMouseWheelEvent extends NativeMouseEvent{
    /**
    * @var int
    */
    public $scrollAmount;
    /**
    * @var int
    */
    public $scrollType;
    /**
    * @var int
    */
    public $wheelRotation;
}